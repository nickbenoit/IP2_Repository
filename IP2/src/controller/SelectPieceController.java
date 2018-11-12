package controller;

import java.awt.Point;
import java.util.Iterator;

import application.Application;
import model.Model;
import model.Piece;

/*
 * Use Case: 			Select Piece
 * Participating Actor: Initiated by User
 * Entry Criteria:		N/A
 * Exit Criteria:		Piece is selected
 * Flow of Events:
 * 		1. The User requests to select a Piece
 * 		2. The System makes the Piece selected and updates the display
 */

public class SelectPieceController {
	/** Attributes **/
	Model model;
	Application app;
	
	/** Constructor **/
	public SelectPieceController(Model m, Application a) {
		this.model = m;
		this.app = a;
	}
	
	/** Methods **/
	/* 
	 * User requests to make the piece selected. If a piece exists at the point of the mouse click,
	 * it becomes the selected piece.
	 */
	public void selectPiece(Point point) {
		// If the user clicks in the non-piece areas, this will remain false
		Boolean pieceSelected = false;
		
		// Iteratively check the pieces to see if one of them contains the mouse click point
		Iterator<Piece> it = model.iterator();
		while (it.hasNext() && !pieceSelected) {
			Piece piece = it.next();		
			// Check piece for point where mouse was clicked
			if (withinPiece(point, piece)) {
				// Make it selected
				model.makeSelected(piece);
				pieceSelected = true;
			}
		}
		
		// Update the display
		app.repaint();
	}
	
	// Check if a piece exists at the point of the mouse click.
	public boolean withinPiece(Point point, Piece piece) {
		if (piece.getXCoord() <= point.getX() && 
			piece.getXCoord() + piece.getWidth() >= point.getX() &&
			piece.getYCoord() <= point.getY() &&
			piece.getYCoord() + piece.getHeight() >= point.getY()) {
			return true;
		} else {
			return false;
		}
	}
}
