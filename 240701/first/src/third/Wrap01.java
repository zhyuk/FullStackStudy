package third;

public class Wrap01 {

	public static void main(String[] args) {
//		String s = "50";
////		Integer i = s; // 해당 방식처럼 클래스 간 값 변경 불가능.
//		Integer i = Integer.parseInt(s); // 매개변수 s를 int형으로 변환하여 랩퍼클래스 i에 저장
//
//		int i2 = Integer.valueOf(s); // 기본 자료형에 Integer 형태로 받더라도 기본 자료형이기 때문에 Integer.메소드를 활용할 수 없다.
		
		Integer i = 50;
		String s = String.valueOf(i);
		s = i.toString();
		System.out.println(s);
		
		double d = 50.25;
		s = String.valueOf(d);
		System.out.println(s);
	}
}
