package inheritance;

public class CastingTest01 {
	public static void main(String[] args) {
		// 레퍼런스 student를 이용하면 name, dept에 접근 가능
		Student student = new Student("Duly");
		System.out.println(student.name);

		// Student 객체의 멤버 중 오직 Person 클래스의 멤버만 접근이 가능
		Person person = student;
		person.name = "Cogildong";
		System.out.println(person.name);
	} // 메인메소드 종료

} // CastingTest01 클래스 종료

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}
} // Person 클래스 종료

class Student extends Person {
	String dept;

	public Student(String name) {
		super(name); // 부모의 기타생성자 호출문, 이것이 지워지더라도 부모의 기본생성자 호출문이 생략되어있진 않다. -> 부모에 기타생성자가 있기 때문에 생략된 기본생성자 없음
	}
} // Student 클래스 종료
