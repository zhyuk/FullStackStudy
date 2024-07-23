package self;

interface Ramda01 {
	void get(int num1, int num2);
}

public class Ramda {

	public static void main(String[] args) {
		Ramda01 lamda1 = (i, j) -> System.out.println("람다식 실행");
		
		lamda1 = (i, j) -> {
			int sum = i + j;
			System.out.println("덧셈 : " + sum);
			
			sum = i - j;
			System.out.println("뺄셈 : " + sum);
			
			sum = i * j;
			System.out.println("곱셈 : " + sum);
			
			sum = i / j;
			System.out.println("나눗셈 : " + sum);
			
			sum = i % j;
			System.out.println("나머지 : " + sum);
		};
		
		lamda1.get(10, 20);
		
	}

}
