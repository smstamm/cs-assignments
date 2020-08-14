#include <iostream>
#include <string>
using namespace std;

string removeSpaces(string);
string reverseString(string);

int main()
{
	// Saves user input
	string userInput = "";
	cout << "Enter text to see if it is a palindrome: ";
	getline(cin, userInput);

	// Removes spaces from user input
	string stringWithoutSpaces = removeSpaces(userInput);

	// Checks if the reversed string without spaces is a palindrome
	if (reverseString(stringWithoutSpaces) == stringWithoutSpaces)
	{
		cout << "It IS a palindrome!";
	}
	else {
		cout << "It is NOT a palindrome.";
	}
}

// Removes spaces from string
string removeSpaces(string str)
{
	for (int i = 0; i < str.length(); i++)
	{
		while (str[i] == ' ')
		{
			str.erase(i, 1);
		}
	}

	return str;
}

// Reverses string after spaces have been removed
string reverseString(string str)
{
	string reversedStr = "";
	for (int i = str.length(); i > 0; i--)
	{
		reversedStr += str[i - 1];
	}

	return reversedStr;
}