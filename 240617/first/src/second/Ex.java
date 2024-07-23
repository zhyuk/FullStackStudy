// 패키지 : 나의 클래스의 소속을 명시
// 명시하는  형식 : package 패키지경로;
package second;

// 패키지가 다른 클래스로 객체를 생성하는 경우는 
// 해당 클래스의 소속을 명시해 주어야 한다.
// 명시하는 형식 : import 패키지경로 포함,클래스명;
//import first.E;
// first 패키지 내 모든 클래스를 사용합니다.
import first.*;


public class Ex {
	public static void main(String[] args) {
		System.out.println("second 패키지 안의 Ex 클래스 입니다.");
		
		E e = new E();
	}
}
