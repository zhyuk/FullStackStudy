package collectionex;

import java.util.ArrayList;
import java.util.Iterator;


public class CollEx04 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));
		list.add(new Student("전우치", 2, 2));
		
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student s = it.next();
			System.out.println(s.name + " " + s.ban + "반 " + s.no + "번");
		}

	}

}
class Student {
	String name = "";
	int ban;
	int no;
	
	Student(){}
	
	Student(String name, int ban, int no){
		this.name = name;
		this.ban = ban;
		this.no = no;

}


	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}