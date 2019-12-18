/********************************************************
 * Mission11Stamm.java Stephanie Stamm
 *
 *
 * Enables user to perform bank account transactions
 ********************************************************/
 
 import java.util.Scanner;
 
 public class Mission11Stamm
 {
   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      
      // Variables
      String name = "";
      int accountNumber = 0;
      int transactionType = 0;
      double amount = 0.0;
      
      System.out.println("Welcome to the Bank of Spencer!");
      
      // Get user's name
      System.out.println("Please enter your name to create an account.");
      name = in.nextLine();
      
      // Get user's bank account number
      System.out.println("Please enter your account number.");
      accountNumber = in.nextInt();
      
      // Create new instance of BankAccount
      BankAccount ba = new BankAccount (name, accountNumber);
            
      do
      {
         // Get action user wants to perform
         System.out.println("Press 1 to make a deposit");
         System.out.println("Press 2 to make a withdrawal");
         System.out.println("Press 3 to get account information");
         System.out.println("Press 4 to quit");
         transactionType = in.nextInt();
         
         // Ensure user input is valid action
         while (transactionType != 1 && transactionType != 2 && transactionType != 3 && transactionType != 4)
         {
            System.out.println("Invalid choice, please try again.");
            transactionType = in.nextInt();
         }

         // Execute user's selected action
         switch(transactionType)
         {
            case 1: // Deposit
            {
               System.out.println("Please enter the amount to deposit.");
               amount = in.nextDouble();
               
               ba.deposit(amount);
               break;
            }
            case 2: // Withdrawal
            {
               System.out.println("Please enter the amount of the withdrawal.");
               amount = in.nextDouble();
               
               ba.withdraw(amount);
               break;
            }
            case 3: // Print Account Info
            {
               String formattedAmount = String.format("%.2f", ba.getBalance());
               
               System.out.println("Name: " + name);
               System.out.println("Account #: " + accountNumber);
               System.out.println("Balance: $" + formattedAmount);
               break;
            }
            case 4: // Quit
            {
               System.out.println("Thank you for your business!");
               break;
            }
         }
      } while (transactionType != 4);
   }
 }