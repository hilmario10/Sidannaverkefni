package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class GameLogic{

	public static Player pOne = new Player("", 0);
	public static Player pTwo = new Player("", 1);
	public static boolean keepPlaying = true;
	public static boolean hasMoved = false;
    public static Board b = new Board();

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

        post(new Route("/move"){
        	@Override
        	public Object handle(Request request, Response response){
        		String playerID = String.valueOf(request.queryParams("player"));
        		int pID = Integer.parseInt(playerID);
        		String whatField = String.valueOf(request.queryParams("cellClicked"));
        		int getCords = Integer.parseInt(whatField);
        		int x = 0;
        		int y = 0;
        		String result = "";
	        		switch(getCords){
	        			case 0:	
	        					x = 0;
	        					y = 0;
	        					break;
	        			case 1: 
	        					x = 0;
	        					y = 1;
	        					break;
	        			case 2:
	        					x = 0;
	        					y = 2;
	        					break;
	        			case 3:
	        					x = 1;
	        					y = 0;
	        					break;
	        			case 4:
	        					x = 1;
	        					y = 1;
	        					break;
	        			case 5:
	        					x = 1;
	        					y = 2;
	        					break;
	        			case 6:
	        					x = 2;
	        					y = 0;
	        					break;
	        			case 7:
	        					x = 2;
	        					y = 1;
	        					break;
	        			case 8:
	        					x = 2;
	        					y = 2;
	        					break;	
	        			}			

		        		if(pID == 0){
		        			result = b.SetMove(0, x, y);
		        		}
		        		else if(pID == 1){
		        			result = b.SetMove(1, x, y);
		        		}
	        		return result;
        		}
        });


	}
}
