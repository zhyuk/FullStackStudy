package javalangex;

public class StringBufferEx00 {

	public static void main(String[] args) {
		String str = new String("Java");
		System.out.println("str 문자열 주소1: " + System.identityHashCode(str));
		
		str = str + " 수업";
		System.out.println("str 문자열 주소2: " + System.identityHashCode(str));
		
		str = str + " 시간";
		System.out.println("str 문자열 주소3: " + System.identityHashCode(str) + "\n");

		StringBuffer strb = new StringBuffer("");
//		strb = "가나다라마바사";  (x)
		System.out.println(strb);
		System.out.println("strb 문자열 주소1: " + System.identityHashCode(strb));
		System.out.println("길이1: " + strb.length());
		System.out.println("공간1: "+ strb.capacity() + "\n");
		
		strb = strb.append("Java 수업"); 
		System.out.println("strb 문자열 주소2: " + System.identityHashCode(strb));
		System.out.println(strb);
		System.out.println("길이2: " + strb.length());
		System.out.println("공간2: "+ strb.capacity() + "\n");
		
		strb = strb.append(" 수업 수업 수업"); 
		System.out.println("strb 문자열 주소3: " + System.identityHashCode(strb));
		System.out.println(strb);
		System.out.println("길이3: " + strb.length());
		System.out.println("공간3: "+ strb.capacity() + "\n");
		
		strb = strb.append(" 수업"); 
		System.out.println("strb 문자열 주소4: " + System.identityHashCode(strb));
		System.out.println(strb);
		System.out.println("길이4: " + strb.length());
		System.out.println("공간4: "+ strb.capacity() + "\n");
	}

}
