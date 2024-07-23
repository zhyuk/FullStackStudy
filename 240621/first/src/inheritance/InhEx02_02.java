package inheritance;

public class InhEx02_02 {

	public static void main(String[] args) {
		C c = new C(); // Cha - Cha 케이스
		// 업캐스팅 - 하위클래스(=서브클래스=자식클래스) 자료형이 상위클래스로 변환되는 것
		P c1 = new C(); // Pa - Cha 케이스
		c1.md();
	}
}

class P {
	int a = 0;
	int b = 5;

	public void md() { 
		a = 5;
		System.out.println(a + b);
	}
}

class C extends P {
	String a = "오버라이딩";

	public void md() { // 재정의를 위해서는 부모의 접근제어자보다 자식의 접근제어자 영역이 좁아질 수 없다.
		System.out.println(a + b);
		super.md();
		this.md1();
	}

	public void md1() {
		System.out.println("md1() 메소드 호출");
	}
}
