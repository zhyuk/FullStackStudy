package javautilex;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		String s = "국적, 대한민국, 성명, 홍길동, 성별, 남, 주소, 서울시";
		
		//문자열을 토큰 단위로 분해해 줌.
		//문자열, 구분자, 구분자포함, 미포함(디폴트-false)
		StringTokenizer st1 = new StringTokenizer(s, "," , true);
		while (st1.hasMoreTokens()) {
			String e = st1.nextToken();
			System.out.print(e + "\t");
		}
		System.out.println("\n");
		
		st1 = new StringTokenizer(s, ",");
		while(st1.hasMoreTokens()) {
			String first = st1.nextToken();
			String second = st1.nextToken();
			System.out.println(first + "\t" + second);
		}
		System.out.println("\n");
		
		String expression = "x=100*(200+300)/2";
		StringTokenizer st = new StringTokenizer(expression, "+*/=()");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken() + "\t");
		}

	}

}
