package second;

public class ThisEx {

	public static void main(String[] args) {
		// a = 공간 생성 및 This 클래스의 주소값 복사 
		This a = new This();
		// This 클래스 내 amd() 메소드
		a.amd();
		// This 클래스 내 매개변수가 2개인 setNum 메소드
		a.setNum(2, "테스트");
		// This 클래스 내 amd() 메소드
		a.amd();

		// 변수 x 선언 및 This 클래스 내 getNum() 메소드 값을 변수 x에 저장
		int x = a.getNum();
		// 변수 x 출력
		System.out.println(x);
		// 변수 y 선언 및 This 클래스 내 매개변수 1개인 getNum() 메소드 값을 변수 y에 저장
		int y = a.getNum(5);
		// 변수 y 출력
		System.out.println(y);
	}
}

class This {
	// 전역변수 num 선언 및 초기값 1 할당;
	int num = 1;
	// 전역변수 str 선언 및 초기값 "한글" 할당;
	String str = "한글";
	
	// 매개변수 2개가 int형, String형인 setNum 메소드 선언문
	public void setNum(int num, String str) {
		// 전역변수 num = 매개변수 num;
		this.num = num;
		// 전역변수 str = 매개변수 str;
		this.str = str;
	}
	
	// int형을 리턴시켜주는 getNum 메소드 선언문
	public int getNum() {
		// 전역변수 num 리턴
		return num;
	}
	
	// int형을 리턴시켜주며 매개변수 int형 한 개를 갖고있는 getNum 메소드 선언문
	public int getNum(int j) {
		// 전역변수 num = 전역변수 num * 매개변수 j
		this.num = num * j;
		// 전역변수 num * 매개변수 j의 값 리턴
		return num;
	}
	
	// amd 메소드 선언문
	public void amd() {
		// 지역변수 num 선언 및 초기값 5 할당
		int num = 5;
		// 지역변수 str 선언 및 초기값 7 할당
		int str = 7;
		if (num <= 5) {
			// 전역변수 num 출력
			System.out.println("this.num 는 " + this.num);
			// 전역변수 str 출력
			System.out.println("this.str 는 " + this.str);
			// 지역변수 num 출력
			System.out.println("num 는 " + num);
			// 지역변수 str 출력
			System.out.println("str 는 " + str);
		}
		// 지역변수 num 출력
		System.out.println("num 는 " + num);
		// 지역변수 str 출력
		System.out.println("str 는 " + str);
		System.out.println();
	}
	
}
