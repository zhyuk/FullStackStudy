package first;

// 다른 패키지 속 같은 이름의 클래스는 import로 선언할 수 없다.
//import second.Ex02;

public class Ex02 {
	
	public static void main(String[] args) {
		// 다른 패키지 속 같은 이름의 클래스를 선언하는 방법
		// 형식 : 패키지경로.클래스명 객체명 = new 패키지경로.클래스명;
		// second 패키지 속 Ex02 클래스에 접근한다.
		second.Ex02 e = new second.Ex02();
	}

}
