package interfaceex;

public interface AInterEx01 {
	public static void main(String[] args) {
		//인터페이스 타입의 객체는 인터페이스에서 선언된 상수와
		// 메소드(오버라이드 포함)에만 접근 가능
		A ob = new A1(); //pa - cha
		ob.display("테스트1");
		
		System.out.println("A의 상수 값은 " + ob.CONS);
//		System.out.println("A1의 a값 출력 " + ob.a);  // pa - cha 케이스기 때문에 부모쪽에서만 가능
		System.out.println("A.CONS: " + A.CONS);
		
		//ob.pmd(); 상속받을 수 없다.
		//인터페이스의 static메소드는 객체명으로 접근 불가, 오버라이드 불가
		//System.out.println(ob.stmd(5)); A.stmd(5) 로 가능
		
		A1 ob2 = new A1();
		ob2.display("테스트2");
//		ob2.pmd(); // 상속받을 수 없다.
		ob2.dfmd("하하하");
		
		System.out.println("A의 상수 값은 " + ob2.CONS);
		System.out.println("A1.CONS: " + A1.CONS);
		System.out.println("A1의 a 값 출력" + ob2.a);
	
		System.out.println("ob2.stmd(8) 결과 : " + ob2.stmd(8));
		System.out.println("A.stmd(7) 결과 : " + A.stmd(7));
	}
}

class A1 implements A {
	int a = 10;
	static final int CONS = 2;
	
	public void display(String s) {
		System.out.println("display 메소드 구현 " + s);
	}
	
	public void imd() {
		System.out.println("imd메소드의 재정의");
	}	
	static int stmd(int c) {
		return CONS + c;
	}	
	void pmd() {
		System.out.println("A1인터페이스 안의 pmd: " + CONS);
	}
	
}
