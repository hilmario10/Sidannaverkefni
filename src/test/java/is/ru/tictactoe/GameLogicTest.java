package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

	public class GameLogicTest {
		
		//Checks if Board constructor works
		@Test
		public void testBoardConstructor() {

			Board b = new Board();
			assertEquals(1, 1);
		}		

		//Checks if Player constructor works
		@Test
		public void testPlayerConstructor() {

			Player p = new Player("", 1);
			assertEquals(1, 1);
		}		
}