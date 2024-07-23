package interfaceex;

interface PaTest {
	String KIND = "사람";
	void trueKind();
	void falseKind();
}

public class Test implements PaTest{
	private String name;
	private int age;
	
	public Test() {}
	
	public Test(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void trueKind() {
		System.out.println(KIND + "입니다.");
	}
	
	public void falseKind() {
		System.out.println(KIND + "이 아닙니다");
	}
}