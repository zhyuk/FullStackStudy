package third;

public class Wrap03 {

	public static void main(String[] args) {
		// 기본 자료형에서 문자열 자료형으로 변환 (랩퍼클래스 이용)
		// int -> String
		int i = 50;
		String s = String.valueOf(i);
		s = Integer.toString(i); // 클래스명.toString(정수값 또는 기본 정수형 변수);
		
		// Integer -> String
		Integer w_i = 50;
		String w_s = String.valueOf(w_i);
		w_s = w_i.toString(); // 랩퍼클래스객체명.toString();
		
		// String -> int "반드시 정수값으로 변환 가능한 문자열값이어야만 함"
		i = Integer.parseInt(s);
		// String -> Integer "반드시 정수값으로 변환 가능한 문자열값이어야만 함"
		w_i = Integer.valueOf(w_s);
		System.out.println("\n=======================\n");
		
		// long -> String
		long l = 50l;
		s = String.valueOf(l);
		s = Long.toString(l); // 클래스명.toString(정수값 또는 기본정수형 변수);
		
		// Long -> String
		Long w_l = 50L;
		w_s = String.valueOf(w_l);
		w_s = w_i.toString(); // 랩퍼클래스객체명.toString();
		
		// String -> long "반드시 정수값으로 변환 가능한 문자열값이어야만 함"
		l = Long.parseLong(s);
		// String -> Long "반드시 정수값으로 변환 가능한 문자열값이어야만 함"
		w_l = Long.valueOf(w_s);
		
		// float -> String
		float f = 50;
		s = String.valueOf(f);
		s = Float.toString(f); // 클래스명.toString(실수값 또는 기본정수형 변수);
		
		// Float -> String
		Float w_f = 50.25f;
		w_s = String.valueOf(w_f);
		w_s = w_f.toString(); // 랩퍼클래스객체명.toString();
		
		// String -> float "빈드시 실수값으로 변환 가능한 문자열값이어야만 함"
		f = Float.parseFloat(s);
		// String -> Float "반드시 실수값으로 변환 가능한 문자열값이어야만 함"
		w_f = Float.valueOf(w_s);
		System.out.println("\n======================\n");
		

	}

}
