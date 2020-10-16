int gcd(int u, int v);

class fraction
{
private:
	int	numerator;
	int	denominator;

public:
	fraction(int n = 0, int d = 1) : numerator(n), denominator(d)
	{
		int	common = gcd(numerator, denominator);
		numerator /= common;
		denominator /= common;
	}
	fraction add(fraction f2);
	fraction sub(fraction f2);
	fraction mult(fraction f2);
	fraction div(fraction f2);
	void print();
	void read();
};