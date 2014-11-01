package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class Board {
	
	public static final int ROW = 3;
	public static final int COL = 3;

	public static final int FREE = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;

	public static final int [][] BOARD = new int [ROW][COL];

	public static boolean keepPlaying = true;
	//public static boolean hasMoved = false;

	//Constructor for Board/
	public Board(){
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COL; j++){
				BOARD[i][j] = FREE;
			}
		}
	}

	// Check if move from player is out of bounds.
	public static boolean LegalMove(int xy){
			if(xy < 0 || xy > 2){
			return false;
		}
		return true;
	}

	// Check if BOARD is full, If BOARD is full then the game ends in a tie.
	public boolean CheckIfFull(){
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COL; j++){
				if(BOARD[i][j] == FREE){
					return false;
				}
			}
		}
		return true;
	}
	
	// Sets a players move on the BOARD. 
	public String SetMove(int pID, int x, int y){

		switch(pID){
			case 0: 
				if(LegalMove(x)){
					if(LegalMove(y)){
						if(CheckIfFree(x, y)){
							BOARD[x][y] = ONE;
							//hasMoved = true;
							
							if(CheckIfWon(pID)){
								keepPlaying = false;
								//System.out.println("Congrats " + GameLogic.pOne.getName() + " you have won the game");
								return "p1:hasWon";
							}
							if(CheckIfFull()){
								keepPlaying = false;
								//System.out.println("Tie");
								return"p1:gameTied";
							}
							return "p1:go";
						}
						else{
							System.out.println("P2 - This field is occupied");
							return "p1:occupied";
						}
					}
					else{
						//return "p1:illegalY";
						throw new IllegalArgumentException("Y-cord not allowed");
					}
				}
				else{
					//return "p1:illegalX";
					throw new IllegalArgumentException("X-cord not allowed");
				}
			case 1: 
				if(LegalMove(x)){
					if(LegalMove(y)){
						if(CheckIfFree(x, y)){
							BOARD[x][y] = TWO;
							//hasMoved = true;
							
							if(CheckIfWon(pID)){
								keepPlaying = false;
								//System.out.println("Congrats "  + GameLogic.pTwo.getName() + " you have won the game");
								return "p2:hasWon";
							}
							if(CheckIfFull()){
								keepPlaying = false;
								//System.out.println("Tie");
								return "p2:gameTied";
							}
							return "p2:go";
						}
						else{
							System.out.println("P1 - This field is occupied");
							return "p2:occupied";
						}
					}
					else{
						//return "p2:illegalY";
						throw new IllegalArgumentException("Y-cord not allowed");
					}
				}
				else{
					//return "p2;illegalX";
					throw new IllegalArgumentException("X-cord not allowed");
				}
		}
		return "Unknown error";
	}

	public boolean CheckIfWon(int pID){
		switch(pID){
			case 0:  
				if(BOARD[0][0] == ONE && BOARD[1][1] == ONE && BOARD[2][2] == ONE
				|| BOARD[2][0] == ONE && BOARD[1][1] == ONE && BOARD[0][2] == ONE){
					keepPlaying = false;
					return true;
				}
				else{
					for(int i = 0; i < ROW; i++){
						for(int j = 0; j < COL; j++){
							if(BOARD[i][0] == ONE && BOARD[i][1] == ONE && BOARD[i][2] == ONE){
								keepPlaying = false;
								return true;
							}
							else if(BOARD[0][j] == ONE && BOARD[1][j] == ONE && BOARD[2][j] == ONE){
								keepPlaying = false;
								return true;
							}
						}
					}
					return false;
				}

			case 1:  
				if(BOARD[0][0] == TWO && BOARD[1][1] == TWO && BOARD[2][2] == TWO
				|| BOARD[2][0] == TWO && BOARD[1][1] == TWO && BOARD[0][2] == TWO){
					keepPlaying = false;
					return true;
				}
				else{
					for(int i = 0; i < ROW; i++){
						for(int j = 0; j < COL; j++){
							if(BOARD[i][0] == TWO && BOARD[i][1] == TWO && BOARD[i][2] == TWO){
								keepPlaying = false;
								return true;
							}
							else if(BOARD[0][j] == TWO && BOARD[1][j] == TWO && BOARD[2][j] == TWO){
								keepPlaying = false;
								return true;
							}
						}
					}
					return false;
				}
		}
		return false;

	}
	// Check if Field on the BOARD is free to make a move.
	public boolean CheckIfFree(int x, int y){
		if(BOARD[x][y] == FREE){
			return true;
		}
		return false;
	}
	
	// Returns if field on BOARD id free, if not the what player has there token on that field.
	public String GetStateOfField(int x, int y){
		if(BOARD[x][y] == FREE){
			return "-";
		}
		else if(BOARD[x][y] == ONE){
			return "X";
		}
		else{
			return "O";
		}
	}

	public void PrintBoard(){
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COL; j++){
				System.out.print("| " + GetStateOfField(i, j) + " |");
			}
			System.out.println();
			System.out.println("---------------");
		}
	}
	


}