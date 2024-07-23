package inheritance;

public class InhEx01 {

	public static void main(String[] args) {
		//Object클래스 상속을 통한 메소드 재정의
		Class c1 = String.class; //String.class는 .class 앞에 있는 클래스의 정보를 가져오란 뜻,java.lang 패키지를 쓸때만 import 생략 String, class에 대한 정보를 담는다.
		System.out.println(c1);
		System.out.println(c1.getClass()); //c1의 클래스 이름을 불러온다.
		
		c1 = String.class;
//		c1 = "하하하"; //
		String str1 = new String();
		System.out.println(str1.getClass());
		Class c2 = str1.getClass();
		System.out.println(c2);
		
	}

}
