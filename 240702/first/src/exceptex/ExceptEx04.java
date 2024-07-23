package exceptex;

public class ExceptEx04 {

	public static void main(String[] args) {
		try {
//			해보기 :
//			매개인자 1개 입력하고 실행하기 : 숫자로
//			매개인자 2개 입력하고 실행하기 : 숫자로, 젯수 0으로 입력하기
//			매개인자 String으로 입력하고 실행하기

			System.out.println("매개변수로 받은 두 개의 값");
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);

			System.out.println(" a = " + a + " b =  " + b);
			System.out.println(" a를 b로 나눈 몫 = " + (a / b));
			System.out.println("나눗셈 수행");

		} catch (ArithmeticException e) {

			System.out.println("==========================");
			System.out.println("ArithmeticException 처리 루틴 : "); // 산술 연산 오류 처리
			System.out.println(e + " 예외 발생");

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("==========================");
			System.out.println("ArrayIndexOutOfBoundsException 처리 루틴 : "); // 배열 범위 오류 처리
			System.out.println(e + " 예외 발생");

		} catch (NumberFormatException e) {

			System.out.println("==========================");
			System.out.println("NumberFormatException 처리 루틴 : "); // 숫자 형식 오류 처리
			System.out.println(e + " 예외 발생");

		} catch (Exception e) { // Exception을 예외 처리의 최고 조상이다. 따라서 모든 오류를 포함하고 있기 때문에 가장 먼저 적으면 모든지 해당 오류를 출력한다.

			System.out.println("Exception 처리 루틴 : "); // 최상위 에러(모든 에러) 처리
		} finally {

			System.out.println("==========================");
			System.out.println("finally 블럭 수행");
		} // finally 종료 중괄호

	} // main 메소드 종료 중괄호

} // class 종료 중괄호
