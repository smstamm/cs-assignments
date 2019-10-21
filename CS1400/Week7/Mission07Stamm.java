
/********************************************************
 * Mission07Stamm.java Stephanie Stamm
 *
 *
 * Simulates a dice throwing game
 ********************************************************/

import java.util.Random;
import java.util.Scanner;

public class Mission07Stamm
{
   public static void main (String[] args)
	{
      Random r = new Random ();
      Scanner in = new Scanner (System.in);
     
      // Variables
      int tally[] = new int[13];
      int die1Roll = 0;
      int die2Roll = 0;
      int diceTotal = 0;
      int numRolls = 0;
      int numAsterisks = 0;
      
      // Welcome user to game
      System.out.println("Welcome to the dice throwing simulator!");
      System.out.println("How many dice rolls would you like to simulate?");
      numRolls = in.nextInt();

      // Roll both die, total dice, and increment total in tally array
      for (int i = 0; i < numRolls; i++)
      {
         die1Roll = r.nextInt(6) + 1;
         die2Roll = r.nextInt(6) + 1;
         diceTotal = die1Roll + die2Roll;
         tally[diceTotal]++;
      }

      // Print results
      System.out.println("DICE ROLLING SIMULATION RESULTS");
      System.out.println("Each \"*\" represents 1% of the total number of rolls.");
      System.out.println("Total number of rolls = " + numRolls);

      for (int i = 2; i < tally.length; i++)
      {
         // Calculate how many asterisks to print for each total
         numAsterisks = 100 * tally[i] / numRolls;
         
         // Print total and one * for every 1% of total rolled
         for (int j = 0; j < numAsterisks; j++)
         {
            if (j == 0)
            {
               System.out.print(i + ": *"); // Prints total on a new line
            }
            else if (j == numAsterisks - 1)
            {
               System.out.println("*"); // Prints final asterisk on a new line
            }
            else
            {
               System.out.print("*"); // Prints asterisk on same line
            }
         }
      }
              
      System.out.println("Thank you for using the dice throwing simulator. Goodbye!");
   }
}