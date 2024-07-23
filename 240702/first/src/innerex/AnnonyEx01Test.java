package innerex;

public class AnnonyEx01Test {

	public static void main(String[] args) {
		int aa = 5;
		final int AA = 7;
		
		AnnonyEx01Abstract myClass = new ASub() {
			private int a = 15;
			String s = "AnnonymousClass";
			final int AA = 0;
			
//			static final int AA = 0;
//			static int st = 0;
			
			@Override
			public void doSomething() {
//				aa = a + aa;
				super.doSomething(); // 익명클래스의 부모는 ASub 클래스임
				System.out.println("내부 익명 클래스의 doSomething 메소드");
				
				System.out.println("s : " + s);
				System.out.println("a : " + a);
				System.out.println("aa : " + aa);
				System.out.println("AA : " + AA);
				
				etcMethod();
			}
			
			public void etcMethod() {
				System.out.println("기본 메소드입니다.");
			}
		}; // 객체생성문 종료
		
		myClass.doSomething();
//		myClass.etcMethod();
//		aa = aa + 15;
		
		System.out.println("aa : " + aa);
		System.out.println(myClass.s); // Pa-Cha 케이스로 부모에 있는 것만 접근할 수 있다. 따라서 AnnonyEx01Abstract 클래스의 s 출력
		
	} // main메소드 종료

} // AnnonyEx01Test 클래스 종료

abstract class AnnonyEx01Abstract {
	public String s; // null
	public abstract void doSomething(); // 추상클래스. 자식클래스에서 반드시 오버라이딩해서 사용
}

class ASub extends AnnonyEx01Abstract {

	@Override
	public void doSomething() {
		System.out.println("ASub클래스 doSomething() 메소드 호출");
	}
}
