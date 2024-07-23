package inheritance;

public class CastingTest02 {
	
	public static void main(String[] args) {
		Guest guest = new Guest(); //&100
//		Food foodone = new Food(); // 부모 foodone = new 부모 () : Pa - Pa 케이스 
//		Food foodone = new Jjigae();
		Food foodone = new Tang(); // &200 , 자식 foodone = new 부모() : Pa-Cha 케이스
		guest.foodEat(foodone); // &100에서 foodEat() 메소드 호출, 매개인자로 &200을 보낸다.
	}
} // CastingTest02 클래스 종료

class Food {
	
	public void cook() {
		System.out.println("Food 간맞추기");
	}
} // Food 클래스 종료

class Jjigae extends Food {
	// Jjigae(){super;} 생략되어있음
	public void cook() {
		System.out.println("Jjigae 간맞추기");
	}
} // Jjigae 클래스 종료

class Tang extends Food {
	//public Tang(){super();} 기본생성자 생략
	
	public void cook() {  // 실행
		System.out.println("Tang 간맞추기"); // 실행
	}
} // Tang 클래스 종료

class Guest {
	
	public void foodEat(Food somefood) { // somefood : &200 = Tang 클래스
		System.out.println("Guest 간맞추기"); // 출력
		somefood.cook(); // Tang 클래스 내 cook() 호출
	}
} // Guest 클래스 종료