package inheritance;

class Par {
	int p = 0;
}

class Cld extends Par {
	int c = 1;
}

class Bro extends Par {
	int b = 2;
}

public class InhEx04 {

	public static void main(String[] args) {
		Par pa01 = new Par();
		Cld ch = new Cld();
		Par pa02 = new Bro();
		Bro br = new Bro();
		
		pa01 = ch; // pa01 = (Par)ch; 와 같으며, 타입 변환을 생략할 수 있음. // 부모는 자식을 담을 수 있다. => 업캐스팅
		pa01.p = 2; // 접근 가능. 
//		pa01.c = 2; // Pa-Cha케이스로 변경됐기 때문에 자식 클래스에 있는 c는 외부에서 접근 불가. 
		ch.p = 5; // 접근가능. ch 클래스 내 모든 변수에 외부 접근 가능
		br.p = 5; // 접근가능.br 클래스 내 모든 변수에 외부 접근 가능 
//		pa02.b = 6;  // 접근 불가. Par pa02 = new Bro(); 이기 때문에 Par 클래스 내에 있는 변수만 외부 접근 가능.
		// 타입 변환을 생략할 수 없음. 
		// 다운케스팅 : 다시 자식 자료형으로 돌아오는 것
		br = (Bro) pa02; // br : Bro,Object,Par // pa02 : Par, Object, Bro
		
//		pa02.b = 7; // 31번 줄이 	임시적으로 변환되는 것이기 때문에 변수 b에 외부 접근 불가.
//		System.out.println("pa02.b : " + pa02.b);
		
		br.p = 5; // 접근가능
		br.b = 7; // 접근가능
		System.out.println("pa02.p : " + pa02.p);
		System.out.println("br.p : " + br.p + " / br.b : " + br.b);
		//직접적인 상속 관계가 아니므로, 오류 발생.
//		br = (Bro)ch;


	}

}
