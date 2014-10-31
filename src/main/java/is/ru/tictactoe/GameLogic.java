package is.ru.tictactoe;
import java.util.Scanner;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class GameLogic {

	public static Board b = new Board();
	public static Scanner in = new Scanner(System.in);
				
	public static Player one = new Player("", 0);
	public static Player two = new Player("", 1);
	public static boolean keepPlaying = true;
	public static boolean hasMoved = false;
        	
	public static final int PORT = 4567;

	public static void main(String [] args)
	{
		 staticFileLocation("/public");
        

       	/*if (System.getenv("PORT") == null) {

            setPort(PORT);
        }
        else {

            setPort(Integer.valueOf(System.getenv("PORT")));
        }

        //
        post(new Route("/add"){
        	@Override
        	public Object handleObject(Request request, Response response){
        		
				one.setName("Leik1");
				two.setName("leik2");

				return true;
        	}
        });


        //Play function with response.
        post(new Route("/play"){
        	@Override
        	public Object handleObject(Request request, Response response){

        	}
        });*/


		//NewGame();
	}

	/*public static void NewGame(){
		int whichPlayer = 0;


		System.out.println("Player 1 please enter your name");
		one.setName(in.nextLine());
		System.out.println("Player 2 please enter your name");
		two.setName(in.nextLine());

		while(keepPlaying){
			if(whichPlayer == 0){
				while(!hasMoved){
					System.out.println(one.getName() + " Please enter your X cord move");
					int x = in.nextInt();
					System.out.println(one.getName() + " Please enter your Y cord move");
					int y = in.nextInt();
					b.SetMove(one.getPlayerID(), x, y);
					b.PrintBoard();
				}
					whichPlayer = 1;
					hasMoved = false;
			}
			else{
				while(!hasMoved){
					System.out.println(two.getName() + " Please enter your X cord move");
					int x = in.nextInt();
					System.out.println(two.getName() + " Please enter your Y cord move");
					int y = in.nextInt();
					b.SetMove(two.getPlayerID(), x, y);
					b.PrintBoard();
				}
					whichPlayer = 0;
					hasMoved = false;
			}
			//hasMoved = false;
		}
	}*/

}
