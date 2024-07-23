package abstractex;

public class AbstractEx01 {

	public static void main(String[] args) {
		// Animal a = new Animal(); // 추상 클래스는 인스턴스를 생성할 수 없음.
		Cat c = new Cat();
		Dog d = new Dog();
		
		c.cry();
		d.cry();
		System.out.println(c.getAstr());
	}
}

//추상클래스 Animal
abstract class Animal {
	private String astr =  "추상클래스";
	abstract void cry(); //추상메소드 선언문
	public String getAstr() {
		return astr;
	}
}

// Cat 클래스
class Cat extends Animal {
	public void cry() {
		System.out.println("냐옹냐옹!");
	}
}

// Dog 클래스
class Dog extends Animal {
	public void cry() {
		System.out.println("멍멍!");
	}
}