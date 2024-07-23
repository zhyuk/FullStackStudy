package generic_004_bounded;

public class Util {
		//자식, 자손이 될수 있는 자료형클래스 extends 조상클래스나 인터페이스
	public static <T extends Ancestor> void boundType(T t1) {
					// ancestor를 포함한 자식 자료형만 올 수있다.
		t1.ancestor();
	}
}
