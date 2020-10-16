#include <iostream>
#include <iomanip>
using namespace std;

int main(int score);
double mean(int scores[], int scoresSize);
double deviation(int scores[], int size, double average);
int* histogram(int scores[], int size);
double standardDeviation = 0;

int main(int score)
{
	int scoreInput;
	int scoresSize = 0;
	int scores[100];

	do {
		cout << "Enter a score. Press -1 to quit:  ";
		cin >> scoreInput;

		if (scoreInput != -1)
		{
			scores[scoresSize] = scoreInput;
			scoresSize++;
		}
		else {
			double average = mean(scores, scoresSize);
			double standardDeivation = deviation(scores, scoresSize, average);
			int* toPrint = histogram(scores, scoresSize);

			for (int i = 9; i >= 0; i--)
			{
				cout << i << "| " << setfill('*') << setw(toPrint[i] + 1) << '\n';
			}

			cout << "SD: " << standardDeivation << endl;
		}

	} while (scoreInput != -1);
}

double mean(int scores[], int size)
{
	double scoresSum = 0;

	for (int i = 0; i < size; i++)
	{
		scoresSum += scores[i];
	}

	return scoresSum / size;
}

double deviation(int scores[], int size, double average)
{
	double newThing[100];
	double sum = 0;
	int newThingSize = 0;

	for (int i = 0; i < size; i++)
	{
		newThing[i] = pow(scores[i] - average, 2);
		newThingSize++;
	}

	for (int j = 0; j < newThingSize; j++)
	{
		sum += newThing[j];
	}

	double sd = sqrt(sum / size);

	return sd;
}

int* histogram(int* scores, int size)
{
	static int bin[10] = {};

	for (int i = 0; i < size; i++)
	{
		if (scores[i] >= 90) { bin[9]++; }
		else if (scores[i] >= 80 && scores[i] < 90) { bin[8]++; }
		else if (scores[i] >= 70 && scores[i] < 80) { bin[7]++; }
		else if (scores[i] >= 60 && scores[i] < 70) { bin[6]++; }
		else if (scores[i] >= 50 && scores[i] < 60) { bin[5]++; }
		else if (scores[i] >= 40 && scores[i] < 50) { bin[4]++; }
		else if (scores[i] >= 30 && scores[i] < 40) { bin[3]++; }
		else if (scores[i] >= 20 && scores[i] < 30) { bin[2]++; }
		else if (scores[i] >= 10 && scores[i] < 20) { bin[1]++; }
		else if (scores[i] < 10) { bin[0]++; }
	}

	return bin;
}