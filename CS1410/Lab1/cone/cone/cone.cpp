#define _USE_MATH_DEFINES
#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	double V, S, r, h;

	cout << "Enter the radius: ";
	cin >> r;

	cout << "Enter the height: ";
	cin >> h;

	V = 1.0 / 3.0 * M_PI * pow(r, 2) * h;
	S = M_PI * r * sqrt(pow(r, 2) + pow(h, 2)) + (M_PI * pow(r, 2));

	cout << "Volume of the cone is: " << V << endl;
	cout << "Surface area of the cone is: " << S << endl;

	return 0;
}