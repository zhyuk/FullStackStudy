package collectionex;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력을 해주세요.");
		
		if(sc.hasNextInt()) {
			System.out.println("1번[" + sc.nextInt()+"] : 정수값입니다.");
		} else {
			String str = sc.nextLine();
					if(str.contains(" ")) {
						System.out.println("2번[ "+str+" ] : 공백을 포함한 문자열 값입니다.");
					} else {
						System.out.println("3번 [" + str + " ] : 공백이 없는 단어 단위의 문자열 값입니다.");
					}
		}

	}

}
