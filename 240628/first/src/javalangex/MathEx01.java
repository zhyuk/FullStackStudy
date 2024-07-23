package javalangex;

public class MathEx01 {

	public static void main(String[] args) {
		System.out.println("0번: " + ((int)(Math.random() * 6) + 1)); // 1 ~ 6 사이 정수
		System.out.println("1번: " + ((int)(Math.random() * 6) + 3)); // 3 ~ 8 사이 정수
		System.out.println();
		
		System.out.println(Math.abs(10));
		System.out.println(Math.abs(-10));
		System.out.println(Math.abs(-3.14));
		System.out.println();
		
		System.out.println("무조건 올림처리 ceil : " + Math.ceil(10.12));
		System.out.println("무조건 내림 처리 floor: " + Math.floor(10.92));
		System.out.println("반올림 처리 rint: " + Math.rint(10.51));
		System.out.println("PI(원주율)의 값: " + Math.PI);
		System.out.println();
		
		System.out.println("10, 20 중에 큰 값 : " + Math.max(10, 20));
		System.out.println("10, 20 중에 작은 값 : " + Math.min(10, 20));
		
		
		}
	}


