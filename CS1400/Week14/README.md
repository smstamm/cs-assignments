# Mission 11

CS 1400 - Hilton

Build a class named Roulette with a method named betOnce that takes a console Scanner and an integer as parameters and that allows the user to make a bet about the integer. The bet involves guessing whether a number between 1 and 36 is in the lower half of the range (1 through 18) or the upper half of the range (19 through 36). It will also be possible for the number to be 0, in which case the user always loses. Similar rules are used in a game called Roulette.

The **betOnce** method should prompt the user for which bet they want to make and should then report the number and whether the user won or lost.

Then build a driver class (named whatever you would like) that creates and uses an instance of the other class in order to play the game. The main method will look something like this:

```Scanner in = new Scanner(System.in);
Random r = new Random();
int number = r.nextInt(37);
[objectname].betOnce(in, number);```

*For example, below is a log of execution where the user enters "1" to bet on the low range:*

```Do you want to bet on 1) low or 2) high? 1
The number was 1
You win```

Below is a log where the user enters "2" to bet on the high range:

```Do you want to bet on 1) low or 2) high? 2
The number was 11
You lose```

You may assume that your method is always passed a number between 0 and 36. Remember that
the user always loses when the number is 0.

