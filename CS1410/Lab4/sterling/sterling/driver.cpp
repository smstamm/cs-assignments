#include <iostream>
#include "sterling.h"
using namespace std;

int main()
{
	sterling s1 = make_sterling(1, 5, 5);
	//print(s1);

	sterling s2 = make_sterling(305);
	//print(s2);

	sterling s3 = make_sterling(1, 5, 5);
	sterling s4 = make_sterling(1, 8, 6);

	sterling s5 = make_sterling(1, 10, 6);
	sterling s6 = make_sterling(1, 10, 6);

	sterling s7 = make_sterling(5, 15, 9);
	sterling s8 = make_sterling(6, 14, 8);

	sterling s9 = add(s3, s4);
	//print(s9);

	sterling test;
	cout << "test: " << &test;
	read(&test);

	//print(test);

	return 0;
}