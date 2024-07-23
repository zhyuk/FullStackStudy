package inheritance;

public class Super01 {

	public static void main(String[] args) {
		Ch3 d = new Ch3();
		d.write();
	}
}

class Pa3 {
	int x = 1000; // 외부접근 불가능

	void display() { // 외부접근 불가능
		System.out.println("상위클래스 display()");
	}
}

class Ch3 extends Pa3 {
	int x = 2000; // 외부접근 가능 -> 오버라이드로 인해 부모클래스 내 x가 자식클래스 내 x에 덮어씌워짐
	
	void display() { // 외부접근 가능 -> 오버라이드로 인해 부모클래스 내 display()가 자식 클래스 내 display()에 덮어씌워짐
		System.out.println("하위클래스 display()");
	}
	
	void write() { // 외부접근 가능
		super.display();
		this.display();
		System.out.println("super.x : " + super.x);
		System.out.println("this.x : " + x);
	}
}
