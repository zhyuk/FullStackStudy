package innerex;

interface AnnonyEx04Abstract {
	String s = "상수"; // public static final 생략. 
	void doSomething(); // public abstract 생략.
	void etcMethod();
}

public class AnnonyEx04Test {

	public static void main(String[] args) {
		int aa = 5;
		final int AA = 7;
		
		AnnonyEx04Abstract myClass = new AnnonyEx04Abstract() {
			private int a = 15;
			String s = "AnnonymousClass";
			
			@Override
			public void doSomething() {
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
		}; // 객체 생성문 종료
		
		myClass.doSomething();
		myClass.etcMethod();
		System.out.println("aa : " + aa);
		System.out.println(myClass.s);

	}

}
