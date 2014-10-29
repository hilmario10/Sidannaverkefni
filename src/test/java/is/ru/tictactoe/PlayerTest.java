package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

	public class PlayerTest {
		
		//Checks if the players names is correctly set
		@Test
		public void testsetName() {
			
			Player p = new Player("", 1);
			p.setName("Truman");
			assertEquals("Truman", p.getName());
		}		

		//Checks if PlayerID is set right
		@Test
		public void testsetPlayerID() {
			
			Player p = new Player("", 1);
			p.setPlayerID(2);
			assertEquals(2, p.getPlayerID());
		}		
}