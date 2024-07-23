package third;

public class StringEx01 {

	public static void main(String[] args) {
		//equals() : 객체의 값 비교
//		Integer i = new Integer(7);
//		Integer e = 7;
//		System.out.println("i : " + i + ", e : " + e);
//		System.out.println("객체비교 => i == e : " + (i == e));
//		System.out.println("값 비교 => i.equals(e) : " + (i.equals(e)));
//		
//		System.out.println("실제 해시코드값 : " + System.identityHashCode(i));
//		System.out.println("실제 해시코드값 : " + System.identityHashCode(e));
//		System.out.println("재정의된 해시코드값 : " + i.hashCode());
//		System.out.println("재정의된 해시코드값 : " + e.hashCode());
//		System.out.println("\n==========================\n");
//		
//		String s = new String("한글");
//		String t = "한글";
//		System.out.println("s: " + s + ", t : " + t);
//		System.out.println("객체비교 => s == t : " + (s == t));
//		System.out.println("값 비교 => s.equals(t) : " + (s.equals(t)));
//		
//		System.out.println("실제 해시코드값 : " + System.identityHashCode(s));
//		System.out.println("실제 해시코드값 : " + System.identityHashCode(t));
//		System.out.println("재정의된 해시코드값 : " + s.hashCode());
//		System.out.println("재정의된 해시코드값 : " + t.hashCode());
		
//		Box b = new Box();
//		System.out.println(b); // Box 클래스 내 toString()을 실행하지 않았으나 자동 호출된다.
//		
//		// 문자열 인덱스 indexOf
//		String a = "Good Afternoon!!";
//		System.out.println("1번. " + a.indexOf("noon"));
//		System.out.println("2번. " + a.indexOf(" Af"));
//		
//		String hello = "HelloWorld_MyWorld";
//		// indexOf(문자열) : 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환함.
//		System.out.println("3번. " + hello.indexOf("World"));
//		// indexOf(문자열,인덱스번호) : 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환하는 것은 동일함
//		// 단, 인덱스번호를 시작지점으로 인식하여, 그 기점부터 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환함.
//		System.out.println("4번. " + hello.indexOf("World", 10));
//		// lastIndexOf(문자열) : 해당 문자열의 맨 앞글자를 오른쪽에서 부터 찾아서 해당 인덱스를 왼쪽에서부터 세어 반환함.
//		System.out.println("5번. " + hello.lastIndexOf("World"));
//		// lastIndexOf(문자열, 인덱스번호) : 해당 문자열의 맨 앞글자를 오른쪽에서 부터 찾는것은 동일함.
//		// 단, 인덱스 번호를 앞에서부터 세어 그 지점에서 끝지점으로 인식하여,
//		// 그 지점부터 오른쪽에서 왼쪽으로 해당 문자열의 맨 앞글자를 찾아서 해당 인덱스르 앞에서부터 세어 반환함.
//		System.out.println("6번. " + hello.lastIndexOf("World", 13));
//		
//		hello = "AaBbCc"; // 아스키코드 값으로 인덱스 찾기
//		// indexOf(아스키코드값): 아스키코드 값에 해당하는 문자를 찾아 인덱스를 반환함.
//		System.out.println("7번. " + hello.indexOf(65));
//		System.out.println("8번. " + hello.indexOf(99));
		
		// contains : 문자열 포함 여부
//		String str = "my java test";
//		
//		System.out.println(str.contains("java")); // true
//		System.out.println(str.contains(" my")); // false
//		System.out.println(str.contains("JAVA")); // false
//		System.out.println(str.contains("java test")); // true
		
		// 문자열 치환 : replace, replaceAll(정규표현식 사용가능)
//		String b = "Welcome to Java World ";
//		System.out.println(b.replace("Java", "Computer"));
//		System.out.println(b.replaceAll("Java", "Computer"));
		
//		String str = "abcdefghijk";
//		System.out.println(str);
//		System.out.println("result => " + str.replaceAll("[abchij]", "굿"));
//		System.out.println("result => " + str.replaceAll("[^abchij]", "굿")); 
//		System.out.println(str);
		// String에서 제공하는 메소드는 원본을 훼손하지 않는다.
		// 따라서 원본을 굿굿굿defg굿굿굿k로 바꾸고싶다면, 
		// str = str.replaceAll("[abchij]", "굿"); 처럼 원본에 다시 대입해줘야한다.
		
		// 체이닝 기법과 아래의 주석과 결과는 같아 때로는 체이닝 기법이 번거롭다. 상황에 따라 다르게 사용하기
//		System.out.println("result => " + str.replace("a", "굿").replace("b", "굿").replace("c", "굿").replace("h", "굿").replace("i", "굿").replace("j", "굿"));
//		System.out.println("result => " + str.replaceAll("[abchij]", "굿"));
//		System.out.println("result => " + str.replace("abc", "굿~").replace("hij", "럭키~"));
		
		// 문자열 추출 : substring(0, 4) (시작 인덱스번호) ~ (해당 인덱스번호 -1 ) 까지
//		String a = "Welcome to Java World";
//		System.out.println(a.substring(0,4)); // 0 ~ 3(4-1)까지
//		System.out.println(a.substring(4)); // 4 ~ 끝까지
//		System.out.println(a.substring(1,8)); // 1 ~ 7(8-1)까지
		
		// 주민등록번호를 담아둘 num 객체 생성;
//		String num = "010210-3456789";
		// num 객체의 8번째 글자까지(인덱스번호 7까지) 추출하고 그 뒤에 * 표시 결합해 출력
//		System.out.println(num.substring(0,8) + "******"); // 1 ~ 7(8-1)까지
		
		// 비밀번호 4글자만 보이고 나머지 4글자는 * 표시로 만드는 코드
//		String password = "abcdefgh";
//		String ast = "";
		
		// 변수 i의 초기값을 4로 설정; 변수 i가 password 객체의 길이보다 작을 동안; 변수 i에 1씩 증감
		// 변수 i의 초기값이 4인 이유 : 5번째부터 *표시를 해야하는데, 5번째의 인덱스번호는 4임. 
//		for (int i = 4; i < password.length(); i++) {
//			// 비밀번호를 담아둘 객체 ast에 ast + "*" 값을 저장
//			ast += "*"; // ast = ast + "*";
//		}
//		
//		// password 객체의 인덱스번호 3번까지 추출하고 그 뒤에 ast 객체를 결합해 출력
//		System.out.println(password.substring(0,4) + ast);
		
		// 대소문자 변경 : toUpperCase(), toLowerCase() : 영어만 가능.
//		String a = "Welcome to Java World ";
//		System.out.println("모두 대문자로: " + a.toUpperCase());
//		System.out.println("모두 소문자로: " + a.toLowerCase());
		
//		String id = "HIMEDIA";
//		
//		// 객체의 값 비교는 .equals 사용
//		// id의 값을 모두 소문자로 변경, 이후 "himedia"와 id의 값을 비교.
//		if(id.toLowerCase().equals("himedia")) {
//			System.out.println("회원입니다.");
//		} else {
//			System.out.println("회원이 아닙니다.");
//		}
		
		// 공백 제거 : trim()
//		String str4 = "   공백  제거    공백  제거    ";
//		System.out.println("[" + str4 + "]");
//		System.out.println("[" + str4.trim() + "]");
//		System.out.println("[" + str4.replace(" ", "") + "]");
		
//		String s = "abCDEfgHi jkLmnOP";
//		System.out.println(s.indexOf("Lmn")); // 정방향 기준으로 "Lmn"이 시작되는 인덱스번호를 출력
//		// s에는 "lmn"이 존재하지 않기 때문에 찾을 수 없음. 
//		//없다는 뜻은 0보다 적어야하기 때문에 -1로 출력됨. 
//		System.out.println(s.indexOf("lmn"));
//		
//		// 객체 s를 모두 소문자로 변경 후 s1에 저장
//		String s1 = s.toLowerCase();
//		System.out.println(s1.indexOf("lmn"));
		
		// concat : 문자열 뒤로 추가
//		String str = new String("Java");
//		System.out.println("원본 문자열 : " + str);
//		
//		System.out.println(str.concat("수업")); 
//		System.out.println(str.concat("수업").concat("시간")); // 수업 뒤에 더 붙이고 싶으면 체이닝 기법으로 추가 가능.
//		System.out.println("concat() 메소드 호출 후 원본 문자열 : " + str); // String은 원본 훼손을 하지않기 때문에 유지.
		
		// 클래스명.객체명.메소드명;
		// 객체가 static으로 선언됐기 때문에 실행됨. 
//		InsObj.ins.insmd();
		
		String str = new String("abcd");
		System.out.println("원본 문자열 : " + str);
		System.out.println("0-1번. 문자열 개수 비교 : " + str.length() + "개 - 2개 : " + str.compareTo("ab"));
		System.out.println("0-2번. 아스키코드 차 : " + (int)'a' + " - " + (int)'b' + " : " + str.compareTo("bc"));
		System.out.println("1번. 아스키코드 차 : " + (int)'a' + " - " + (int)'b' + " : " + str.compareTo("bcef"));
		System.out.println("2-1번. 문자열개수비교 : " + str.compareTo("abcde"));
		System.out.println("2-2번. 아스키코드 차 : " + (int)'a' + " , " + (int)'u' + " , " + str.compareTo("uvwxyz"));
		
		System.out.println("3번. " + str.compareTo("abcd"));
		System.out.println("4번. " + str.compareTo("adef"));
		System.out.println("5번. " + str.compareTo("Abcd"));
		
		System.out.println("6-1번. " + str.compareToIgnoreCase("Abcd"));
		System.out.println("6-2번. " + str.compareToIgnoreCase("ACd"));
		System.out.println("compareTo() 메소드 호출 후 원본 문자열 : " + str);
		System.out.println("\n=========================\n");
		
		// 숫자 비교 : 값을 int로 반환. 크다(1), 같다(0), 작다(-1)
		Integer x = 3;
		Integer y = 4;
		Double z = 1.0;
		
		System.out.println("7번. x < y 의미 : " + x.compareTo(y));
		System.out.println("8번. x == 3 의미 : " + x.compareTo(3));
		System.out.println("9번. x > 2 의미 : " + x.compareTo(2));
		System.out.println("10번. z < 2.7 의미 : " + z.compareTo(2.7));
		
		
	}
}

class Ins {
	public void insmd() {
		System.out.println("Ins의 insmd() 실행");
	}
}

class InsObj {
	static Ins ins = new Ins();
}
