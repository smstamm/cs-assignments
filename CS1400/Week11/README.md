# Mission 11

CS 1400 - Hilton

For this week’s assignment, we will be creating a banking program. You will again be working on a team with me to build this program.

I have written the BankAccount class that you can use to create a BankAccount object. The file named BankAccount.java is attached.

Ask the user for their name, and then create an instance of the BankAccount object for the customer using their name and an account number of your choice. (You can just make one up.)

Then ask the user whether they want to:

1) Make a Deposit
2) Make a Withdrawal
3) Print Account Information
4) Quit

If the user chooses to make a deposit, ask them for the amount, and make the deposit to the bank account.

If the user chooses to make a withdrawal, ask them for the amount, and then make the withdrawal from the bank account.

If the user chooses to print account information, print the name on the account, the account number, and the account balance.

If the user enters an invalid choice, prompt them to choose again.

Repeat the options until the user chooses to quit.

Sample Session:
*Welcome to the Bank of Spencer!*
*Please enter your name to create an account:*
Spencer Hilton

*Press 1 to make a deposit*
*Press 2 to make a withdrawal*
*Press 3 to get account information*
*Press 4 to quit*
5
*Invalid choice, please try again*
1
*Please enter the amount to deposit:*
100

*Press 1 to make a deposit*
*Press 2 to make a withdrawal*
*Press 3 to get account information*
*Press 4 to quit*
2
*Please enter the amount of the withdrawal*
50

*Press 1 to make a deposit*
*Press 2 to make a withdrawal*
*Press 3 to get account information*
*Press 4 to quit*
3

Name: Spencer Hilton
Account #: 12345
Balance: $50.0

*Press 1 to make a deposit*
*Press 2 to make a withdrawal*
*Press 3 to get account information*
*Press 4 to quit*
4

*Thank you for your business!*