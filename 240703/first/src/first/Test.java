package first;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

//		int i = 3;
//		if( i <= 5 ) {System.out.println("1번");}
//		if( i <= 4 ) {System.out.println("2번");}
//		if( i <= 3 ) {System.out.println("3번");}
//		if( i <= 2 ) {System.out.println("4번");}
//		if( i <= 1 ) {System.out.println("5번");}
//		
//		int n = 9;
//		// 입력한 n값이 홀수라면 홀수입니다.를 출력 ,짝수라면 짝수입니다.를 출력
//		
//		if (0 != n % 2) /* ( n % 2 == 1) */ {
//			System.out.println("홀수입니다.");
//		} else {
//			System.out.println("짝수입니다.");
//		}
//		
//		int a = 12, b = 4, c = 19;
//		
//		int max = ( a > b ) ? a : b; // 3항식 :조건식 또는 조건값 ? 참일 경우 실행코드 : 거짓일 경우 실행코드
////		if (a > b) max = a; 이 if~ else문을 위와같은 3항식으로 줄일 수 있다.
////		else max = b;
//		max = ( max > c ) ? max : c;
//		System.out.println( "최대값은 " + max);

//		int score = 88;
//		char grade; // 값을 할당할 경우, 필수적으로 한개를 넣어야한다.
//		// 이처럼 초기값을 할당하지 않고 if 문을 사용한다면, 반드시 else가 존재해야한다. => 조건에 의해 값이 할당되지 않을 수도 잇음.
////		String s = ""; // 0개 이상의 문자를 가질 수 있어 빈 문자열 값을 가질 수 있다. 비어있는 문자열을 넣었기 때문에 덧셈 가능.
////		String s =null; // 무엇이 있는지 모르는 상태로 덧셈을 할 수 없다.
//
//		if (score >= 90) {
//			grade = 'A';
//		} else if (score >= 80) {
//			grade = 'B';
//		} else if (score >= 70) {
//			grade = 'C';
//		} else if (score >= 60) {
//			grade = 'D';
//		} else {
//			grade = 'F';
//		}
//
//		System.out.println("학점은 " + grade);

		// switch case문
//		int score = 88;
//		char grade;
//		
//		switch(score/10) {
//		// 출력될 값이 같다면 아래와 같이 붙여 쓸 수 있다.
//		// break;를 붙여주지 않으면 마지막 값이 할당되기 때문에 F가 출력된다.
//			case 10 : case 9 : grade = 'A'; break;
//			case 8 : grade = 'B'; break;
//			case 7 : grade = 'C'; break;
//			case 6 : grade = 'D'; break;
//			default : grade = 'F';
//		}
//		System.out.println("학점은 " + grade);

//		int i = 1;
//		String str = "";
//		
//		switch (i) {
//		case 1 : str += "1";
//		case 2 : str += "2";
//		case 3 : str += "3";
//		case 4 : str += "4";
//		case 5 : str += "5";
//		default : str += "6";
//		}
//		// case 1 : str += "1"; 뒤에 break;가 없기 때문에 조건이 맞지 않더라도 default까지 모두 출력된다. 
//		// => case : 1 ~~~ default 문장까지 하나의 문장으로 이해한다고 봐도 된다.
//		System.out.println(str);

//		int i = 3;
//		String str = "";
//		switch(i) {
//		case 6 : str += "고길동 ";
//		case 5 : str += "도우넛 ";
//		case 4 : str += "둘리 ";
//		case 3 : str += "박희동 ";
//		case 2 : str += "또치 ";
//		default : str += "마이콜 ";
//		}
//		System.out.println("----------------");
//		System.out.println(str);
//		System.out.println("\n----------------");

		// for문 예제
//		System.out.println("for문 1");
//
//		for (int n = 1; n <= 10; n++) {
//			System.out.println("Hello Java " + n);
//		}
////		n을 for문 내에서 선언했기 때문에 전역 변수가 아니므로 오류가 출력된다.
////		System.out.println(n);
//		System.out.println("for문 탈출");
//		System.out.println("\n=====\n");

//		출력결과 : 3 4 5가 되는 for문 작문하기
//		for (int n = 3; n <= 5; n++) {
//			System.out.print(n + " ");
//		}

//		다른 방법이지만 결과는 동일하게 출력된다.
//		int n;
//		for (n = 3; n <= 4; n++) {
//			System.out.print(n + " "); 
//		} // for문을 통해 "3 4 "가 출력
//		System.out.println(n); //for문을 통해 n이 5로 나왔으니 "3 4 5"가 출력된다.

		// for문 2
//		System.out.println("for문 2");
//		int total = 0;
//		
//		for (int n = 1; n <= 10; n++) {
//			if (n == 7) {
//				break;
//			}
//			total += n;
//		}
//		
//		System.out.println("합계는 " + total);
//		System.out.println("\n=================\n");

//		System.out.println("for문 3");
//		
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 == 0) {
//				continue; // i를 2로 나눈 값의 나머지가 0과 같을 때, 아래의 코드를 생략하고 for문으로 돌아가라.
//			}
//			System.out.print(i + " ");
//		}
//		System.out.println("\n==========\n");

//		System.out.println("while문 1");
//
//		int total = 0;
//		int i = 1;
//		while (i <= 10) {
//			total += i;
////			System.out.print("i의 값 " + i + " / ");
////			System.out.println("total의 값" + total);
//			i++;
//		}
//		System.out.println(total);
//		System.out.println("\n==========\n");

		// while문 2
//		int i = 1;
//		while (i <= 5) {
//			if (i == 1)
//				System.out.println("while문 시작 시 : " + i);
//			System.out.print(i + " ");
//			i++;
//		}
//		System.out.println("\nwhile문 종료 후 : " + i + "\n\n");
//
//		i = 1;
//		while (i <= 5) {
//			if (i == 1)
//				System.out.println("while문 시작 시 :" + i);
//			if (i == 4)
//				break; // * if 조건문에서는 사용되지 않는다. 반복문 혹은 switch문의 종료 중괄호 밖으로 넘어간다.
//			System.out.print(i + " ");
//			i++;
//		}
//		System.out.println("\nwhile문 종료 후 :" + i);

		/*
		 * 출력 결과 while문 시작 시 : 1 1 2 4 5 while문 종료 후 : 6
		 */

//		int i = 1;
//		while(i <= 5) {
//			if (i == 1) System.out.println("while문 시작 시 : " + i);
//			if (i != 3) System.out.print(i + " ");
//			i++;
//
//		}
//			System.out.println("\nwhile문 종료 후 : " + i);

		// do while문
//		System.out.println("do while문 1");
//		int total = 0;
//		int i = 1;
//		
//		do {
//			total += i;
//			i++;
//		} while (i <= 10);
//		
//		System.out.println(total);
//		System.out.println();

		/*
		 * 구구단 2단을 출력하는 반복문 int s = 2; -> 반복되는 숫자인 2를 변수로 지정
		 * System.out.printf("%d * %d = %d",s,숫자값변수, (s*숫자값변수);
		 * 
		 * for(int i = 1; i <= 9; i++){ System.out.printf("%d * %d = %d \n",s,숫자값변수,
		 * (s*숫자값변수);}
		 */
//		
//		// for문 두개를 이용한 2~5단 출력
//		for (int s = 2; s <= 5; s++) {
//			for (int i = 1; i <= 9; i++) {
//				System.out.printf("%d * %d = %d \n", s, i, (s * i));
//									// s * i = (s*i);
//			}
//		}
		// for문 한 개와 while문 하나를 이용해서 2~5단 출력
//		int s = 2;
//		while (s <= 5) {
//			for (int i = 1; i <= 9; i++) {
//				System.out.printf("%d * %d = %d \n", s, i, (s * i));
//			}
//			s++;
//		}

		// 무한반복문
		
		// Scanner 사용 시 상단에 import java.util.Scanner; 작성 필요. (유니티와 동일)
		Scanner sc = new Scanner(System.in);
		
		// for문 무한루프방식
		// 초기식, 조건식 모두 없기 때문에 '반복해라' 인식
//		for (;;) {
//			System.out.println("정수값을 입력해주세요.");
//			int a = sc.nextInt();
//			
//			System.out.println("정수값을 입력해주세요.");
//			int b = sc.nextInt();
//			int result = a + b;
//			if (result >= 12) {
//				System.out.println("값은 " + result + "입니다.");
//				break; // result 값이 12보다 크기 때문에 for문 종료
//			} else {
//				System.out.println("숫자가 12 이상이 되는 값으로 넣어야 합니다.");
//			}
//		}
	
		// while문 무한루프 방식
//		boolean tf = true;
//		while (tf == true) {
//			System.out.println("정수값을 입력해주세요.");
//			int a = sc.nextInt();
//			
//			System.out.println("정수값을 입력해주세요.");
//			int b = sc.nextInt();
//			int result = a + b;
//			if (result >= 12) {
//				System.out.println("값은 " + result + "입니다.");
//				tf = false;
//			} else {
//				System.out.println("숫자가 12 이상이 되는 값으로 넣어야 합니다.");
//			}	
//		}

		// do~while문 무한루프방식
		boolean tf = true;
		do {
			System.out.println("정수값을 입력해주세요.");
			int a = sc.nextInt();
			
			System.out.println("정수값을 입력해주세요.");
			int b = sc.nextInt();
			int result = a + b;
			if (result >= 12) {
				System.out.println("값은 " + result + "입니다.");
				tf = false; // 전역변수 tf 선언 후 초기값 true 지정하거나 break;로 설정
			} else {
				System.out.println("숫자가 12 이상이 되는 값으로 넣어야 합니다.");
			}	
		}while(tf == true); // tf 선언 시 tr == true로, break; 작성 시 그냥 true로 작성
		
	}
}
