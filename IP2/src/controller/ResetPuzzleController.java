package controller;

import application.Application;
import model.InitialPieces;
import model.Model;

/*
 * Use Case: 			Move Piece
 * Participating Actor: Initiated by User
 * Entry Criteria:		N/A
 * Exit Criteria:		The puzzle is reset to its initial configuration
 * Flow of Events:
 * 		1. The User requests to reset the puzzle
 * 		2. The System asks for confirmation
 * 		3. The User confirms reset
 * 		2. The System resets the puzzle and updates the display
 */

public class ResetPuzzleController {
	/** Attributes **/
	Model model;
	Application app;
	
	/** Constructor **/
	public ResetPuzzleController(Model m, Application a) {
		this.model = m;
		this.app = a;
	}
	
	/** Methods **/
	/*
	 * User requests to reset the puzzle. After being prompted for confirmation, the system resets
	 * the puzzle to its initial conditions.
	 */
	public void resetPuzzle() {
		// Reset the puzzle
		model.setList(InitialPieces.initialize());
		
		// Reset the move counter
		model.resetCounter();
		app.setCounterText("Moves: " + String.valueOf(model.moves()));
		
		// Update the display
		app.repaint();
	}
}
