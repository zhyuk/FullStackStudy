package third;

public class Counter {
	int b = 5;
	static int count = 0;
	
	// 생성자는 기타제어자 사용 불가.
	Counter(){
		this.count++;
	}
	
	public void md() {
		System.out.println(b);
		System.out.println(count);
	}
	
	public static void md1() {
		System.out.println(count);
	}
	
	public static int getCount() {
		// static 메소드 선언문 내에는 static 멤버변수만 사용할 수 있다.
//		System.out.println(b);
		final int c =5;
		// 변수 c는 지역변수이기 때문에 static 없이도 가능.
		System.out.println(c);
		System.out.println(count);
		// static 메소드 선언문 내에는 static 메소드 선언문만 사용할 수 있다.
		md1();
		
		return count;
	}
}
