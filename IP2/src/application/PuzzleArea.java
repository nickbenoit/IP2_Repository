package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

import javax.swing.JPanel;

import model.Model;
import model.Piece;

@SuppressWarnings("serial")
public class PuzzleArea extends JPanel{
	/** Attributes **/
	// Add the model
	Model model;
	
	/** Constructor **/
	public PuzzleArea(Model m) {
		this.model = m;
	}
	
	/** Methods **/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Create an iterator to paint all the pieces on the board
		Iterator<Piece> it = model.iterator();
		while (it.hasNext()) {
			Piece p = it.next();
			
			// Create a rectangle with the puzzle piece's dimensions
			Rectangle r = new Rectangle(p.getXCoord() + 1, p.getYCoord() + 1, p.getWidth() - 1, p.getHeight() - 1);
			
			// Set the color for the rectangles outline
			g.setColor(Color.black);
			// Draw the pieces in the puzzle area using their coordinates and dimensions
			g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
			
			// Set the color for drawing the unselected rectangles
			g.setColor(Color.gray);
			// If the piece is selected, change the color to black to indicate selection
			if (model.isSelected(p)) {
				g.setColor(Color.darkGray);
			}
			
			g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
		}
	}
	
}
