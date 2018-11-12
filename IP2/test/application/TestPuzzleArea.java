package application;

import junit.framework.TestCase;
import model.Model;

public class TestPuzzleArea extends TestCase{
	// Test the puzzle area
	public void testPuzzle() throws InterruptedException {
		Model m = Model.defaultModel();
		Application app = new Application(m);
		
		app.setVisible(true);
		
		PuzzleArea p = new PuzzleArea(m);
		
		Thread.sleep(1000);
	}
}
