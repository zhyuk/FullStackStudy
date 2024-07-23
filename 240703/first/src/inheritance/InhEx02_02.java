package inheritance;

public class InhEx02_02 {

	public static void main(String[] args) {
		C c = new C(); //cha - cha케이스 // 자료형 C, 오브젝트, P
		//업케스팅- 하위클래스(=서브클래스=자식클래스)자료형이 상위클래스로 변환되는 것
		P c1 = new C(); // pa - cha케이스
		c1.md();
	}

}

class P {
	int a = 0;
	int b = 5;
	
	public void md() { // -재정의를 하기 위해서는 부모와 접근 제어가 같거나 높아야 한다. public
		a = 5;
		System.out.println(a + b);
	}
}

class C extends P{
	String a = "오버라이딩"; // 멤버필드는 오버로딩
	
	public void md() { // -재정의를 하기 위해서는 부모와 접근 제어가 같거나 높아야 한다. public
		System.out.println(a + b);
		super.md(); //부모클래스 접근해서 md()호출 클래스 P의 public void md() 접근
		this.md(); //나의클래스 public void md1() 접근
	}
	
	public void md1() {
		System.out.println("md1()메소드 호출");
	}
}