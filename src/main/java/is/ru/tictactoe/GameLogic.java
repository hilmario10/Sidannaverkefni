package is.ru.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class GameLogic implements SparkApplication {

	public static Player pOne = new Player("",0);
	public static Player pTwo = new Player("",1);
  public static Board b = new Board();

	public static void main(String [] args){
        staticFileLocation("/public");
        SparkApplication gamelogic = new GameLogic();
		    String port = System.getenv("PORT");

       	if (port != null){
          setPort(Integer.valueOf(port));
        }
        gamelogic.init();
    }

    public void init(){
        //final Board b = new Board();
        post(new Route("/name"){
           	@Override
           	public Object handle(Request request, Response response){
           		String p1 = String.valueOf(request.queryParams("p1"));
           		String p2 = String.valueOf(request.queryParams("p2"));

           		if (p1 == ""){
           			pOne.setName("Anonymous");
           		}

           		if (p2 == ""){
           			pTwo.setName("Anonymous");
           		}

           		pOne.setName(p1);
           		pTwo.setName(p2);

              return true;
           	}
        });

        post(new Route("/move"){
           	@Override
           	public Object handle(Request request, Response response){ 
              Integer playerID = Integer.parseInt(request.queryParams("player"));
           		Integer colID = Integer.parseInt(request.queryParams("colid"));
           		int x = 0;
           		int y = 0;
           		String result = "";

                if (b.keepPlaying){
                        
               		switch(colID) {
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

               		if(playerID == 0){
               			result = b.SetMove(0, x, y);
               		}
               		else if(playerID == 1){
               			result = b.SetMove(1, x, y);
               		}

               		return result;
                }
                return null;
       		}
        });

        post(new Route("/newgame"){
            @Override
            public Object handle(Request request, Response response){
                b.Init();
                b.keepPlaying = true;
                return true;
            }
        });

    }
}
