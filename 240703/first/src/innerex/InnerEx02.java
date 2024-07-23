package innerex;

public class InnerEx02 {

	private int data = 30;

	void display() {
		class Local { // 지역 이너클래스이므로 접근제어자 올 수 없음.
			public int b = 5;

			void msg() {
				System.out.println(data);
				display2();
			} // msg() 종료
		} // Local 클래스 종료

		Local l = new Local();
		l.msg();
		System.out.println(l.b);
	} // display() 종료

	class InstanceInner {
		int iv = 100;

		void myMethod() {
			display();
//			msg(); // 에러. 클래스가 지역 클래스기 때문에 외부 접근 불가
			System.out.println("InstanceInner 클래스의 메소드 data : " + data + ", iv : " + iv);
		} // myMethod() 종료
	} // InstanceInner 클래스 종료

//	static class StaticInner {}

	void display2() {
		System.out.println("display2() 메소드 호출");
	}

	public static void main(String[] args) {
		InnerEx02 obj = new InnerEx02();
		obj.display();
		InnerEx02.InstanceInner obj1 = obj.new InstanceInner();
//		InnerEx02.StaticInner obj2 = new InnerEx02.StaticInner(); 
		obj1.myMethod();
	}

}
