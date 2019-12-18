# Mission 10

CS 1400 - Hilton

For this week’s assignment, we will be recreating the Rock, Paper, Scissors program using Object-Oriented Programming. You will be working with me on a team to build the program.

I have already written my part of the program, and the Game.java file is attached.

Your task will be to write a RockPaperScissors class that contains the following methods:

**getUserChoice**: Has the user choose Rock, Paper, or Scissors. After validating the input, the method returns a String containing the user choice.

**getCPUChoice**: Randomly selects Rock, Paper, or Scissors for the computer, and returns a String containing the computer choice.

**pickWinner**: Is passed two Strings containing the user choice and the computer choice. Compares the two choices and selects a winner. Returns a String containing "User", "Computer", or "Tie" to indicate the winner.

Your class should interact with my class to make the game function correctly.


Sample session:
*Welcome to Rock, Paper, Scissors!*  
*How many rounds would you like to play?:*
**2**
*Sorry, you need to enter an odd number. Please try again:*  
**4**  
*Rock, Paper, or Scissors?:*  
**Monkey**  
*Sorry, "Monkey" is not a valid entry.*  
*Rock, Paper, or Scissors?:*  
**Rock**  
Computer chooses Paper. Computer wins!
*Rock, Paper, or Scissors?:*  
**Rock**  
*Computer chooses Rock. It’s a tie. Play again.*  
*Rock, Paper, or Scissors?:*  
**Paper**  
*Computer chooses Rock. User wins!*  
*Rock, Paper or Scissors?:*  
**Rock**  
*Computer chooses Scissors. User wins!*  
*User wins:*  
**2**  
*Computer wins:*  
**1**  
*The user won!*  
