package is.ru.tictactoe;
import java.util.Scanner;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class GameLogic implements SparkApplication {

	public static Player pOne = new Player("", 0);
	public static Player pTwo = new Player("", 1);

	public static void main(String [] args) {

		staticFileLocation("/public");
        SparkApplication webUI = new GameLogic();
		String port = System.getenv("PORT");

       	if (port != null) {
       		setPort(Integer.valueOf(port));
        }

        post(new Route("/name"){
        	@Override
        	public Object handle(Request request, Response response){
        		
        		Board b = new Board();
        		String p1 = String.valueOf(request.queryParams("p1"));
        		String p2 = String.valueOf(request.queryParams("p2"));

        		if (p1 == "") {
        			pOne.setName("Player_1");
        		}

        		if (p2 == "") {
        			pTwo.setName("Player_2");
        		}

				return true;
        	}
        });

	}
}
