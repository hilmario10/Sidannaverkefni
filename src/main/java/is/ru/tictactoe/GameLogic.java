package is.ru.tictactoe;

import java.util.Scanner;

public class GameLogic {

	public static Board b = new Board();
	public static Scanner in = new Scanner(System.in);
	
	public static Player one = new Player("", 0);
	public static Player two = new Player("", 1);

	public static void main(String [] args)
	{
		one.setName(in.nextLine());
		two.setName(in.nextLine());

		System.out.println(one.getName());
		System.out.println(two.getName());
		b.SetMove(one.getPlayerID(), 1, 2);
		b.SetMove(two.getPlayerID(), 1, 0);
		b.PrintBoard();
			
	}
}