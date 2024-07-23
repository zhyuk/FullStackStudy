package third;

public class OneEx {
	
	public static void main(String[] args) {
		
		One t1 = new One();
		System.out.println("t1의 주소값 : " + System.identityHashCode(t1));
		System.out.println("기본 값 : " + t1.value);
	}
}

class One {
	int value;
	
	public One() {
		this(100); //다른 생성자를 호출
		this.value = 5;
		System.out.println("디폴트생성자");
	}
	
	public One(int value) {
		// 자신의 value 변수에 매개변수로 받은 값을 저장
		this.value = value;
		// 클래스 메소드를 호출. 매개변수로 자신의 객체를 전달
		Another.methodA(this);
	}
}

class Another {
	static void methodA(One ins) {
		System.out.println("메소드 A에서의 값 : " + ins.value);
		System.out.println("ins의 주소값 : " + System.identityHashCode(ins));
	}
}