/********************************************************
 * Mission08Stamm.java Stephanie Stamm
 *
 *
 * Calculates Body Mass Index (BMI)
 ********************************************************/

import java.util.*;

public class Mission08Stamm
{
   public static void main (String[] args)
   {      
      Scanner in = new Scanner (System.in);
      
      // Variable Declarations
      double heightInInches = 0.0;
      double weightInPounds = 0.0;
      double bodyMassIndex = 0.0;
      double bodyMassIndexRounded = 0.0;
      boolean hasHeightError = false;
      boolean hasWeightError = false;
      
      // Ask user for height
      System.out.println("Enter height in inches:");

      do
      {
         try
         {
            hasHeightError = false;
            heightInInches = in.nextDouble();
            
            // Ensure input is more than 0
            while (heightInInches <= 0.0)
            {
               System.out.println("Invalid inches value. Must be positive.");
               System.out.println("Re-enter height in inches:");
               heightInInches = in.nextDouble();
            }
         }
         // Ensure input is a number
         catch (InputMismatchException e)
         {
            hasHeightError = true;
            System.out.println("Invalid inches value. Must be a decimal number.");
            System.out.println("Re-enter height in inches:");
            
            // Flush the buffer
            in.nextLine();
         }
      } while (hasHeightError);
      


      // Ask user for weight
      System.out.println("Enter weight in pounds:");
      
      do
      {
         try
         {
            hasWeightError = false;
            weightInPounds = in.nextDouble();
            
            // Ensure input is more than 0
            while (weightInPounds <= 0.0)
            {
               System.out.println("Invalid pounds value. Must be positive.");
               System.out.println("Re-enter weight in pounds:");
               weightInPounds = in.nextDouble();
            }
         }
         
         // Ensure input is a number
         catch (InputMismatchException e)
         {
            hasWeightError = true;
            System.out.println("Invalid pounds value. Must be a decimal number.");
            System.out.println("Re-enter weight in pounds:");
            
            // Flush the buffer
            in.nextLine();
         }
      } while (hasWeightError);
      
      // Calculate BMI
      bodyMassIndex = 704 * weightInPounds / (Math.pow(heightInInches, 2));
      bodyMassIndexRounded = Math.round(bodyMassIndex * 10) / 10.0;
      
      // Print height, weight and BMI
      System.out.println("Height = " + heightInInches + "\"");
      System.out.println("Weight = " + weightInPounds + " pounds");
      System.out.println("Body mass index = " + bodyMassIndexRounded);
   }
}