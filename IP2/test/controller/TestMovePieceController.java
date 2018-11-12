package controller;

import application.Application;
import junit.framework.TestCase;
import model.Model;
import model.Piece;

public class TestMovePieceController extends TestCase {
	public void testMove() {
		Model m = Model.defaultModel();
		Application app = new Application(m);
	
		app.setVisible(true);
		
		Piece piece= m.getList().get(0);
		m.makeSelected(piece);
		
		MovePieceController mpc = new MovePieceController(m, app);
		assertFalse(mpc.movePiece("RIGHT"));
		assertFalse(mpc.movePiece("LEFT"));
		assertFalse(mpc.movePiece("UP"));
		assertFalse(mpc.movePiece("DOWN"));
		
		piece = m.getList().get(9);
		m.makeSelected(piece);
		
		assertTrue(mpc.movePiece("RIGHT"));
		assertTrue(mpc.movePiece("LEFT"));
	}
}
