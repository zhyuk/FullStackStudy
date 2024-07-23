package first;

public class Ex05 {
	public static double area(int a, double b, String c) {
		double result = 0;
		
		switch(c) {
		case "try" : result = a * b / 2 ; break;
		default : result = a * a * b;		
		} 
		
		return result;
	}
	
	public static void main(String[] args) {
		//삼각형 면적 구하는 공식 : 가로 * 세로 /2
		System.out.printf("삼각형의 면적은 %.2f 입니다. %n", area(5, 9, "try"));
		
		//원의 면적 구하는 공식 : 반지름 * 반지름 * 3.14
		System.out.printf("원의 면적은 %.2f 입니다. %n", area(5, 3.14, "cir"));
		
		
	}
}
