package javalangex;

public class StringBufferEx01 {

	public static void main(String[] args) {
		//delete() 메소드
		StringBuffer str = new StringBuffer("Java Oracle");
		System.out.println("원본 문자열 : " + str);
		System.out.println("길이0: " + str.length());
		
		//시작인덱스~ 인덱스-1번 까지
		System.out.println(str.delete(4, 8));
		System.out.println(str);
		System.out.println("길이1: " + str.length());
		
		//해당 인덱스 문자만제거
		System.out.println(str.deleteCharAt(1));
		System.out.println(str);
		System.out.println("길이2: " + str.length());
		
		//해당 인덱스 문자만 가져오기
		System.out.println(str.charAt(1));
		System.out.println(str);
		System.out.println("길이3: " + str.length());
		System.out.println("deleteCharAt() 메소드 호출 후 원본 문자열 : " + str);
		
		System.out.println(str.replace(0, 3, "12345"));
		}

}
