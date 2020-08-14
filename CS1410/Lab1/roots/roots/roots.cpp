#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	double a, b, c, x1, x2;

	cout << "Enter coefficient a: ";
	cin >> a;

	cout << "Enter coefficient b: ";
	cin >> b;

	cout << "Enter coefficient c:";
	cin >> c;

	x1 = (-b + (sqrt(pow(b, 2) - 4 * a * c))) / (2 * a);
	x2 = (-b - (sqrt(pow(b, 2) - 4 * a * c))) / (2 * a);

	cout << "x1: " << x1 << endl;
	cout << "x2: " << x2 << endl;

	return 0;
}