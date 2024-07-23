package self;

import java.util.*;

public class Lotto2 {
	
	static int[] lotto = new int[6];
	static int max = 45;
	static int bonus;

	public static void main(String[] args) {
		lotto();
		bonus();
		Arrays.sort(lotto);
		System.out.println("777회차 로또 당첨번호 " + Arrays.toString(lotto) + "  보너스번호 : " + bonus);

	}
	
	public static void lotto() {
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * max) +1;
			
			for(int j = 0 ; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	public static void bonus() {
		bonus = (int)(Math.random() * max) +1;
		if (lotto.equals(bonus) == true) {
			bonus = (int)(Math.random() * max) +1;
		}
	}

}
