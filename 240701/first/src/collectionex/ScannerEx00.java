package collectionex;

import java.util.Scanner;

public class ScannerEx00 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0번: ");
		String s1 = sc.nextLine(); //끝 - 엔터, 공백 o
		
		System.out.print(s1 + "\n1번: ");
		s1 = sc.next(); // 끝 - 공백, 공백 x
		
		System.out.print(s1 + "\n2번: ");
		int i = sc.nextInt(); // 끝 - 공백, 공백 x
		
		System.out.print(i + "\n3: ");
		s1 = sc.next(); // 끝 - 공백, 공백 x
		
		System.out.print(s1 + "\n4: ");
		s1 = sc.next(); // 끝 - 공백, 공백 x
		System.out.println(s1);

	}

}
