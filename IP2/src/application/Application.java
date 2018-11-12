package application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.MovePieceController;
import controller.ResetPuzzleController;
import controller.SelectPieceController;
import model.Model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Application extends JFrame{	
	/** Attributes **/
	// Content pane where puzzle is located
	PuzzleArea contentPane;
	JButton rightButton;
	JButton leftButton;
	JButton upButton;
	JButton downButton;
	JButton resetButton;
	JLabel counter;
	
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
		setBounds(100, 100, 600, 600);
		
		// Instantiate content pane
		contentPane = new PuzzleArea(model);

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
		
		// Set borders for content pane
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Set layout manager to null
		contentPane.setLayout(null);
		
		// Create buttons
		rightButton = new JButton(">");
		rightButton.setBounds(530, 250, 50, 20);
		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(model, Application.this).movePiece("RIGHT");
			}
		});
		contentPane.add(rightButton);
		
		leftButton = new JButton("<");
		leftButton.setBounds(480, 250, 50, 20);
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(model, Application.this).movePiece("LEFT");
			}
		});
		contentPane.add(leftButton);
		
		upButton = new JButton("^");
		upButton.setBounds(505, 230, 50, 20);
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(model, Application.this).movePiece("UP");
			}
		});
		contentPane.add(upButton);
		
		downButton = new JButton("v");
		downButton.setBounds(505, 270, 50, 20);
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(model, Application.this).movePiece("DOWN");
			}
		});
		contentPane.add(downButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(495, 300, 70, 20);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create a confirmation box to make sure the user wants to reset the puzzle
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(Application.this, "Would you like to reset?", "Warning", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					new ResetPuzzleController(model, Application.this).resetPuzzle();
				}
			}
		});
		contentPane.add(resetButton);
		
		// Create a counter on the application that will track the number of moves
		counter = new JLabel();
		counter.setText("Moves: " + String.valueOf(model.moves()));
		counter.setBounds(495, 350, 70, 20);
		contentPane.add(counter);
		
		
	}
	
	/** Methods **/
	Application () {
		this (new Model());
	}
	
	// Provide access to content pane
	public PuzzleArea getPuzzleArea() {
		return contentPane;
	}
	// Provide access to move counter
	public void setCounterText(String msg) {
		counter.setText(msg);
	}
	
	// Display win screen
	public void displayWinScreen() {
		JOptionPane.showMessageDialog(Application.this, "You've won!", "Win Screen", JOptionPane.INFORMATION_MESSAGE);
	}
}