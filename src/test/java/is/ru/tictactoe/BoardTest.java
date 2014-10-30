package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

	public class BoardTest {
		
		//Checks if Player makes legal move
		@Test
		public void testLegalMove() {
			assertEquals(true, Board.LegalMove(1));
			assertEquals(true, Board.LegalMove(2));
			assertEquals(false, Board.LegalMove(3));
			assertEquals(false, Board.LegalMove(-2));
			assertEquals(false, Board.LegalMove(4));
		}	

		//Check if move from player is correct
		@Test
		public void testSetMove	(){
			Board newboard = new Board();

			newboard.SetMove(1, 2, 0);
			newboard.SetMove(0, 1, 2);
			newboard.SetMove(0, 1, 1);
			assertEquals(2, newboard.GetStateOfField(2, 0));
			assertEquals(1, newboard.GetStateOfField(1, 2));
			assertEquals(1, newboard.GetStateOfField(1, 1));
		}


		@Test
		public void testCheckIfFree ()
		{
			Board b = new Board();
			b.SetMove(0,1,1);
			assertEquals(false,b.CheckIfFree(1,1));
			assertEquals(true,b.CheckIfFree(2,2));
		}
}

