package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
		
	// Checks if Player makes legal move
	@Test
	public void testLegalMove() {
		Board b = new Board();
		assertEquals(true, b.LegalMove(1));
		assertEquals(true, b.LegalMove(2));
		assertEquals(false, b.LegalMove(3));
		assertEquals(false, b.LegalMove(-2));
		assertEquals(false, b.LegalMove(4));
	}	

	// Check if move from player is correct
	@Test
	public void testSetMove	() {
		Board b = new Board();
		b.SetMove(1, 2, 0);
		b.SetMove(0, 1, 2);
		b.SetMove(0, 1, 1);
		assertEquals("O", b.GetStateOfField(2, 0));
		assertEquals("X", b.GetStateOfField(1, 2));
		assertEquals("X", b.GetStateOfField(1, 1));
	}

	// Check if field on board is taken
	@Test
	public void testCheckIfFree () {
		Board b = new Board();
		b.SetMove(0,1,1);
		assertEquals(false, b.CheckIfFree(1,1));
		assertEquals(true, b.CheckIfFree(2,2));
		assertEquals(true, b.CheckIfFree(0,0));
		assertEquals(true, b.CheckIfFree(2,1));
		assertEquals(true, b.CheckIfFree(1,0));
	}

	// Check if Board is full
	@Test
	public void testCheckIfFull() {
		Board b = new Board();
		b.SetMove(0, 0, 0);
		b.SetMove(1, 0, 1);
		b.SetMove(0, 0, 2);
		assertEquals(false, b.CheckIfFull());
		b.SetMove(1, 1, 0);
		b.SetMove(0, 1, 1);
		assertEquals(false, b.CheckIfFull());
		b.SetMove(1, 1, 2);
		b.SetMove(0, 2, 0);
		assertEquals(false, b.CheckIfFull());
		b.SetMove(1, 2, 1);
		b.SetMove(0, 2, 2);
		assertEquals(true, b.CheckIfFull());
	}

	// Check to see if field on board is free, if not then what player is there
	@Test
	public void testGetStateOfField() {
		Board b = new Board();
		b.SetMove(0, 0, 2);
		b.SetMove(1, 1, 1);
		b.SetMove(0, 2, 2);
		b.SetMove(1, 2, 1);
		assertEquals("X", b.GetStateOfField(0 ,2));
		assertEquals("O", b.GetStateOfField(1 ,1));
		assertEquals("X", b.GetStateOfField(2 ,2));
		assertEquals("O", b.GetStateOfField(2 ,1));
	}

	// Check if player has three in a row and wins the game
	@Test
	public void testCheckIfWon() {
		//Check if player has  three in a row vertical
		Board bVerticalWon = new Board();
		bVerticalWon.SetMove(0, 0, 0);
		bVerticalWon.SetMove(1, 1, 1);
		bVerticalWon.SetMove(0, 1, 0);
		assertEquals(false, bVerticalWon.CheckIfWon(0));
		bVerticalWon.SetMove(1, 0, 2);
		bVerticalWon.SetMove(0, 2, 0);
		assertEquals(true, bVerticalWon.CheckIfWon(0));

		//Check if player has  three in a row horizontal
		Board bHorizontalWon = new Board();
		bHorizontalWon.SetMove(0, 0, 0);
		bHorizontalWon.SetMove(1, 1, 1);
		bHorizontalWon.SetMove(0, 0, 1);
		assertEquals(false, bHorizontalWon.CheckIfWon(0));
		bHorizontalWon.SetMove(1, 2, 0);
		bHorizontalWon.SetMove(0, 0, 2);
		assertEquals(true, bHorizontalWon.CheckIfWon(0));

		//Check if player has  three in a row diagonal
		Board bDiagonalWon = new Board();
		bDiagonalWon.SetMove(0, 0, 0);
		bDiagonalWon.SetMove(1, 0, 1);
		bDiagonalWon.SetMove(0, 1, 1);
		assertEquals(false, bDiagonalWon.CheckIfWon(0));
		bDiagonalWon.SetMove(1, 2, 0);
		bDiagonalWon.SetMove(0, 2, 2);
		assertEquals(true, bDiagonalWon.CheckIfWon(0));
	}

	// Check if illegal move throws exception
	@Test
	public void testIllegalMoveThrowException() {
		try{
			Board.LegalMove(-3);
		}
		catch(IllegalArgumentException e){
			String message = e.getMessage();
   			assertEquals("Hnit ekki leyfilegt: [-3]", message);
		}
	}

	// Check if board is full and game is tie
	@Test
	public void testGameTie() {
		Board b = new Board();
		b.SetMove(0, 0, 0);
		b.SetMove(1, 1, 1);
		b.SetMove(0, 1, 2);
		b.SetMove(0, 0, 2);
		b.SetMove(1, 2, 0);
		b.SetMove(0, 1, 0);
		b.SetMove(0, 2, 1);
		b.SetMove(1, 2, 2);
		b.SetMove(0, 0, 1);
		assertEquals(true, b.CheckIfFull());
	}
	
}

