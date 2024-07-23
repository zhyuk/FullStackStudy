package third;

public class Wrap02 {
	
	public static void main(String[] args) {
		int i = 50;
		double d = i; // 가능. 자동형변환
		
		Integer w_i = 50;
//		Double w_d = w_i; // 랩퍼클래스의 경우 불가능. 같은 숫자형일지라도 변환불가
//		Double w_d = (double) i; // 기본 자료형은 int를 강제형변환으로 double로 변환 후 객체에 넣을 수 있음.
		Double w_d = (double) w_i; // 가능. double타입 기본 자료형으로 변환 후 객체에 넣을 수 있음.
//		Double w_d = (Double) w_i; // 불가능. 랩퍼클래스끼리 업캐스팅 불가함.
		String str = String.valueOf(i); // 변수 i의 값을 String 객체에 저장
		
//		char c = '가';
//		str = String.valueOf(c); // 객체 str이므로 메소드를 통해 변환만 가능.
//		boolean b = true;
//		str = String.valueOf(b); // 객체 str이므로 메소드를 통해 변환만 가능.
		
		Character c = '가';
		str = String.valueOf(c); // 객체 str이므로 메소드를 통해 변환만 가능.
		System.out.println(str);
		Boolean b = true;
		str = String.valueOf(b);
		System.out.println(str);
		
		String s = "true";
		boolean b1 = Boolean.parseBoolean(s);
		System.out.println(b1);
		
		// 한 글자를 String 문자형으로 떼오는 방법은 이것뿐
		for (int x = 0; x < s.length(); x++) {
			char c1 = s.charAt(x);
			System.out.println(c1);

		}
		
	}
}
