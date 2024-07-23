package inheritance;

public class CastingTest01 {
	public static void main(String[] args) {
		//레퍼런스 student를 이용하면 name, dept에 접근 가능
		Student student = new Student("Duly");//cha-cha 케이스 모두 접근
		System.out.println(student.name); //Duly
		
		/*Student 객체의 멤버 중 오직 Person 클래스의 멤버만
		접근이 가능*/
		Person person = student; //pa-cha 케이스 자식클래스 접근 불가능
		person.name = "Cogildong";
		System.out.println(person.name); //Cogildong
	}
}

class Person {
	String name; //Duly //Cogildong
	
	public Person(String name) {
		this.name = name; //Duly
	}
}

class Student extends Person{
	String dept;
	
	public Student(String name) { //부모의 기타생성자 호출문
		super(name);
	}
}