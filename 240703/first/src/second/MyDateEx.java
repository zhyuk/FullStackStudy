package second;

public class MyDateEx {
	
	public static void main(String[] args) {
		
		// 객체 md, md1
		MyDate md = new MyDate(32, 5, 2024);
		MyDate md1 = new MyDate(32, 5, 2024);
		MyDate md2 = md;
		
		// 접근제어자를 private 사용했기 때문에 MyDate 내부에서만 접근 가능
//		md.y = 50; // 에러
		
//		md.isValid();
//		md.getMyDate();
//		System.out.println(md.getMyDate());
		
		// 변수 a, b, c
		int a = 5; // 대입연산자
		int b = 5;
		int c = 15;
		System.out.println(a == b);
		// 객체는 값이 아닌 주소값을 갖고있기 때문에 서로 같지 않다.
		System.out.println(md == md1);
		// md와 md2의 주소값이 같니? => T, md2에 새로운 주소값을 할당한 것이 아니라 md의 주소값을 복사했기 때문
		System.out.println(md == md2);
	}
}
