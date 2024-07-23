package inheritance;

public class Super01 {
	public static void main(String args[]) {
		Ch3 d = new Ch3(); //&100//대표자료:Ch3(Ch3, Pa3, Object)//cha-cha 케이스
		d.write();
	}
}

class Pa3 {
	int x = 100; //외부 X
	void display() { //외부 X
		System.out.println("상위클래스 display()");
	}
}

class Ch3 extends Pa3 {
	int x = 2000; //외부 O
	
	void display() { //외부 O 오버라이딩 부모 클래스에서 온 display()를 덮어씌움
		System.out.println("하위클래스 display()");
	}
	
	void write() { //외부 O
		super.display(); //상위클래스 display() //부모클래스 //내부 접근이라 가능하다.
		this.display(); //하위클래스 display() //cha-cha케이스
		System.out.println("super.x : " + super.x); //100 //부모클래스 //내부 접근이라 가능하다.
		System.out.println("this.x : " + x); //2000 //cha-cha케이스
	}
}
