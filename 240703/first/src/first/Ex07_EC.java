package first;

public class Ex07_EC {
	public static void main (String[] args) {
		String str = new String("하하하"); //정식형식. 클래스(String)로 값을 그대로 받는 단축 형식: String str = "하하하";
		Ex07 e = new Ex07(); // 클래스는 자료형이 됨. e: 클래스 복제본=(인스턴스)객체. (주소값을 가지므로 객체) new: 주소할당/공간할당 + new 뒤에 붙은 자료형(클래스)을 복사함.
		//Ex07 e = null; Ex07은 클래스이므로 null값 가질 수 있음.
		System.out.println(e); // e의 주소값 출력 // 클래스.객체명+주소값 (e는 객체이므로) 
		System.out.println(e.name); // Ex07클래스 내 전역변수 name을 가리킴. name 내 값이 없으므로 기본값인 null을 가짐
		e.setName("김정혜"); //Ex07 클래스 내 주소값(Ex07 클래스 내용) 안에 setName 메서드 호출. "김정혜"라는 String자료형의 변수를 넘김. name변수가 "김정혜"값 저장.
		System.out.println(e.name); // name변수 내 저장된 "김정혜" 값 호출.
		
		e.age = 55; // Ex07 클래스 내 주소값(Ex07 클래스 내용) 안에 age변수에 int형 55를 저장
		System.out.println(e.age);
	}

}
