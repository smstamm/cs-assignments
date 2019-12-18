/********************************************************
* Roulette.java
* Stephanie Stamm
* 
* 
* Plays game of roulette
********************************************************/

import java.util.Scanner;

public class Roulette
{
   public void betOnce(Scanner in, int number)
   {
      int bet = 0;
      
      System.out.println("Do you want to bet on 1) low or 2) high?");
      bet = in.nextInt();
      
      // If invalid bet is made, prompt for valid bet of 1 or 2
      while (bet != 1 && bet != 2)
      {
         System.out.println("Sorry, that is not a valid bet. Do you want to bet on 1) low or 2) high?");
         bet = in.nextInt();
      }
      
      // Informs user what number was generated
      System.out.println("The number was " + number);
      
      // If number equals zero, user loses
      if (number == 0)
      {
         printYouLose ();
      }
      // Determines game result if number is low
      else if (number >= 1 && number <= 18)
      {
         if (bet == 1)
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
         if (bet == 2)
         {
            printYouWin ();
         }
         else
         {
            printYouLose ();
         }
      }
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