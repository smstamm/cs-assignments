#include <iostream>
#include <iomanip>
#include "fraction.h"
using namespace std;


fraction fraction::add(fraction f2)
{
	int n1 = (numerator * f2.denominator) + (denominator * f2.numerator);
	int n2 = denominator * f2.denominator;

	return fraction(n1, n2);
}

fraction fraction::sub(fraction f2)
{
	int n1 = (numerator * f2.denominator) - (denominator * f2.numerator);
	int n2 = denominator * f2.denominator;

	return fraction(n1, n2);
}

fraction fraction::mult(fraction f2)
{
	int n1 = numerator * f2.numerator;
	int n2 = denominator * f2.denominator;

	return fraction(n1, n2);
}

fraction fraction::div(fraction f2)
{
	int n1 = numerator * f2.denominator;
	int n2 = denominator * f2.numerator;

	return fraction(n1, n2);
}

void fraction::print()
{
	cout << numerator << "/" << denominator << endl;
}

void fraction::read()
{
	cout << "Numerator: ";
	cin >> numerator;

	cout << "Denominator: ";
	cin >> denominator;
}

int gcd(int u, int v)
{
	u = (u < 0) ? -u : u;			// make u non-negative
	v = (v < 0) ? -v : v;			// make v non-negative

	while (u > 0)
	{
		if (u < v)
		{
			int t = u;	        // swap u and v
			u = v;
			v = t;
		}

		u -= v;
	}

	return v;				// the GCD of u and v
}