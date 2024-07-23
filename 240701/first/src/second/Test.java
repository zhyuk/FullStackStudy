package second;

public class Test {
	int a;
	String s;
	
	// 생성자 오버로딩
	public Test() {
		this(50); // Test 클래스 내 Test 이름을 가진 생성자 중 매개변수가 한 개이고 그 매개변수의 자료형이 int인 생성자를 의미
		System.out.println("디폴트생성자");
	}
	
	public Test(int a) {
		this.a = a;
		System.out.println(a);
	}
	// 객체생성 형식 : 자료형 객체명 = new 생성자호출문;
	public Test(String s) { // 객체생성 형식 : Test tt  = new Test("하하하");
		this.s = s;
		System.out.println(s);
	}
	
	public Test(int a, String s) { 
		this.a = a;
		this.s = s;
		System.out.printf("%d, %s %n", a,s);
	}
	
	// 메소드 오버로딩
	public void setPro() {
		a = 5;
		s = "테스트";
		setPro(5);
		setPro("테스트");
	}
	
	public void setPro(int a) {
		this.a = a;
	}
	
	public void setPro(String s) {
		this.s = s;
	}
	
	public void setPro(int a , String s) {
		this.a = a;
		this.s = s;
	}
}
