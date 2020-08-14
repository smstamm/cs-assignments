#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	double a, b, c, x1, x2, discriminant, real, imag;

	cout << "Enter coefficient a: ";
	cin >> a;

	if (a == 0)
	{
		cout << "Sorry, " << a << " is not a valid input for a." << endl;
		exit(0);
	} 

	cout << "Enter coefficient b: ";
	cin >> b;

	cout << "Enter coefficient c: ";
	cin >> c;

	discriminant = pow(b, 2) - 4 * a * c;

	if (discriminant >= 0) {
		x1 = (-b + sqrt(discriminant)) / (2 * a);
		x2 = (-b - sqrt(discriminant)) / (2 * a);

		cout << "x1 = " << x1 << endl;
		cout << "x2 = " << x2 << endl;
	}
	else
	{
		real = -b / (2 * a);
		imag = sqrt(-discriminant) / (2 * a);

		cout << "x1 = " << real << " + " << imag << "i" << endl;
		cout << "x2 = " << real << " - " << imag << "i" << endl;
	}

	return 0;
} 