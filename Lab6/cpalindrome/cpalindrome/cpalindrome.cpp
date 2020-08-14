#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	char concatenatedString[1000] = "";
	char reversedString[1000] = "";

	// Concatenates c-string array
	for (int i = 1; i < argc; i++)
	{
		strcat(concatenatedString, argv[i]);
	}

	// Reverses c-string array
	for (int j = strlen(concatenatedString) - 1; j > 0; j--)
	{
		char temp = concatenatedString[j];
		reversedString[j] = concatenatedString[strlen(concatenatedString) - j - 1];
		reversedString[strlen(concatenatedString) - j - 1] = temp;
	}

	// Compares both c-string arrays and decides if it's a palindrome
	if (strcmp(concatenatedString, reversedString) == 0)
	{
		cout << "It IS a palindrome!";
	}
	else {
		cout << "It is NOT a palindrome.";
	}
}