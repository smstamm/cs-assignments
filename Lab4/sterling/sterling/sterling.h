struct sterling {
	int pounds;
	int shillings;
	int pence;
};

sterling make_sterling(int pds, int shil, int pence);
sterling make_sterling(int pence);
sterling add(sterling num1, sterling num2);
void print(sterling& num);
void read(sterling* s);
