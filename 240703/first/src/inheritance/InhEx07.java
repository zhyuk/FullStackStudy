package inheritance;

public class InhEx07 {
	
	public static void main(String[] args) {
		Ch c = new Ch(); //&100//대표자료:Ch(Object)//cha-cha 케이스//class Ch extends Pa 때문에 상속이라 cha-cha 케이스를 쓴다.
		c.show("상속 오버로딩");//Pa클래스의 show(String str)에 접근한다.//상위클래스 메소드 show(String str) "상속 오버로딩" 출력
		c.show(7);//Ch클래스의 show(int i)에 접근한다.//하위클래스 메소드 show(int str) 7 출력 
		c.show();//Ch클래스의 show()에 접근한다.//하위클래스 메소드 show() 출력
		
		Pa p = new Ch(); //&200//대표자료:Pa(Ch, Object)//Pa-cha 케이스
		p.show();//Ch클래스의 show()에 접근한다.//하위클래스 메소드 show() 출력
		System.out.println(c.a);//Ch클래스의 String a에 접근한다.//하하하 출력
		System.out.println(p.a);//Pa클래스의 int a에 접근한다.//5 출력
	}
}

class Pa { //부모클래스
	int a = 5;
	void show() {
		System.out.println("상위클래스 메소드 show");
	}
	
	void show(String str) {
		System.out.println("상위클래스 메소드 show(String str) " + str);
	}
}

class Ch extends Pa { //Ch자식클래스 Pa부모클래스
	String a = "하하하";
	void show() {
		System.out.println("하위클래스 메소드 show()");
	}
	
	void show(int i) {
		System.out.println("하위클래스 메소드 show(int str) " + i);
	}
}
