package inheritance;

public class InhMain {
	public static void main(String[] args) {
		A b = new B();
		b.paint();
		b.draw();
	}

}

class A {
	public void paint() {
		System.out.print("A");
		draw();
	}

	public void draw() {
		System.out.print("B");
		draw(); //자식걸로 넘어가 "D"가 나온다.
	}

}

class B extends A {
	public void paint() { //오버라이드 때문에 부모 클래스의 paint() 메소드로 가지 않는다.
		super.draw(); //super라는 키워드는 오버라이드랑 상관없이 부모 클래스의 draw();를 불러온다.
		System.out.print("C");
		this.draw();
	}

	public void draw() { //오버라이드 때문에 부모 클래스의 draw() 메소드로 가지 않는다.
		System.out.print("D");
	}

}
