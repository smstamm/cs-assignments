
/********************************************************
 * Mission05Stamm.java Stephanie Stamm
 *
 *
 * Plays a game of Rock, Paper, Scissors
 * between user and computer
 ********************************************************/
import java.util.Scanner;
import java.util.Random;

public class Mission05Stamm
{
   public static void main(String[] args)
   {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        // Declare constants
        final String rock = "Rock";
        final String paper = "Paper";
        final String scissors = "Scissors";

        // Declare variables
        String computerGuess = "";
        int computerRandomNumber = 0;
        int numComputerWins = 0;
        int numGamesToPlay = 0;
        int numUserWins = 0;
        String userGuess = "";

        // Welcome user to game and ask how many rounds they want to play
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Please enter the number of rounds you would like to play:");
        numGamesToPlay = in.nextInt();

        // Make sure user enters odd number of games
        while (numGamesToPlay % 2 == 0)
        {
            System.out.println("Sorry, you need to enter an odd number. Please try again:");
            numGamesToPlay = in.nextInt();
        }

        // Flush the buffer between int and String inputs
        in.nextLine();

        // Play game for number of games user specified
        for (int i = 0; i < numGamesToPlay; i++)
        {
            // Ask user for choice
            printQuestion();
            userGuess = in.nextLine();

            // Check for valid entry
            while (!userGuess.equalsIgnoreCase(rock) && !userGuess.equalsIgnoreCase(paper) && !userGuess.equalsIgnoreCase(scissors))
            {
                System.out.println("Sorry, \"" + userGuess + "\" is not a valid entry." );
                printQuestion();
                userGuess = in.nextLine();
            }

            // Assign computer's choice randomly and set to variable for easy comparison with user's choice
            computerRandomNumber = r.nextInt(3);

            switch (computerRandomNumber)
            {
                case 0: computerGuess = rock; break;
                case 1: computerGuess = paper; break;
                case 2: computerGuess = scissors; break;
            }

            // Replay round in case of tie game
            if (computerGuess.equalsIgnoreCase(userGuess))
            {
                System.out.println("Computer chooses " + computerGuess + ". It’s a tie.");
                numGamesToPlay++;
            }

            // Compare guesses and determine winner of round
            switch (computerGuess)
            {
                case rock:
                    if (userGuess.equalsIgnoreCase(paper))
                    {
                        printYouWin (computerGuess);
                        numUserWins++;
                    }
                    else if (userGuess.equalsIgnoreCase(scissors))
                    {
                        printYouLose (computerGuess);
                        numComputerWins++;
                    }
                    break;
                case paper:
                    if (userGuess.equalsIgnoreCase(rock))
                    {
                        printYouLose(computerGuess);
                        numComputerWins++;
                    }
                    else if (userGuess.equalsIgnoreCase(scissors))
                    {
                        printYouWin(computerGuess);
                        numUserWins++;                            
                    }
                    break;
                case scissors:
                    if (userGuess.equalsIgnoreCase(rock))
                    {
                        printYouWin(computerGuess);
                        numUserWins++;
                    }
                    else if (userGuess.equalsIgnoreCase(paper))
                    {
                        printYouLose(computerGuess);
                        numComputerWins++;
                    }
                    break;
                default: break;
            }
        }

        // Tally wins and print results
        System.out.println("User wins: " + numUserWins);
        System.out.println("Computer wins: " + numComputerWins);
        
        if (numUserWins > numComputerWins)
        {
            System.out.println("You win the game!");
        }
        else if (numComputerWins > numUserWins)
        {
            System.out.println("Computer wins the game!");
        }
    }

    public static void printQuestion() {
        System.out.println("Rock, Paper or Scissors?");
    }

    public static void printYouLose (String computerGuess)
    {
        System.out.println("Computer chooses " + computerGuess + ". You lose.");
    }

    public static void printYouWin (String computerGuess)
    {
        System.out.println("Computer chooses " + computerGuess + ". You win!");
    }
}