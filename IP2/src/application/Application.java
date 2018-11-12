package application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.SelectPieceController;
import model.Model;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Application extends JFrame{	
	/** Attributes **/
	// Content pane where puzzle is located
	PuzzleArea contentPane;
	JButton rightButton;
	JButton leftButton;
	JButton upButton;
	JButton downButton;
	
	Model model;
		
	/** Constructor **/
	public Application(Model m) {
		super();
		this.model = m;
		
		// Set title of application
		setTitle("Puzzle Application");
		// Set close functionality
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		// Set bounds of the application
		setBounds(100, 100, 500, 600);
		
		// Instantiate content pane
		contentPane = new PuzzleArea(model);
		
		// Create buttons
		rightButton = new JButton(">");
		contentPane.add(rightButton);
		
		leftButton = new JButton("<");
		getContentPane().add(leftButton, BorderLayout.WEST);
		
		upButton = new JButton("^");
		getContentPane().add(upButton, BorderLayout.NORTH);
		
		downButton = new JButton("v");
		getContentPane().add(downButton, BorderLayout.SOUTH);

		// Create controller for mouse clicks within PuzzleArea
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent c) {
				// For a right mouse click
				if (SwingUtilities.isLeftMouseButton(c)) {
					new SelectPieceController(model, Application.this).selectPiece(c.getPoint());
				}
			}
		});		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	Application () {
		this (new Model());
	}
	
	// Provide access to content pane
	public PuzzleArea getPuzzleArea() {
		return contentPane;
	}
}