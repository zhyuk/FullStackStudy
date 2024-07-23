package inheritance;

public class InhEx06 {

	public static void main(String[] args) {
		C2.x = "static제어자의 상속";

		C2.y = 20000;
		C1.x = 30000;
		System.out.println("c2.x : " + C2.x);
		System.out.println("c2.y : " + C2.y);
		System.out.println("c1.x : " + C1.x);

		C1 c1 = new C1();
		C2 c2 = new C2();
		c1.setY(6);
		System.out.println("c1.y : " + c1.y);
		System.out.println("c2.y : " + c2.y);

		c2.setY(100);
		System.out.println("c1.y : " + c1.y);
		System.out.println("c2.y : " + c2.y);

	}

}

class C1 {
	static int x;
	static int y;
	static int c;

	static void setX(int new_x) {
		System.out.println("C1의 setX메소드 실행");
		C1.x = new_x;
//		this.x = x; // static 공유공간에 존재하기 때문에 this 키워드를 사용할 수 없다.
	}

	static void setY(int new_y) {
		System.out.println("C1의 setY메소드 실행");
		C1.y = new_y;
	}

	static void setC(int new_c) {
		System.out.println("C1의 setC메소드 실행");
		C1.c = new_c;
	}
} // C1 클래스 종료

class C2 extends C1 {
	static String x;
	static int y;
	static void setX(String new_x) {
		System.out.println("C2의 setX메소드 실행");
		C2.x = new_x;
//		this.x = x;
//		super.setX(1);
	}
	
	static void setY(int new_y) {
		System.out.println("C2의 setY메소드 실행");
		C2.y = new_y;
//		C1.y = new_y; // C1 클래스 내 y의 값도 함께 변경하고 싶다면, 이 코드 작성하면 된다.
	}

}
