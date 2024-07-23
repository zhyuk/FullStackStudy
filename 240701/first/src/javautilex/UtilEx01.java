package javautilex;

import java.util.Arrays;


public class UtilEx01 {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,} ;
		arrayPrint("초기 배열 : ", a); //해당 멤버 메소드
		System.out.println();
		
		Arrays.fill(a, 3, 5, 33); // 배열의 3 ~ 4번 요소를 33으로 채움
		arrayPrint("fill() 수행 후 : ", a);
		System.out.println();
		
		Arrays.sort(a);
		arrayPrint("sort() 수행 후 : ", a);
		System.out.println();
		
		System.out.println("33은 배열의 " + Arrays.binarySearch(a, 33) + "번 요소");
		System.out.println("-3은 배열의 " + Arrays.binarySearch(a, -3) + "번 요소");
		
		//배열에 없는 값을 탐색하는 경우 해당 값을 정렬시킨 후 상대적으로 값 출력 (-1부터 셈)
		System.out.println("53은 배열의 " + Arrays.binarySearch(a, 53) + "번 요소");
		System.out.println("4은 배열의 " + Arrays.binarySearch(a, 4) + "번 요소");
		System.out.println();
		
//		 for(int i = 0; i < a.length ; i++) Arrays.fill(a, i, i+1, i);
//		 Arrays.sort(a);	
//		 arrayPrint("sort() 수행 후 : ", a);
//		 System.out.println();
		
		int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("배열a와 배열b가 같은가 : " + Arrays.equals(a, b));
		System.out.println();
		
		int[] c = new int[5];
		//System.arraycopy( 배열1, 배열1의 복사시작번호, 배열2, 배열2의 복사시작번호, 복사길이)
		System.arraycopy(b, 1, c, 0, 5);
		arrayPrint("c : ", c);
		System.out.println();
		
		b[3] = 15;
		arrayPrint("b : ", b);
		arrayPrint("c : ", c);
		System.out.println();
	}
	
	static void arrayPrint(String s, int[] a) {
		System.out.print(s);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
