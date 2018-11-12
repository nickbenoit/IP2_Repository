package model;

public class Piece {
	/** Attributes **/
	/*
	 * The xCoord and yCoord attributes capture the location of the origin of the piece. The
	 * origin of the piece is in the top left corner.
	 */
	// X coordinate
	Integer xCoord;
	
	public Integer getXCoord() {
		return xCoord;
	}
	
	public void setXCoord(Integer x) {
		this.xCoord = x;
	}
	
	// Y coordinate
	Integer yCoord;
	
	public Integer getYCoord() {
		return yCoord;
	}
	
	public void setYCoord(Integer y) {
		this.yCoord = y;
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
	
	/** Constructor **/
	public Piece (Integer x, Integer y, Integer w, Integer h) {
		super();
		this.xCoord = x;
		this.yCoord = y;
		this.width = w;
		this.height = h;
	}	
}