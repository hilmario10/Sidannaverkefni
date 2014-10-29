package is.ru.tictactoe;


public class Player {
	String nameOfPlayer;
	int playerID;

	public Player(String name, int pID){
		nameOfPlayer = name;
		playerID = pID;
	}

	public String getName(){
		return nameOfPlayer;
	}

	public void setName(String name){
		nameOfPlayer = name;
	}

	public int getPlayerID(){
		return playerID;
	}

	public void setPlayerID(int pID){
		playerID = pID;
	}

}
