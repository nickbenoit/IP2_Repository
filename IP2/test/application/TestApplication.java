package application;

import junit.framework.TestCase;

import model.Model;

public class TestApplication extends TestCase {
	// Test the initialization of a new app
	public void testInit() {
		Model m = Model.defaultModel();
		Application app = new Application(m);
		
		String title = "Puzzle Application";
		assertTrue(title.equals(app.getTitle()));
	}
}
