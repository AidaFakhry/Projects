// This is a tic-tac-toe game using  the simple components of a GUI. 
// Aida Fatme Fakhry 
// 9-18-2021

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class _GuiTicTacToe implements ActionListener { // Listen for actions from button

	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3]; // boarder layout - array creation
	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE = 2;
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN; // variable to keep track of turns
	Container center = new Container();
	JLabel xLabel = new JLabel("X wins:0"); // new JLabel for Player X
	JLabel oLabel = new JLabel("O wins:0"); // new JLabel for Player O
	JButton xChangeName = new JButton("Change X's Name.");
	JButton oChangeName = new JButton("Change O's Name.");
	JTextField xChangeField = new JTextField(); // text field creation for X
	JTextField oChangeField = new JTextField(); // text field creation for O
	Container north = new Container(); // new container for north
	String xPlayerName = "X";
	String oPlayerName = "O";
	Scanner scanner;
	int xwins = 0; // keeping track of wins
	int owins = 0;

	public _GuiTicTacToe() {
		frame.setSize(400, 400); // declaring size of frame
		// Center grid container
		frame.setLayout(new BorderLayout()); // set boarder layout
		center.setLayout(new GridLayout(3, 3)); // grid import
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				button[j][i] = new JButton(j + "" + i);
				center.add(button[j][i]);
				button[j][i].addActionListener(this); // run ActionListener to GUITicTacToe = "this"

			}
		}
		frame.add(center, BorderLayout.CENTER);
		// North container
		north.setLayout(new GridLayout(3, 2)); // Setting north columns and rows
		north.add(xLabel);
		north.add(oLabel);
		north.add(xChangeName);
		xChangeName.addActionListener(this); // action button tracker
		north.add(oChangeName);
		oChangeName.addActionListener(this); // action button tracker
		north.add(xChangeField); // changing position of X on graph
		north.add(oChangeField); // changing position of O on graph
		frame.add(north, BorderLayout.NORTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program if window is closed
		frame.setVisible(true); // setting window visible

	}

	public static void main(String[] args) {
		new _GuiTicTacToe();
	}

	public void actionPerformed(ActionEvent event) { // Action for ActionListener [method to listen to and figure out
														// which player clicks the button]
		JButton current;
		boolean gridButton = false;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				if (event.getSource().equals(button[j][i])) {
					gridButton = true;
					current = button[j][i];
					if (board[j][i] == BLANK) // checking board to BLANK
						if (turn == X_TURN) { // x move
							current.setText("X");
							board[j][i] = X_MOVE;
							turn = O_TURN;

						} else {
							current.setText("O");
							board[j][i] = O_MOVE; // Tracking O move
							turn = X_TURN;
						}
					// check for wins and ties
					if (checkWin(X_MOVE) == true) {
						// X wins!
						xwins++; // adding points for player x
						xLabel.setText(xPlayerName + " wins:" + xwins);
						clearboard();

					} else if (checkWin(O_MOVE) == true) {
						// O wins!
						owins++; // adding points for player o
						oLabel.setText(oPlayerName + " wins:" + owins);
						clearboard();

					} else if (checkTie() == true) { // Bracket instead of a semi-colon 
						System.out.println("There was a tie!");
						clearboard();

					}
				}

			}

		}

		if (gridButton == false) {
			if (event.getSource().equals(xChangeName) == true) {
				xPlayerName = xChangeField.getText(); // set to string to get text from player
				xLabel.setText(xPlayerName + " wins" + xwins); // set to new player name and wins

			} else if (event.getSource().equals(oChangeName) == true) {
				oPlayerName = oChangeField.getText(); // set to string to get text from player
				oLabel.setText(oPlayerName + " wins" + owins); // set to new player name and wins
			}

			else {
				JButton current1;
				for (int row = 0; row < button.length; row++) {
					for (int column = 0; column < button[0].length; column++) {
						if (event.getSource().equals(button[row][column]) == true) {
							board[row][column] = X_MOVE;
							current = button[row][column];
							current.setText("X");
							current.setEnabled(false); // enabling buttons for X
							if (checkWin(X_MOVE) == true) {
								System.out.println("X wins!");
								clearboard();
							}
						}
					}
				}
			}
			{
				JButton current1;
				for (int row = 0; row < button.length; row++) {
					for (int column = 0; column < button[0].length; column++) {
						if (event.getSource().equals(button[row][column]) == true) {
							board[row][column] = O_MOVE;
							current = button[row][column];
							current.setText("O");
							current.setEnabled(false); // enabling buttons for O
							if (checkWin(O_MOVE) == true) {
								System.out.println("O wins!");
								clearboard();
							}
						}
					}
				}
			}
		}
	}

	public boolean checkWin(int player) {
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player)
			return true;

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
			return true;

		if (board[2][0] == player && board[1][1] == player && board[0][2] == player)
			return true;

		if (board[1][0] == player && board[1][2] == player && board[0][2] == player)
			return true;

		if (board[2][0] == player && board[2][1] == player && board[2][2] == player)
			return true;

		if (board[0][0] == player && board[1][0] == player && board[2][0] == player)
			return true;

		if (board[0][1] == player && board[1][1] == player && board[2][1] == player)
			return true;

		if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			return true;
		}
		return false;
	}

	// clear board method creation
	public void clearboard() {
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board[0].length; b++) {
				board[a][b] = BLANK; // re set board
				button[a][b].setText(""); // re set buttons
			}
		}
		turn = X_TURN;

	} 
	// Check tie

	public boolean checkTie() { // CheckTie condition
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column] == BLANK) {
					return false;

				}

			}
		}
		return true; // Check tie, return true

	}
}
