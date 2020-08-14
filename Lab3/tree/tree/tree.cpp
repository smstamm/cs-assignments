#include <iostream>
using namespace std;

int main()
{
	int height;
	int base;
	int treeTrunk;
	int coneLeft;
	int coneRight;
	int totalSpaceBetweenCones;

	cout << "Enter the tree's cone height (between 3 and 15): ";
	cin >> height;
	height -= 1; //  matches height to level's zero-based index

	// exit program if invalid entry
	if (height < 3 || height > 15)
	{
		cout << "Sorry, that is not valid input.";
		exit(0);
	}

	// print left and right cone sides
	for (int level = 0; level <= height; level++)
	{
		int spaceToConeLeft = height - level - 1;
		for (spaceToConeLeft; spaceToConeLeft >= 0; spaceToConeLeft--)
		{
			cout << " ";
		}
		if (level == 0)
		{
			cout << "/\\" << endl;
		}
		else
		{
			cout << "/";
			
			totalSpaceBetweenCones = level * 2;
			for (int space = 0; space < totalSpaceBetweenCones; space++)
			{
				cout << " ";
			}
			cout << "\\" << endl;;
		}
	}

	// print cone base
	for (int base = 0; base <= height * 2 + 1; base++)
	{
		cout << "-";
	}
	cout << endl;

	// print trunk
	for (int trunk = 0; trunk < (height + 1) / 2; trunk++)
	{
		for (int spaceToTrunk = 0; spaceToTrunk <= height - 1; spaceToTrunk++)
		{
			cout << " ";
		}
		cout << "||" << endl;
	}

	return (0);

}