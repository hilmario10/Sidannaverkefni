package is.ru.tictactoe;

	public class Board {
	
	int ROW = 3;
	int COL = 3;

	public static final int FREE = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;

	int [][] BOARD = new int [ROW][COL];

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
	public void SetMove(int pID, int x, int y){

		switch(pID){
			case 0: 
				 if(LegalMove(x)){
					if(LegalMove(y)){
						if(CheckIfFree(x, y)){
							BOARD[x][y] = ONE;
						}
						if(CheckIfWon(pID)){
							System.out.println("Til hamingju Thu hefur unnid leikinn");
						}
						if(CheckIfFull()){
							System.out.println("Leikur endar i jafntefli ");
						}
					}
				}
			case 1:  
				if(LegalMove(x)){
					if(LegalMove(y)){
						if(CheckIfFree(x, y)){
							BOARD[x][y] = TWO;
						}
						if(CheckIfWon(pID)){
							System.out.println("Til hamingju  Thu hefur unnid leikinn");
						}
						if(CheckIfFull()){
							System.out.println("Leikur endar i jafntefli ");
						}
					}
				}
		}
	}

	public boolean CheckIfWon(int pID){
		switch(pID){
			case 0:  
				if(BOARD[0][0] == ONE && BOARD[1][1] == ONE && BOARD[2][2] == ONE
				|| BOARD[2][0] == ONE && BOARD[1][1] == ONE && BOARD[0][2] == ONE){
					return true;
				}
				else{
					for(int i = 0; i < ROW; i++){
						for(int j = 0; j < COL; j++){
							if(BOARD[i][0] == ONE && BOARD[i][1] == ONE && BOARD[i][2] == ONE){
								return true;
							}
							else if(BOARD[0][j] == ONE && BOARD[1][j] == ONE && BOARD[2][j] == ONE){
								return true;
							}
						}
					}
					return false;
				}

			case 1:  
				if(BOARD[0][0] == TWO && BOARD[1][1] == TWO && BOARD[2][2] == TWO
				|| BOARD[2][0] == TWO && BOARD[1][1] == TWO && BOARD[0][2] == TWO){
					return true;
				}
				else{
					for(int i = 0; i < ROW; i++){
						for(int j = 0; j < COL; j++){
							if(BOARD[i][0] == TWO && BOARD[i][1] == TWO && BOARD[i][2] == TWO){
								return true;
							}
							else if(BOARD[0][j] == TWO && BOARD[1][j] == TWO && BOARD[2][j] == TWO){
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
	public int GetStateOfField(int x, int y){
		return BOARD[x][y];
	}



}