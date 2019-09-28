/********************************************************
* Mission03Stamm.java
* Stephanie Stamm
* 
* 
* Plays Higher / Lower number guessing game.
* User guesses a random number between 1 and 100
* and game offers hints to the correct answer.
********************************************************/

import java.util.Random;
import java.util.Scanner;

public class Mission03Stamm
{
   public static void main (String[] args)
   {

      Random r = new Random();
      Scanner in = new Scanner(System.in);
      
      int numberToGuess = r.nextInt(100) + 1;
      int usersGuess = 0;
      int numberOfGuesses = 0;
            
      // Welcome user to game
      System.out.println("Welcome to the Higher / Lower game! Try to guess the number between 1 and 100.");
      
      do
      {
         // Prompt user for guesses until they guess correctly
         System.out.println("Enter your guess:");
         usersGuess = in.nextInt();
         numberOfGuesses++;

         // Check for valid input and let user try again
         while (usersGuess < 1 || usersGuess > 100)
         {
            System.out.println("Sorry, the guess needs to be a number between 1 and 100. Please try again.");
            usersGuess = in.nextInt();
         }
         
         // Tell user if their guess is higher, lower or correct
         if (usersGuess > numberToGuess)
         {
            System.out.println("The number is lower");
         }
         else if (usersGuess < numberToGuess)
         {
            System.out.println("The number is higher");
         }
         if (usersGuess == numberToGuess)
         {
            System.out.println("The number was " + numberToGuess + "! You guessed correctly! It took you " + numberOfGuesses + " tries.");
         }
       } while (usersGuess != numberToGuess);
   }
}