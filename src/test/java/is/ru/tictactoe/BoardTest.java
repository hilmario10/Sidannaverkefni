package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

	public class BoardTest {
		
		//Checks if the board is 3x3
		@Test
		public void testLegalMove() {
			assertEquals(true, Board.LegalMove(1));
			assertEquals(true, Board.LegalMove(2));
			assertEquals(true, Board.LegalMove(3));
			assertEquals(false, Board.LegalMove(-2));
			assertEquals(false, Board.LegalMove(4));
		}		
}