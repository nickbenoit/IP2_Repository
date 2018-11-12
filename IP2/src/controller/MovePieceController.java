package controller;

import java.util.Iterator;

import application.Application;
import model.Model;
import model.Piece;

/*
 * Use Case: 			Move Piece
 * Participating Actor: Initiated by User
 * Entry Criteria:		A Piece is selected
 * Exit Criteria:		Piece is moved in the requested direction
 * Flow of Events:
 * 		1. The User requests to move a selected Piece
 * 		2. The System moves the Piece and updates the display
 */

public class MovePieceController {
	/** Attributes **/
	Model model;
	Application app;
	
	/** Constructor **/
	public MovePieceController(Model m, Application a) {
		this.model = m;
		this.app = a;
	}
	
	/** Methods **/
	/*
	 * User requests to move the selected piece. If the piece can move in the requested direction, the 
	 * piece is moved in that direction. The direction is given by the code from the arrow key.
	 */
	public boolean movePiece(String eventType) {
		Piece piece = model.getSelected();
		if (canMove(piece, eventType)) {
			if (eventType == "RIGHT") {
				piece.setXCoord(piece.getXCoord() + 100);
			} else if (eventType == "LEFT") {
				piece.setXCoord(piece.getXCoord() - 100);
			} else if (eventType == "UP") {
				piece.setYCoord(piece.getYCoord() - 100);
			} else if (eventType == "DOWN") {
				piece.setYCoord(piece.getYCoord() + 100);
			}
			// Update the move counter
			model.incrementCounter();
			app.setCounterText("Moves: " + String.valueOf(model.moves()));
			
			return true;
		}
		
		// Update the display
		app.repaint();
		return false;
	}
	
	// First check if the move will put the piece out of bounds. Then check if the spot is available.
	public boolean canMove(Piece piece, String eventType) {
		if (eventType == "RIGHT") { // If the right arrow key has been selected (to move the piece right)
			int rightEdge = piece.getXCoord() + piece.getWidth();
			if (rightEdge + 100 <= 400 &&
				openSpot(rightEdge + 50, piece.getYCoord() + piece.getHeight()/2)) {
				return true;
			}
		} else if (eventType == "LEFT") { // If the left arrow key has been selected (to move the piece left)
			int leftEdge = piece.getXCoord();
			if (leftEdge - 100 >= 0 &&
				openSpot(leftEdge - 50, piece.getYCoord() + piece.getHeight()/2)) {
				return true;
			}
		} else if (eventType == "UP") { // If the up arrow key has been selected (to move the piece up)
			int topEdge = piece.getYCoord();
			if (topEdge - 100 >= 0 &&
				openSpot(piece.getXCoord() + 50, topEdge - 50)) {
				return true;
			}
		} else if (eventType == "DOWN") { // If the down arrow key has been selected (to move the piece down)
			int bottomEdge = piece.getYCoord() + piece.getHeight();
			
			// Check if piece is primary piece
			if (piece.isPrimary()) {
				if (bottomEdge + 100 > 500) {
					app.displayWinScreen();
				}
			}
			
			if (bottomEdge + 100 <= 500 &&
				openSpot(piece.getXCoord() + 50, bottomEdge + 50)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean openSpot(Integer x, Integer y) {
		// Create an iterator to search through the pieces to see if one occupies the requested spot
		Iterator<Piece> it = model.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			
			// Check if the coordinates match the requested spot. If so its a match, and cancel move
			if (!model.isSelected(p) &&
				p.getXCoord() <= x && 
				p.getXCoord() + p.getWidth() >= x &&
				p.getYCoord() <= y &&
				p.getYCoord() + p.getHeight() >= y) {
				return false;
			}
		}
		
		return true;
	}
}
