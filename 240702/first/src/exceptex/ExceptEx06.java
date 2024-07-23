package exceptex;

public class ExceptEx06 {

	public static void main(String[] args) {
		try {
			String c = null; // null 값을 받았기 때문에 메소드가 존재하지 않음
			System.out.println("문자열 값 : " + c.toString()); // 에러 출력
		} catch (Exception e) {

			System.out.println(" >> 예외처리 구문 << ");
			System.out.println(" >> e << ");
			System.out.println(e);

			System.out.println(" >> e.toString() << ");
			System.out.println(e.toString());

			// 발생한 예외 클래스의 인스턴스에 저장된 메시지 얻어오기
			System.out.println(" >> e.getMessage() <<");
			System.out.println(e.getMessage()); 

			// 예외 발생 당시의 호출 스택에 있는 메소드의 정보와 예외 메시지를 화면에 출력
			System.out.println(" >> e.printStackTrace() <<");
			e.printStackTrace();
		} finally {
			System.out.println("finally 처리");
		}
		System.out.println("완료");
		
	} // main 메소드 종료 중괄호

} // class 종료 중괄호
