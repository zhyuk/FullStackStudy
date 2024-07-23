package self;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6]; 
		int max = 45; 
		int bonus = (int) (Math.random() * max) + 1; 

		for (int i = 0; i < lotto.length; i++) {
			
			lotto[i] = (int) (Math.random() * max) + 1; 

			for (int j = 0; j < i; j++) { 
				if (lotto[i] == lotto[j]) {
					i--;
					break; 
				}
			}

			if (bonus == lotto[i]) { 
//				System.out.println("중복발생");
				bonus = (int) (Math.random() * max) + 1; 
			}
		}

		Arrays.sort(lotto); 
		System.out.print("777회 로또 당첨번호 : ");

		for (int number : lotto) { 
			System.out.print(number + " "); 
		}

		System.out.print("+ [보너스번호] " + bonus);
	}

}