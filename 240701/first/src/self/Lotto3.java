package self;

import java.util.*;

public class Lotto3 {

	public static void main(String[] args) {
		ArrayList<Integer> lottoNum = new ArrayList<>();
		Random rd = new Random();
		
		while(true) {
			lottoNum.add(rd.nextInt(45) + 1);
			if(lottoNum.size() == 7) break;
		}
		
		Integer[] allNum = lottoNum.toArray(new Integer[0]);
		Integer[] priceNum = new Integer[6];
		
		System.arraycopy(allNum, 0, priceNum, 0, 6);
		Arrays.sort(priceNum);
		for(int i = 0; i < priceNum.length; i++) {
			if(i == priceNum.length -1) {System.out.println(priceNum[i]);} 
		}
	}

}
