package inheritance;

public class Super03 {

	public static void main(String[] args) {
		AA3 super1 = new AA3();
		System.out.println("10의 2제곱 : " + super1.d1);
		System.out.println("10의 3제곱 : " + super1.d2);
		System.out.println("10의 4제곱 : " + super1.d3);
	}
}

class AA1 {
	double d1; // 0.0 -> 18번째 줄에 의해 100.0으로 변경됨

	AA1() { // AA3 super1 = new AA3();에 의해 실행됨.
		System.out.println("AA1의 생성자");
		d1 = 10 * 10;
	}
	
	AA1(double d1){
		System.out.println("AA1의 기타 생성자");
		this.d1 = d1;
	}
}

class AA2 extends AA1 {
	double d2; // 0.0 -> 28번째 줄에 의해 1000.0으로 변경됨.

	AA2() {
		super(); // 부모인 AA1 클래스 복제본을 의미, = AA1() 호출
		System.out.println("AA2의 생성자");
		d2 = 10 * 10 * 10;
	}
	
	AA2 (double d2) {
		System.out.println("AA2의 기타 생성자");
		this.d2 = d2;
	}
}

class AA3 extends AA2 {
	double d3; // 0.0 -> 38번째 줄에 의해 10000.0으로 변경됨.

	AA3() {
//		super(); // 부모인 AA2 클래스 복제본을 의미, = AA2() 호출
		super(500);
		System.out.println("AA3의 생성자");
		d3 = 10 * 10 * 10 * 10;
	}
}
