import java.util.Scanner;

public class SStamm_FE
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      
      // Variables
      String firstName = "";
      String lastName = "";
      double ageInYears = 0.0;
      double ageInMonths = 0.0;
      double ageInDays = 0.0;
      double ageInHours = 0.0;
      double ageInMinutes = 0.0;
      double ageInSeconds = 0.0;
      
      // Get user's first name
      System.out.println("What is your first name?");
      firstName = in.nextLine();
      
      // Get users's last name
      System.out.println("What is your last name?");
      lastName = in.nextLine();
      
      // Get user's age in years
      System.out.println("What is your age in years?");
      ageInYears = in.nextDouble();
      
      // Calculate user's age in months, days, hours, minutes and seconds
      ageInMonths = ageInYears * 12; // 12 months in a year
      ageInDays = ageInYears * 365; // 365 days in year
      ageInHours = ageInDays * 24; // 24 hours in a day
      ageInMinutes = ageInHours * 60; // 60 minutes in an hour
      ageInSeconds = ageInMinutes * 60; // 60 seconds in minute
      
      // Inform user of their age in years, months, days, hours, minutes and seconds
      System.out.println(lastName + ", " + firstName);
      System.out.println(ageInYears + " years old.");
      System.out.println(ageInMonths + " months old.");
      System.out.println(ageInDays + " days old.");
      System.out.println(ageInHours + " hours old.");
      System.out.println(ageInMinutes + " minutes old.");
      System.out.println(ageInSeconds + " seconds old.");
   }
}