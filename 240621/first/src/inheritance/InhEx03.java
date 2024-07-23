package inheritance;

class Parent { } // 상속받은 부모 X
class Child extends Parent { } // Parent 부모 클래스 / Child 자식 클래스
class Brother extends Parent { } // Parent 부모 클래스 / Brother 자식 클래스

public class InhEx03 {
	
	public static void main(String[] args) {
		// 다형성 : 한 객체가 여러개의 타입(자료형)을 갖을 수 있는 것
		Parent p = new Parent(); // 대표자료형 : Parent, 자료형 : Object
		// A instanceof B : A 객체에 B 자료형이 있니?
		System.out.println("1번. " + (p instanceof Object)); // p에 Object 자료형 있음 -> T
		System.out.println("2번. " + (p instanceof Parent)); // p에 Parent 자료형 있음 -> T
		System.out.println("3번. " + (p instanceof Child)); // p에 Child 자료형 없음 -> F
		System.out.println();

		Parent c = new Child(); // 대표자료형 : Parent, 자료형 : Object, Child
		System.out.println("4번. " + (c instanceof Object)); // c에 Object 자료형 있음 -> T
		System.out.println("5번. " + (c instanceof Parent)); // c에 Parent 자료형 있음 -> T
		System.out.println("6번. " + (c instanceof Child)); // c에 Child 자료형 있음 -> T
		System.out.println("6번. " + (c instanceof Brother)); // c에 Brother 자료형 없음 -> F

	}

}
