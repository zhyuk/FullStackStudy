package inheritance;

class Parent { }
class Child extends Parent { } // Child가 Parent를 상속받음
class Brother extends Parent { } // Brother가 Parent를 상속받음 

public class InhEx03 {

	public static void main(String[] args) {
		//다형성 : 한 객체가 여러개의 타입(자료형)을 갖을 수 있는 것
		Parent p = new Parent(); // Object, Parent 갖고 있다.
		System.out.println("1번. "+ (p instanceof Object) );
		System.out.println("2번. "+ (p instanceof Parent) );
		System.out.println("3번. "+ (p instanceof Child) );
		System.out.println();
		
		Parent c = new Child(); // Object, Parent, Child(Parent가 상속받음) 다 갖고 있다. // pa - cha 케이스
		System.out.println("4번. "+ (c instanceof Object) );
		System.out.println("5번. "+ (c instanceof Parent) );
		System.out.println("6번. "+ (c instanceof Child) );
		System.out.println("7번. "+ (c instanceof Brother) );
		
	}

}
