package model;

import junit.framework.TestCase;

public class TestPiece extends TestCase {
	public void testCoord() {
		// Create a new piece
		Piece piece = new Piece(0,0,100,100);
		
		// Check that dimensions are correct, assert true
		assertEquals(100, piece.getWidth());
		assertEquals(100, piece.getHeight());
		
		// Modify coordinates of the piece
		assertTrue(piece.setXCoord(100));
		assertTrue(piece.setYCoord(100));
		
		// Check that origin has changed
		assertEquals(100, piece.getXCoord());
		assertEquals(100, piece.getYCoord());
		
		// Piece was not set as primary, assert false
		assertFalse(piece.isPrimary());
	}
}
