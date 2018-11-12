package main;

import application.Application;
import model.Model;

public class Main {
	// Launch application
	public static void main(String[] args) {
		// Create a new model
		Model m = Model.defaultModel();
		
		// Create a new application
		Application frame = new Application(m);
		
		//Model.defaultModel();
		frame.setVisible(true);
	}
}
