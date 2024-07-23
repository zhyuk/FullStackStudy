package inheritance;

public class AbstractEx02 {
	public static void main(String[] args) {
		Shape ref = new Circle(); //pa-cha 케이스
		ref.draw();
	}
}

abstract class Shape{
	public abstract void draw(); //추상 메소드
}

class Circle extends Shape{
	public void draw() {
		System.out.println("원을 그리다.");
	}
}
