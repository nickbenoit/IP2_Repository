package controller;

import java.awt.Point;

import application.Application;
import application.TestGUI;
import model.Model;
import model.Piece;

public class TestSelectPieceController extends TestGUI{	
	public void testSelect() {
		Model m = Model.defaultModel();
		Application app = new Application(m);
	
		app.setVisible(true);
		
		Piece piece= m.getList().get(0);
		SelectPieceController spc = new SelectPieceController(m, app);
		
		Point point = new Point(10,10);
		spc.selectPiece(point);
		
		assertTrue(m.isSelected(piece));
	}
}
