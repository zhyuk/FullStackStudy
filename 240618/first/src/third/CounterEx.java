package third;

public class CounterEx {

	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		
		// getCount() 메소드에 기타제어자 static이 붙어있다면 아래와 같이 "클래스명.메소드명"으로 접근가능.
		System.out.println(Counter.getCount());
		System.out.println(c1.getCount());
		System.out.println(c2.getCount());
	}
}
