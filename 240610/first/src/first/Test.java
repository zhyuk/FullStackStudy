package first;

public class Test {

	public static void main(String[] args) {
//		참,거짓 구별 변수 tf를 선언하고 초기값으로 false로 지정한다.
		boolean tf = false;
//		변수 tf의 값 출력
		System.out.println(tf);
		
//		변수 tf의 값을 재할당한다.
		tf = true;
//		변수 tf의 값 출력
		System.out.println(tf);
		
//		정수형 변수 n을 선언하고 초기값으로 123을 지정한다.
		int n = 123;
//		실수형 변수 d를 선언하고 초기값으로 3.14를 지정한다.
		double d = 3.14;
//		문자형 변수 c를 선언하고 초기값으로 글을 지정한다.
		char c = '글';
//		논리형 변수 b를 선언하고 초기값으로 true 지정
		boolean b = true;
		
//		참조변수이면서 객체이다.
		String str = "날씨가 참 좋네요";
		
//		변수명은 고유명사로 변수명이 겹칠 수 없다.
//		char n = '하';
		
//		어떤 자료형을 출력하든 문자형으로 출력한다.
		System.out.println(n);
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);
		
		
		int a = 28 /5;
		int b1 = 28 % 5 ;
//		double의 경우 소수점까지 모두 작성해줘야한다.
		double a1 = 28.0 / 5.0;
		double a2 = 28 / 5;
//		float의 경우 숫자 뒤에 f를 붙여줘야한다.
		float a3 = 28f / 5f;

		
		System.out.println(a);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(b1);
		
		
	}

}
