package second;

public class PersonEx {

	public static void main(String[] args) {
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);
		
		Person p = noName.returnItSelf();
		System.out.println(p);
		System.out.println(noName);
	}
}

class Person {
	String name; // null
	int age; // 0

	// 기본생성자를 호출한다.
	Person() {
		// Person 생성자 중 매개변수 2개이고, String형과 int형을 가진 생성자를 호출한다.
		this("이름 없음", 1);
	}

	// 매개변수가 2개이고, String형, int형을 가진 Person 생성자를 호출한다.
	Person(String name, int age) {
		// Person 클래스 내 name에 매개변수 name을 저장한다.
		this.name = name;
		// Person 클래스 내 age에 매개변수 age를 저장한다.
		this.age = age;
	}

	// Person 자료형을 반환해주는 메소드 선언문
	Person returnItSelf() {
		return this;
	}
}

