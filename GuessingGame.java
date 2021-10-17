
import java.util.Random;
import java.util.Scanner; // Import scanner

  public class GuessingGame {
	  
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Random r = new Random(); // Declaring new random number
    int MAX = 50; //ceiling for the random number is 50
    int Total = 0; //Total number of guess
    int TotalPlays = 0; // Keeping track of rounds 
    int YourBestGame = Integer.MAX_VALUE; //used to determine game with lowest amount of guesses
    String answer; //holds user input

    boolean StillPlaying = true; //used to determine if the game is ongoing

    while (StillPlaying == true) { // While player is still playing
        System.out.println("This random number is between 1 and " + MAX + "...");
        int RandomNum = r.nextInt(MAX) + 1; //generate random int [1, 100]
        int userGuess = 0; //holds user guess
        int guesses = 0; //Total number of guesses this game

        while(userGuess != RandomNum) { //while number is not guessed
            System.out.print("Please write your guess.");
            userGuess = scanner.nextInt();
            if (userGuess > RandomNum) System.out.println("You need to go lower - your number is too high.");
            else if (userGuess < RandomNum) System.out.println("Your number is too low. Go higher.");
            guesses++; //increase guesses this round by 1
        }

        if (guesses < YourBestGame) YourBestGame = guesses; //if this game had the least guesses, then this will be considered their "best game" 
        System.out.println("You got it right in " + guesses + " guesses!");

        TotalPlays++; //increase number of games by 1
        Total += guesses; //increase Total guesses by guesses this round

    
        System.out.println("If you would like to play again, type: 'yes', if not, thank you for playing.");
        answer = scanner.next();
        if (answer.toLowerCase().equals("Y")) StillPlaying = true; 
  
    
    

    }
         

  
   
    scanner.close(); //close scanner
    
    System.out.println("Overall results:"); //print results
    System.out.println("Total games = " + TotalPlays);
    System.out.println("Total guesses = " + Total);
    System.out.println("Best game = " + YourBestGame);

}
}
  

