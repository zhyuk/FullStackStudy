package third;

public class StringEx {

	public static void main(String[] args) {
//		char[] cArr = new char[5]; // 문자 배열
//		String sAr = "     "; // 문자열 : 문자 배열과 헷갈릴 수 있어 문자열이라고 부름
		
		// 문자열 길이 : length() 메소드
//		String s = null;
//		int str_l = s.length();
//		System.out.println(str_l);
		
		String str = "안녕하세요, 반갑습니다.";
		int str_length = str.length();
		System.out.println("\"" + str + "\"의 문자열 갯수(문자 길이)는" + str_length + "입니다.");
	}
}
