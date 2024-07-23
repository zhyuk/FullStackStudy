package third;

public class BoxEx {
	
	public static void main(String[] args) {
		// 객체생성문 : Box 자료형 box1~4 객체 생성 및 각각 공간에 주소값 복사
		Box box1 = new Box();
		Box box2 = new Box();
		Box box3 = new Box();
		Box box4 = new Box();
		
		System.out.println("box1의 idNum : " + box1.idNum);
		System.out.println("box2의 idNum : " + box2.idNum);
		System.out.println("box3의 idNum : " + box3.idNum);
		System.out.println("box4의 idNum : " + box4.idNum);
		// boxID에 static 기타제어자가 붙었기 때문에 클래스명.변수명으로 접근 가능
		System.out.println("박스 총 개수 : " + Box.boxID);
	}

}

class Box {
	// idNum이라는 long 자료형 전역변수 선언; 
	long idNum;
	// 기타제어자 static을 가진 boxID라는 long 자료형 전역변수 선언 및 초기값 0 할당;
	static long boxID = 0;
	
	// 기타 생성자
	public Box() {
		idNum = boxID++;
	}
	
	public String toString() {
		return "Box클래스로 만든 인스턴스를 받은 인스턴스 객체입니다.";
	}
}
