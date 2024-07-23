package inheritance;

public class InhEx07 {
	public static void main(String[] args) {
		Ch c = new Ch();
		c.show("상속 오버로딩");
		c.show(7);
		c.show();
		
		Pa p = new Ch();
		p.show();
		System.out.println(c.a);
		System.out.println(p.a);
	}
}

class Pa {
	int a = 5;
	void show(){
		System.out.println("상위클래스 메소드 show");
	}
	
	void show(String str) {
		System.out.println("상위클래스 메소드 show(String str) " + str);
	}
}

class Ch extends Pa {
	String a = "하하하";
	void show() {
		System.out.println("하위클래스 메소드 show()");
	}
	
	void show(int i) {
		System.out.println("하위클래스 메소드 show(int str) " + i);
	}
}

