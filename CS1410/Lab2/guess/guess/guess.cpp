#include <iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;

int main()
{
	srand((unsigned)time(nullptr));
	int randomNumber = rand() % 100;
	int userGuess = 0;

	cout << "Play a guessing game! Type -1 to quit at any time. Guess a number from 0 to 99: ";
	cin >> userGuess;

	do
	{
		if (userGuess < -1 || userGuess > 99)
		{
			cout << "Sorry, that is not a valid guess.";
			exit(0);
		}
		if (userGuess == -1)
		{
			exit(0);
		}
		if (randomNumber == userGuess)
		{
			cout << "You win!" << endl;
			exit(0);
		}
		if (userGuess < randomNumber)
		{
			cout << "Your guess is low. Guess again: ";
			cin >> userGuess;
		}
		else {
			cout << "Your guess is high. Guess again: ";
			cin >> userGuess;
		}
	} while (true);

	return 0;
}