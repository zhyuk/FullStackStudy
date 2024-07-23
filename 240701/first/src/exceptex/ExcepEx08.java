package exceptex;

public class ExcepEx08 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		try {
			System.out.println("try문 시작");
			findClass();
			System.out.println("try문 종료");
		} catch (Exception e) { // throws로 던진 클래스보다 catch문에서 받을 클래스가 더 커야만 받을 수 있다.
			System.out.println("클래스가 존재하지 않습니다.");
			System.out.println("에러 사유 : " + e);
		}
		System.out.println("프로그램 종료");

	}

	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.WowClass");
	}
}
