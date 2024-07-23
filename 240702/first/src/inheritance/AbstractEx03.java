package inheritance;

public class AbstractEx03 {
	public static void main(String[] args) {
		Shape1 ref = null;
		ref = new Circle1(); //&100, pa-cha(ref가 Shape 1로 부모 클래스고, Circle1이 자식 클래스임)
		System.out.println(ref.res);
		ref.area(); //Circle1 area()메소드, 25PI
		ref.printArea(); //면적은 25PI
		ref = new Rectangle(); //&200, pa-cha
		ref.area(); //Rectangle are()메소드, 100
		ref.printArea(); //면적은 100  
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
		res = r * r * Math.PI;
		return res;
	}
}

class Rectangle extends Shape1 {
	public int w = 10, h = 10;
	
	public double area() {
		System.out.println("Rectangle are()메소드");
		res = w * h;
		return res;
	}
}