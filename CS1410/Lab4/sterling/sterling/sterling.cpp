#include <iostream>
#include <iomanip>
#include "sterling.h"
using namespace std;

sterling make_sterling(int pds, int shil, int pence)
{
	sterling temp;
	temp.pounds = pds;
	temp.shillings = shil;
	temp.pence = pence;

	return temp;
}

sterling make_sterling(int pence)
{
	sterling temp;

	temp.pounds = pence / 240;
	pence %= 240;
	temp.shillings = pence / 12;
	temp.pence = pence % 12;

	return temp;
}

sterling add(sterling num1, sterling num2)
{
	int pence1 = num1.pounds * 240 + num1.shillings * 12 + num1.pence;
	int pence2 = num2.pounds * 240 + num2.shillings * 12 + num2.pence;

	return make_sterling(pence1 + pence2);
}

void print(sterling& num)
{
	cout.fill('0');
	cout << (char)156 << num.pounds << "." << setw(2) << num.shillings << "." << setw(2) << num.pence << endl;
}

void read(sterling* s)
{
	int pds;
	int shil;
	int pence;

	cout << "read: " << &s;

	cout << "Enter pounds: ";
	cin >> pds;
	s->pounds = pds;

	cout << "Enter shillings: ";
	cin >> shil;
	s->shillings = shil;

	cout << "Enter pence: ";
	cin >> pence;
	s->pence = pence;
}