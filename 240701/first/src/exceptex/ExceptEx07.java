package exceptex;

public class ExceptEx07 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main 에서 예외 처리");
			System.out.println(e.getMessage());
		}
		System.out.println("종료");
	}

	static void method1() throws Exception { // Exception 클래스를 던짐
		System.out.println("예외발생시키기");
		throw new Exception("예외 고의로 발생"); // 예외를 고의로 발생시킴
	}

//	static void method1() {
//		System.out.println("예외발생시키기");
//		try {
//			throw new Exception("예외 고의발생"); // 예외를 고의로 발생시킴
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

}
