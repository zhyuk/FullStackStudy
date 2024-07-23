package third;

public class Account {
	int count;
	static int total;
	
	Account(int amount) {
		count += amount;
		total += amount;
	}
}
