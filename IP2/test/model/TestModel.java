package model;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	// Test the initialization of a new model
	public void testInit() {
		// Create a new model
		Model m = Model.defaultModel();
		// Model contains ten pieces, assert true
		assertEquals(10, m.list.size());
	}
	
	// Test selection
	public void testSelect() {
		// Create a new model
		Model m = Model.defaultModel();
		
		// Get the first two pieces
		Piece piece1 = m.list.get(1);
		Piece piece2 = m.list.get(2);
		
		// No piece is selected, assert false
		assertFalse(m.isSelected(piece1));
		
		// Select piece one
		m.makeSelected(piece1);
		// Piece one is selected, assert true
		assertTrue(m.isSelected(piece1));
		// Piece one is selected, assert false
		assertFalse(m.isSelected(piece2));		
		// Piece one is selected, assert true
		assertEquals(piece1, m.getSelected());
	}
	
	// Test counter
	public void testCounter() {
		// Create new model
		Model m = Model.defaultModel();
		
		// No moves have been made, assert true
		assertEquals(0, m.moves());
		
		// Increment the move counter
		m.incrementCounter();
		// One move has been made, assert true
		assertEquals(1, m.moves());
		
		// Reset the counter
		m.resetCounter();
		// Counter is reset to zero, assert true
		assertEquals(0, m.moves());
	}
}
