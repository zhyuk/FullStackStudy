package inheritance;

public class Super03 {

	public static void main(String args[]) {
		AA3 super1 = new AA3(); //&100//대표자료AA3(AA2, Object)//cha-cha 케이스
		System.out.println("10의 2제곱 : " + super1.d1); //출력4 100.0 
		System.out.println("10의 3제곱 : " + super1.d2); //출력5 1000.0
		System.out.println("10의 4제곱 : " + super1.d3); //출력6 10000.0
	}

}

class AA1 {
	double d1; //0.0//100.0
	AA1(){ //AA1의 기본 생성자
		System.out.println("AA1의 생성자"); //출력1
		d1 = 10 * 10;
	}
	AA1(double d1){ //AA1의 기타 생성자
		System.out.println("AA1의 생성자"); 
		this.d1 = d1;
	}
}

class AA2 extends AA1 {
	double d2; //0.0//1000.0
	AA2(){ //AA1의 기본 생성자
		super(); //AA1의 생성자 호출 //상속관계에서는 super()는 기본으로 숨겨져있다.
//		super(1000); //생성자호출문은 첫번째 줄만 사용가능해서 2개 사용이 불가능하다.
		System.out.println("AA2의 생성자"); //출력2
		d2 = 10 * 10 * 10;
	}
}

class AA3 extends AA2 {
	double d3; //0.0//10000.0
	AA3(){
		super(); //AA2의 생성자 호출 //상속관계에서는 super()는 기본으로 숨겨져있다.
		System.out.println("AA3의 생성자"); //출력3
		d3 = 10 * 10 * 10 * 10;
	}
}