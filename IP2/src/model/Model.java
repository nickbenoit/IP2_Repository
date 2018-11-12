package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Model {
	/** Attributes **/
	// Keep track of all pieces
	ArrayList<Piece> list = new ArrayList<>();	
	// Keep track of selected piece
	Piece selected = null;
	// Counter for the number of moves made
	Integer movesCounter = 0;
	
	/** Constructor **/
	public static Model defaultModel() {
		// Instantiate the default model
		Model m = new Model();
		
		// Create the puzzle pieces in their initial conditions
		ArrayList<Piece> list = InitialPieces.initialize();
		
		// Set the model's list of pieces to be the pieces in their initial conditions
		m.setList(list);
		
		return m;
	}
	
	/** Methods **/
	// Add the pieces to the list
	public void setList(ArrayList<Piece> list) {
		this.list = list;
	}
	// Return the list
	public ArrayList<Piece> getList(){
		return list;
	}
	
	// Return pieces using @return iterator of pieces
	public Iterator<Piece> iterator() {
		return list.iterator();
	}
	
	// Set the piece to be selected
	public void makeSelected(Piece p) {
		selected = p;
	}
	// Return the selected piece, if one has been selected
	public Piece getSelected() {
		return selected;
	}	
	// Determine if the piece is the currently selected one
	public boolean isSelected(Piece p) {
		return (p != null && p == selected);
	}
	// Reset the move counter
	public void resetCounter() {
		this.movesCounter = 0;
	}
	// Increment the move counter
	public void incrementCounter() {
		this.movesCounter += 1;
	}
	// Fetch the value of the move counter
	public int moves() {
		return this.movesCounter;
	}
}
