package abstractex;

public class AbstractEx03 {

	public static void main(String[] args) {
		Shape1 ref = null;
		ref = new Circle1(); // &100 연결
		ref.area();
		ref.printArea();
		ref = new Rectangle(); // &100 연결해제, &200 연결
		ref.area();
		ref.printArea();

	}

}

abstract class Shape1 {
	public double res = 0;
	public abstract double area();
	public void printArea() {
		System.out.println("면적은 " + res);
	}
}

class Circle1 extends Shape1 {
	public int r = 5;
	
	public double area() {
		System.out.println("Circle1 area()메소드");
		res = r * r * Math.PI; // java.lang 패키지 내 Math 클래스 내 PI 상수 사용.
		return res;
	}
}

class Rectangle extends Shape1 {
	public int w = 10, h = 10;
	
	public double area() {
		System.out.println("Rectangle area()메소드");
		res = w * h;
		return res;
	}
}