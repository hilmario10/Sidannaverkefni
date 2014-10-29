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

}