package first;

public class Ex01 { // 클래스
	//public Ex01(){}
	public static String hello_func( ) { //메소드 선언문. 리턴타입 String. hello_func 메소드명
		return " Hello World! ";    // "Hello World" 반환
	}
	public static void main(String[] args) { // main은 JVM에 의해 리턴값 없어도 실행됨.
		String srt = hello_func();  // String 자료형을 담을 srt 변수에 hello_func 메소드 리턴값을 저장
		System.out.println( srt );          // return값 출력
		
	}

}
