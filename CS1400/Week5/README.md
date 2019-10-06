# Mission 4

CS 1400 - Hilton

Write a "Rock, Paper, Scissors" game in Java. Prompt the user to enter a number of games to play. In order to eliminate the possibility a tie in the end, ensure that the user enters an odd number of games.

The user and computer will each choose between three items: rock (defeats scissors, but loses to paper), paper (defeats rock, but loses to scissors), and scissors (defeats paper, but loses to rock.) If the user makes an invalid choice, prompt them to try again.

The computer will choose randomly which item to play. In the event that the user and computer choose the same item, there is no winner, and the round is replayed.

Keep track of the number of wins each by the user and by the computer. After the game has ended, print the number of wins by the user and by the computer, and declare a winner.

Sample session:
*Welcome to Rock, Paper, Scissors!*
*Please enter the number of rounds you would like to play:*
**2**
*Sorry, you need to enter an odd number. Please try again:*
**4**
*Sorry, you need to enter an odd number. Please try again:*
**3**
*Rock, Paper, or Scissors?:*
**Monkey**
*Sorry, "Monkey" is not a valid entry.*
*Rock, Paper, or Scissors?:*
**Rock**
Computer chooses Paper. You lose.
*Rock, Paper, or Scissors?:*
**Rock**
*Computer chooses Rock. It’s a tie.*
*Rock, Paper, or Scissors?:*
**Paper**
*Computer chooses Rock. You win!*
*Rock, Paper or Scissors?:*
**Rock**
*Computer chooses Scissors. You win!*
*User wins:*
**2**
*Computer wins:*
**1**
*User wins the game!*
