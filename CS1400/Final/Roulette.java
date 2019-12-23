/********************************************************
* Roulette.java (Final Exam)
* Stephanie Stamm
* 
* 
* Plays game of roulette
********************************************************/

import java.util.Scanner;
import java.util.Random;

public class Roulette
{
   public double betOnce(Scanner in, double betAmount)
   {
      Random r = new Random();
      
      int betChoice = 0;
      int number = r.nextInt(36);
      int guess = 0;
      
      // Get user's guess
      System.out.println("Do you want to bet on 1) Low or 2) High or 3) a Number?");
      betChoice = in.nextInt();
      
      // If invalid bet is made, prompt for valid bet of 1 or 2
      while (betChoice != 1 && betChoice != 2 && betChoice != 3)
      {
         System.out.println("Sorry, that is not a valid bet. Do you want to bet on 1) low or 2) high?");
         betChoice = in.nextInt();
      }
      
      // Get number from user if they chose to guess a number
      if (betChoice == 3)
      {
         System.out.println("Enter a guess between 1 and 36");
         guess = in.nextInt();
      }
            
      // If number equals zero, user loses
      if (number == 0)
      {
         betAmount = 0;
      }
      // Determine game result if user guesses number
      else if (betChoice == 3)
      {
         if (number == guess)
         {
            betAmount *= 34;
         }
         else
         {
            betAmount = 0;
         }
      }
      // Determine game result if number is low
      else if (number >= 1 && number <= 18)
      {
         if (betChoice == 1)
         {
            betAmount *= 2;
         }
         else
         {
            betAmount = 0;
         }
      }
      // Determine game result if number is high
      else if (number >= 18 && number <= 36)
      {
         if (betChoice == 2)
         {
            betAmount *= 2;
         }
         else
         {
            betAmount = 0;
         }
      }
      
      // Informs user what number was generated
      System.out.println("The number was " + number + ".");
      
      // If number equals zero, user loses
      if (number == 0)
      {
         printYouLose ();
      }
      // Determines game result if number is low
      else if (number >= 1 && number <= 18)
      {
         if (betChoice == 1)
         {
            printYouWin ();
         }
         else
         {
            printYouLose ();
         }
      }
      // Determines game result if number is high
      else if (number >= 18 && number <= 36)
      {
         if (betChoice == 2)
         {
            printYouWin ();
         }
         else
         {
            printYouLose ();
         }
      }
      
      return betAmount;
   }
   
   // Gets called if user wins
   public static void printYouWin ()
   {
      System.out.println("You win");
   }
   
   // Gets called if user loses
   public static void printYouLose ()
   {
      System.out.println("You lose");
   }
}