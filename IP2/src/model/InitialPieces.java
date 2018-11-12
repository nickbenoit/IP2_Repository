package model;

import java.util.ArrayList;

public class InitialPieces {
	/** Set the initial coordinates and dimensions for the pieces **/
	// Piece one
	final static Integer x1 = 0;
	final static Integer y1 = 0;
	final static Integer w1 = 100;
	final static Integer h1 = 200;
	
	// Piece two
	final static Integer x2 = 100;
	final static Integer y2 = 0;
	final static Integer w2 = 200;
	final static Integer h2 = 200;
	
	// Piece three
	final static Integer x3 = 300;
	final static Integer y3 = 0;
	final static Integer w3 = 100;
	final static Integer h3 = 200;
	
	// Piece four
	final static Integer x4 = 0;
	final static Integer y4 = 200;
	final static Integer w4 = 100;
	final static Integer h4 = 200;
	
	// Piece five
	final static Integer x5 = 100;
	final static Integer y5 = 200;
	final static Integer w5 = 100;
	final static Integer h5 = 100;
	
	// Piece six
	final static Integer x6 = 200;
	final static Integer y6 = 200;
	final static Integer w6 = 100;
	final static Integer h6 = 100;

	// Piece seven
	final static Integer x7 = 300;
	final static Integer y7 = 200;
	final static Integer w7 = 100;
	final static Integer h7 = 200;
	
	// Piece eight
	final static Integer x8 = 100;
	final static Integer y8 = 300;
	final static Integer w8 = 100;
	final static Integer h8 = 100;
	
	// Piece nine
	final static Integer x9 = 200;
	final static Integer y9 = 300;
	final static Integer w9 = 100;
	final static Integer h9 = 100;
	
	// Piece ten
	final static Integer x10 = 100;
	final static Integer y10 = 400;
	final static Integer w10 = 200;
	final static Integer h10 = 100;
	
	/** Create the initial puzzle **/
	public static ArrayList<Piece> initialize() {
		// Initialize the list of pieces
		ArrayList<Piece> list = new ArrayList<>();
		
		// Create the 10 pieces and add them to the list of pieces
		list.add(new Piece(x1, y1, w1, h1));
		list.add(new Piece(x2, y2, w2, h2));
		list.add(new Piece(x3, y3, w3, h3));
		list.add(new Piece(x4, y4, w4, h4));
		list.add(new Piece(x5, y5, w5, h5));
		list.add(new Piece(x6, y6, w6, h6));
		list.add(new Piece(x7, y7, w7, h7));
		list.add(new Piece(x8, y8, w8, h8));
		list.add(new Piece(x9, y9, w9, h9));
		list.add(new Piece(x10, y10, w10, h10));
		
		// Return the list of pieces
		return(list);
	}
}
