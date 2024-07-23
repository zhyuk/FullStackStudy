package first;

public class Test1 {

	public static void main(String[] args) {

		int s = 2;
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d \n", s, i, (s * i));
			if (i == 9) {
				if (s <= 8) {
					i = 0;
					s++;
				}

			}
		}
	}
}