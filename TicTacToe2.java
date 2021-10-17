// This is a tic-tac-toe game using the command line. It keeps track of X's and O's wins and uses a two-dimensional array to store moves.
// Aida Fatme Fakhry 
// 9-21-2021

import java.util.Scanner;

public class TicTacToe2 {
	
	private static final char[][] TicTacToe = null; 
	int[][] Board = new int[3][3]; // Board layout 
	final int BLANK = 0;  
	final int X_MOVE = 1; // X goes first 
	final int O_MOVE = 2; 
	final int X_TURN = 0; 
	final int O_TURN = 1; 
	int turn = X_TURN; 
	int xwins = 0; // Keeping track of x's wins
	int owins = 0; // Keeping track of o's wins
	Scanner scanner; 
	String input = ""; 
	
	
			public TicTacToe2() { 
				scanner = new Scanner(System.in); 
				boolean stillPlaying = true; 
				while (stillPlaying == true) { 
					// scanner for still playing
					
				while  (checkwin(X_MOVE) == false && checkwin(O_MOVE) == false && checkTie() == false) { 
					printBoard(); 
					input = scanner.nextLine(); 
					if (input.length() != 2) {
						System.out.println("Please enter a letter followed by a number");
						// declaring x moves
			 
				}
				else if (input.charAt(0) != 'a' &&
						input.charAt(0) != 'b' && 
						input.charAt(0) != 'c') { 
					System.out.println("Row must be an, a, b, or c."); 
				}
					// Exceptions in input
		
			
				else if (input.charAt(1) != '1' &&
						input.charAt(1) != '2' && 
						input.charAt(1) != '3') { 
					System.out.println("Column must be an 1, 2, or 3."); 
		}
					// Exceptions in input
				else {
					int row = input.charAt(0) - 'a'; 
					int column = input.charAt(1) - '1'; 
					if(Board[row][column] == BLANK) { 
						if (turn == X_TURN) { 
						System.out.println(row +"," +column); 
							Board[row][column] = X_MOVE;
							turn = O_TURN; // Input setup 
				} 
				else { 
					Board[row][column] = O_MOVE; 
					turn = X_TURN;  //Turns: X Turn first 
					
				} 
				} 
					else 	{ 
				System.out.println("There is a piece there!"); // Error message for overlapping 		
		} 
				}
				}
				
				if (checkwin(X_MOVE) == true) { 
					System.out.println("X wins!"); // Print out: game message for winner
					xwins++;  
				}	
				else if (checkwin(O_MOVE) == true) { 
					System.out.println("O wins!"); // Print out: game message for winner
					owins++;
		
				 }
				else
				System.out.println("It's a tie!");
	 
	System.out.println("X wins: " + xwins + ", O wins: " + owins); // Keeping track of winner
	System.out.println("Would you like to play again?"); 
	System.out.println("Please type either a 'yes' or a 'no'"); // Asking to re-play
	// answering if they are still playing 
	String yesno = scanner.nextLine(); //scanning answer 
	if (yesno.equals("yes") || yesno.equals("y")) { 
		stillPlaying = true; 
		//restart board
		Board = new int[3][3]; // Printing out board
		turn = X_TURN; 
		
		
	}
else if (yesno.equals("no") || yesno.equals("n")) { //scanning answer for no 
	stillPlaying = false; 
	System.out.println("Thank you for playing. Goodbye."); //Exit game: message to player
}
		}
	}
 	
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new TicTacToe2(); 
				
		}
		
		public void printBoard() { // Board set-up 
			System.out.println(" \t1\t2\t3"); 
			for (int row = 0; row < Board.length; row++) { 
				String output = (char)('a' +row) + "\t"; 
				for (int column = 0; column < Board[0].length; column++) { 
					if (Board[row][column] == BLANK) { 
						output += "\t"; 
			
					}
					else if (Board[row][column] == X_MOVE) { //Declaring X and O's turns
						output += "X\t"; 
					}
					else if (Board[row][column] == O_MOVE) { 
						output += "O\t"; 
						
					}
				}
				System.out.println(output); 
			}
			}
	public boolean checkwin(int player) { //Method to check for a win (8 possible combinations) 
		if(Board[0][0] == player && Board[0][1] == player && Board[0][2] == player) 
		return true; 
		
		if (Board[0][0] == player && Board[1][1] == player && Board[2][2] == player) 
			return true; 			
		
		if (Board[2][0] == player && Board[1][1] == player && Board[0][2] == player)  
			return true; 
			
		if (Board[1][0] == player && Board[1][1] == player && Board[1][2] == player)  
			return true; 	
					 
		if (Board[2][0] == player && Board[2][1] == player && Board[2][2] == player)  
			return true; 				
		
		if (Board[0][0] == player && Board[1][0] == player && Board[2][0] == player) 
			return true; 								
													
		if (Board[0][1] == player && Board[1][1] == player && Board[2][1] == player) 
			 return true; 										
			
		if (Board[0][2] == player && Board[1][2] == player && Board[2][2] == player) 
			return true; 
		
		return false; 
		
		}
	 public boolean checkTie() { // CheckTie condition 
		for(int row =0; row < Board.length; row++) { 
			for(int column =0; column < Board[0].length; column++) { 
				if (Board[row][column] == BLANK) { 
					return false; 
				
				}
			}
		}
		return true; 
	 
	 }
}


	
