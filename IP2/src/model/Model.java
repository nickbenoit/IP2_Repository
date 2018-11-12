package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Model {
	/** Attributes **/
	// Keep track of all pieces
	ArrayList<Piece> list = new ArrayList<>();	
	// Keep track of selected piece
	Piece selected = null;
	
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
	// Add a piece to the list
	public void setList(ArrayList<Piece> list) {
		this.list = list;
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
	public Optional<Piece> getSelected() {
		Optional<Piece> option = Optional.ofNullable(selected);
		return option;
	}	
	// Determine if the piece is the currently selected one
	public boolean isSelected(Piece p) {
		return (p != null && p == selected);
	}
}
