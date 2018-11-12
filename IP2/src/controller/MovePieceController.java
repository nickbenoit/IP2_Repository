package controller;

import java.awt.event.KeyEvent;
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
	public void movePiece(String eventType) {
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
		}
		
		// Update the display
		app.repaint();
	}
	
	// First check if the move will put the piece out of bounds. Then check if the spot is available.
	public boolean canMove(Piece piece, String eventType) {
		if (eventType == "RIGHT") { // If the right arrow key has been selected (to move the piece right)
			if (piece.getXCoord() + piece.getWidth() + 100 <= 400) {
				return true;
			}
		} else if (eventType == "LEFT") { // If the left arrow key has been selected (to move the piece left)
			if (piece.getXCoord() - 100 >= 0) {
				return true;
			}
		} else if (eventType == "UP") {
			if (piece.getYCoord() - 100 >= 0) {
				return true;
			}
		} else if (eventType == "DOWN") {
			if (piece.getYCoord() + piece.getHeight() + 100 <= 500) {
				return true;
			}
		}
		return false;
	}
}
