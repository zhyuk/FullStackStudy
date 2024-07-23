package inheritance;

public class InhEx06 {
	public static void main(String[] args) {
		C2.x = "static제어자의 상속";
		
		C2.y = 20000;
		C1.x = 30000;
		System.out.println("C2.x : " + C2.x);//static제어자의 상속
		System.out.println("C2.y : " + C2.y);//20000 
		System.out.println("C1.x : " + C1.x);//30000
		
		C1 c1 = new C1();//&100(전부 static이라 할당만되고 비었음)//대표자료:C1(Object)// 
		C2 c2 = new C2();//&200(전부 static이라 할당만되고 비었음)//대표자료:C2(C1, Object)//cha-cha 케이스
		c1.setY(6);
		System.out.println("c1.y : " + c1.y); //6
		System.out.println("c2.y : " + c2.y); //20000
		
		c2.setY(100);
		System.out.println("c1.y : " + c1.y); //6
		System.out.println("c2.y : " + c2.y); //100
		
		c2.setC(90);
		System.out.println("c2.c : " + c2.c); //90
	}
}

class C1 {
	static int x; //30000
	static int y; //6 
	static int c; //90
	
	static void setX(int new_x) {
		System.out.println("C1의 setX메소드 실행");
		C1.x = new_x;
//		this.x = x; //static은 인스턴스 객체가 아니라 공유영역이기때문에 this.을 사용할 수 없다. this는 복제된 객체만 인식한다.
	}
	static void setY(int new_y) {
		System.out.println("C1의 setY메소드 실행");
		C1.y = new_y;
	}
	static void setC(int new_c) {
		System.out.println("C1의 setC메소드 실행");
		C1.c = new_c;
	}
}	
	
class C2 extends C1 {
	static String x;//"static제어자의 상속"
	static int y; //20000 //100
	static void setX(String new_x) {
		System.out.println("C2의 setX메소드 실행");
		C2.x = new_x;
//		this.x = x;
//		super.setX(1); 
	}
	static void setY(int new_y) {
		System.out.println("C2의 setY메소드 실행");
		C2.y = new_y;
	}
}	
	
	
