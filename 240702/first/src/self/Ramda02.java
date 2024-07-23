package self;

interface Test {
	void getNum(int num1, int num2);
}

public class Ramda02 {
	public static void main(String[] args) {
		Test lamda = (i, j) -> {
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
		
		lamda.getNum(10, 20);
		
	}

}
