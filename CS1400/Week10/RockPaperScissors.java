/********************************************************
 * RockPaperScissors.java Stephanie Stamm
 *
 *
 * Connects with Game.java to play Rock, Paper, Scissors 
 ********************************************************/

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors
{
   public String getUserChoice ()
   {
      // Variables
      Scanner in = new Scanner (System.in);
      String userChoice = "";
      
      // Get user's choice
      System.out.println("Rock, Paper, or Scissors?");
      userChoice = in.nextLine();
      
      // Ensure user's choice is valid input
      while (!userChoice.equalsIgnoreCase("rock") && !userChoice.equalsIgnoreCase("scissors") && !userChoice.equalsIgnoreCase("paper"))
      {
         System.out.println("Sorry, \"" + userChoice + "\" is not a valid entry.");
         System.out.println("Rock, Paper, or Scissors?");
         userChoice = in.nextLine();
      }
      
      return userChoice;
   }
   
   public String getCPUChoice ()
   {
      // Variables
      Random r = new Random ();
      String cpuChoice = "";
      int cpuRandomNumber = 0;
      
      // Generate computer's choice as random number
      cpuRandomNumber = r.nextInt (3);
      
      // Maps computer's numeric choice to Rock, Paper or Scissors
      switch (cpuRandomNumber)
      {
         case 0: cpuChoice = "Rock"; break;
         case 1: cpuChoice = "Paper"; break;
         case 2: cpuChoice = "Scissors"; break;
      }

      return cpuChoice;
   }
   
   public String pickWinner (String userChoice, String computerChoice)
   {
      // Variables
      String winner = "";
      userChoice = userChoice.toLowerCase();
      computerChoice = computerChoice.toLowerCase();
      
      // Determines tie game
      if (userChoice.equals(computerChoice))
      {
         return "Tie";
      }
      
      // Determines user or computer as winner
      switch (userChoice)
      {
         case "rock":
            if (computerChoice.equals("paper"))
            {
               winner = "Computer";
            }
            else if (computerChoice.equals("scissors"))
            {
               winner = "User";
            }
            break;
         case "paper":
            if (computerChoice.equals("rock"))
            {
               winner = "User";
            }
            else if (computerChoice.equals("scissors"))
            {
               winner = "Computer";
            }
            break;
         case "scissors":
            if (computerChoice.equals("paper"))
            {
               winner = "User";
            }
            else if (computerChoice.equals("rock"))
            {
               winner = "Computer";
            }
            break;
         default: break;
      }

      return winner;
   }
}