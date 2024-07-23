package innerex;

class Outer { // &100, static을 제외한 Outer 클래스를 인스턴스해 &100에 저장
	int data = 0;
	static int data1 = 50;

	void myMethod() {
		System.out.println("Outer 클래스의 메소드 data : " + data);
	}

	// 내부클래스 1 - 멤버 이너 클래스
	class InstanceInner {
		int iv = 100;

		void myMethod() {
			System.out.println("InstanceInner 클래스의 메소드 data : " + data + ", iv : " + iv);
		}
	}

	// 내부클래스 2 - 정적 클래스
	static class StaticInner {
		// 내부클래스에 static이 붙은 경우, 기본생성자가 StaticInner(){}가 아닌 Outer.StaticInner(){}임
		int iv = 200;
		static int cv = 300;

		void myMethod() {
			System.out.println("StaticInner 클래스의 메소드 data1 : " + data1);
//			System.out.println("StaticInner 클래스의 메소드 data : " + data); // 에러
//			클래스 외부 데이터인 경우는 static만 올 수 있다.
			System.out.println("StaticInner 클래스의 iv : " + iv + ", cv : " + cv);
		}
	}
}

public class InnerEx01 {

	public static void main(String[] args) {
		Outer outer = new Outer(); // &100 
		
		//내부클래스 객체 생성
		Outer.InstanceInner instanceInner = outer.new InstanceInner(); // 객체 내부의 InstanceInner() 기본생성자 호출문
		System.out.println("instanceInner.iv : " + instanceInner.iv);
		System.out.println();
		
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		Outer.StaticInner.cv = 50; // static 선언으로 인해 인스턴스된 것이 아닌 공유공간임. 따라서 원본이 수정된다.
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
		
		Outer.StaticInner staticInner = new Outer.StaticInner();
		System.out.println("staticInner.iv : " + staticInner.iv);
		System.out.println("staticInner.cv : " + staticInner.cv); // 46번줄로 인해 300이 아닌 50 출력
		System.out.println();
		
		outer.myMethod(); // %100 내 myMethod() 호출
		instanceInner.myMethod(); // &200 내 myMethod() 호출
		staticInner.myMethod(); // &300 내 myMethod() 호출
		
		staticInner.iv = 50;
		System.out.println("staticInner.iv : " + staticInner.iv); // static 선언으로 인해 원본 변경 가능. 따라서 50 출력
		
	}

}
