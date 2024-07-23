package interfaceex;

public class CalcCha1 implements Calc{

	@Override
	public void add(int a, String s) {
		System.out.println(s + "연산시작");
		System.out.println(a + a);
	}

	@Override
	public void minus(int a) {
		System.out.println("마이너스");
		System.out.println(-a);
	}

	@Override
	public void multi(int a) {
		System.out.println("곱하기");
		System.out.println(a*a);
		
	}

	@Override
	public void divi(int a) {
		System.out.println("나누기 몫 구하기");
		System.out.println(50/a);
	}
}
