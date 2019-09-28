/********************************************************
* Mission02Stamm.java
* Stephanie Stamm
* 
* 
* Calculates how many minutes can be saved by
* driving faster than the speed limit
********************************************************/

import java.util.Scanner;

public class Mission02Stamm
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
   
      // Variable declarations
      String destination = "";
      double milesToDestination = 0.0;
      double speedLimit = 0;
      double speedOverLimit = 0;
      double speedGoing = 0;
      double timeToDestination = 0;
      double minutesSaved = 0;

      // Get user's destination
      System.out.println("Please enter your destination.");
      destination = in.nextLine();
      
      // Get miles to destination
      System.out.println("How many miles is it to " + destination + "?");
      milesToDestination = in.nextDouble();
      
      // Get speed limit
      System.out.println("What is the speed limit (in mph)?");
      speedLimit = in.nextDouble();
      
      // Get user's speed above limit and calculate total speed
      System.out.println("How fast do you plan on driving over the speed limit (in mph)?");
      speedOverLimit = in.nextDouble();
      speedGoing = speedLimit + speedOverLimit;
      
      // Tell user how much time they'll save by speeding to their destination
      minutesSaved = minutesSaved (speedLimit, speedGoing, milesToDestination);
      System.out.println("You will arrive in " + destination + " " + minutesSaved + " minutes faster by driving " + speedOverLimit + " mph over the speed limit."); // TODO finish this
   }
   
   public static double minutesSaved (double speedLimit, double speedGoing, double milesToDestination)
   {
      // Variable declarations
      double milesPerMinuteAtSpeedLimit = speedLimit / 60;
      double milesPerMinuteAtSpeedGoing = speedGoing / 60;
      double minutesToDestinationAtSpeedLimit = 0.0;
      double minutesToDestinationAtSpeedGoing = 0.0;
      double minutesSaved = 0.0;
      
      // Calculate minutes saved by speeding
      minutesToDestinationAtSpeedLimit = milesToDestination / milesPerMinuteAtSpeedLimit;
      minutesToDestinationAtSpeedGoing = milesToDestination / milesPerMinuteAtSpeedGoing;
      minutesSaved = minutesToDestinationAtSpeedLimit - minutesToDestinationAtSpeedGoing;
      
      return minutesSaved;
   }
}