package interfaceex;

public class CalcCha2 implements Calc{

	@Override
	public void add(int a, String s) {
		System.out.println("문자열 결합 연산시작");
		System.out.println(s + a);
	}

	@Override
	public void minus(int a) {
		System.out.println("뺄셈");
		System.out.println(10-a);
	}

	@Override
	public void multi(int a) {
		System.out.println("곱하기");
		System.out.println(7*a);
		
	}

	@Override
	public void divi(int a) {
		System.out.println("나누기 몫 구하기");
		System.out.println(50%a);
	}
}
