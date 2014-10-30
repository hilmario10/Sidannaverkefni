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

		//Check if field on board is taken.
		@Test
		public void testCheckIfFree ()
		{
			Board b = new Board();
			b.SetMove(0,1,1);
			assertEquals(false,b.CheckIfFree(1,1));
			assertEquals(true,b.CheckIfFree(2,2));
		}

		//Check if Board is full.
		@Test
		public void testCheckIfFull(){
			Board bFull = new Board();

			bFull.SetMove(0, 0, 0);
			bFull.SetMove(1, 0, 1);
			bFull.SetMove(0, 0, 2);
			assertEquals(false, bFull.CheckIfFull());
			bFull.SetMove(1, 1, 0);
			bFull.SetMove(0, 1, 1);
			assertEquals(false, bFull.CheckIfFull());
			bFull.SetMove(1, 1, 2);
			bFull.SetMove(0, 2, 0);
			assertEquals(false, bFull.CheckIfFull());
			bFull.SetMove(1, 2, 1);
			bFull.SetMove(0, 2, 2);
			assertEquals(true, bFull.CheckIfFull());
		}

		@Test
		public void testGetStateOfField(){
			Board gState = new Board();

			gState.SetMove(0, 0, 2);
			gState.SetMove(1, 1, 1);
			gState.SetMove(0, 2, 2);
			gState.SetMove(1, 2, 1);
			assertEquals(1, gState.GetStateOfField(0 ,2));
			assertEquals(2, gState.GetStateOfField(1 ,1));
			assertEquals(1, gState.GetStateOfField(2 ,2));
			assertEquals(2, gState.GetStateOfField(2 ,1));

		}
}

