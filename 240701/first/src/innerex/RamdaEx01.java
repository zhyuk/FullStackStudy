package innerex;

interface Ramda01 {
	int getMax(int num1, int num2);
//	int add(int num1, int num2);
}

public class RamdaEx01 {

	public static void main(String[] args) {
		
		Ramda01 max = (num1, num2) -> {
			System.out.println("람다식 실행");
			return 5;
		};
	
		
		// 람다식을 인터페이스형 max 변수에 대입
		max = (x, y) -> (x >= y) ? x : y;
		int r = max.getMax(10, 20);
		System.out.println(r);
		
		max = (x, y) -> x * y;
		r = max.getMax(10, 20);
		System.out.println(r);

		// 람다식은 아래의 코드를 위의 코드 한줄로 축약시킬 수 있음
//		Ramda01 max = new Ramda01() {
//			public int getMax(int x, int y) {
//				return (x >= y) ? x : y;
//			}
//		};

		r = max.getMax(10, 20);
		// 인터페이스형 변수로 메소드 호출
		System.out.println(r);

	}

}
