package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class GameLogic{

    public static Board b = new Board();
	public static Player pOne = new Player("", 0);
	public static Player pTwo = new Player("", 1);
	public static boolean keepPlaying = true;
	public static boolean hasMoved = false;

	public static void main(String [] args) {

		staticFileLocation("/public");
		String port = System.getenv("PORT");

       	if (port != null) {
       		setPort(Integer.valueOf(port));
        }

        post(new Route("/name") {
        	@Override
        	public Object handle(Request request, Response response){
        		
        		String p1 = String.valueOf(request.queryParams("p1"));
        		String p2 = String.valueOf(request.queryParams("p2"));


        		if (p1 == "") {
        			pOne.setName("Player_1");
        		}

        		if (p2 == "") {
        			pTwo.setName("Player_2");
        		}
        		pOne.setName(p1);
        		pTwo.setName(p2);

				return true;
        	}
        });

       /* post(new Route("/move"){
        	@Override
        	public Object handle(Request request, Response response){
        		String playerID = String.valuef(request.queryParams("player"));
        		String x = String.valueOf(request.queryParams("fieldID-x"));
        		String y = String.valueOf(request.queryParams("fieldID-y"));
        		int newX = Integer.parseInt(x);
        		int newY = Integer.parseInt(y);
        		String madeMove = "";

        		int pID = Integer.parseInt(playerID);
        		if(pID == 0){
        			madeMove = b.setMove(0, newX, newY);
        		}
        		else if(pID == 1){
        			madeMove = b.setMove(1, newX, newY);
        		}
        		return madeMove;
        	}
        })*/


	}
}
