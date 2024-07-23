package interfaceex;

public interface AInterEx0 {
	public static void main(String[] args) {
		A memo;
		memo = new C1();
		memo.display("안녕하세요.");
		
		memo = new C2();
		memo.display("즐거운 자바 수업 시간입니다.");
		
		memo = new C3();
		memo.display("자바를 잡아봅시다.");
		
		memo.dfmd("\" 안녕 자바\"");
		System.out.println(A.stmd(5) + C3.stmd(1));
//		System.out.println(A.stmd(2) + memo.stmd(1));
		
	}
}

class C1 implements A {
	public void display(String s) {
		System.out.println("클래스 C1 객체 이용 : " + s);
	}
	
	public void imd() {
		System.out.println("imd메소드 재정의");
	}
}

class C2 implements A {
	public void display(String s) {
		System.out.println("클래스 C2 객체 이용 : " + s);
	}
	public void imd() {
		System.out.println("imd메소드 재정의");
	}
}

class C3 implements A {
	public void display(String s) {
		System.out.println("클래스 C3 객체 이용 : " + s);
	}
	
	public void dfmd(String str) {
		int a = 5 ;
		System.out.println("C3클래스 안의 dfmd메소드의 str변수 값 : " + str + "와 CONS의 값 : " + CONS + "와 a의 값 : " +a);
	}
	
	public void dfmd() {
		System.out.println("dfmd()메소드 오버로딩");
	}
	static int stmd(int a) {
		return CONS + a;
	}
	public void imd() {
		System.out.println("imd메소드 재정의");
	}
}
