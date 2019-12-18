/********************************************************
* GameDriver.java
* Stephanie Stamm
* 
* 
* Driver for game of roulette in roulette.java
********************************************************/

import java.util.Scanner;
import java.util.Random;

public class GameDriver
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      Random r = new Random ();
      
      int number = r.nextInt(37); // Generates random number for roulette
      
      Roulette game = new Roulette (); // Creates new instance of roulette game
      game.betOnce(in, number); // Calls betOnce method, passing Scanner and random number as parameters
   }
}