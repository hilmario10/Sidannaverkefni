package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class Player {
	
	//Variables for player.
	private String nameOfPlayer;
	private int playerID;

	// Constructor for player.
	public Player(String name, int pID){
		nameOfPlayer = name;
		playerID = pID;
	}

	// Returns player name.
	public String getName(){
		return nameOfPlayer;
	}

	// Sets player name.
	public void setName(String name){
		nameOfPlayer = name;
	}

	// Returns player ID.
	public int getPlayerID(){
		return playerID;
	}

	// Sets player ID.
	public void setPlayerID(int pID){
		playerID = pID;
	}
}
