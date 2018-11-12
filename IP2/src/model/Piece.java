package model;

public class Piece {
	/** Attributes **/
	/*
	 * The xCoord and yCoord attributes capture the location of the origin of the piece. The
	 * origin of the piece is in the top left corner.
	 */
	// X coordinate
	Integer xCoord;
	
	public int getXCoord() {
		return xCoord;
	}
	
	public boolean setXCoord(Integer x) {
		this.xCoord = x;
		return true;
	}
	
	// Y coordinate
	Integer yCoord;
	
	public int getYCoord() {
		return yCoord;
	}
	
	public boolean setYCoord(Integer y) {
		this.yCoord = y;
		return true;
	}
	
	/*
	 * The width and height attributes capture the shape of the rectangular piece. Pieces are 
	 * measured from the top left corner.
	 */
	// Width
	Integer width;
	
	public int getWidth() {
		return width;
	}
	
	// Height
	Integer height;
	
	public int getHeight() {
		return height;
	}
	
	/*
	 * The 2x2 piece is the primary piece of the puzzle. If it crosses the line, the player has won.
	 * It is given a different color to distinguish it from the other pieces. 
	 */
	Boolean primary = false;
	
	public boolean isPrimary() {
		return primary;
	}
	
	public void setPrimary(Boolean b) {
		this.primary = b;
	}
	
	/** Constructor **/
	public Piece (Integer x, Integer y, Integer w, Integer h) {
		super();
		this.xCoord = x;
		this.yCoord = y;
		this.width = w;
		this.height = h;
	}	
}