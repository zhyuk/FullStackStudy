package inheritance;

public class CastingTest02 {
	
	public static void main(String[] args) {
		Guest guest = new Guest(); //&100
//		Food foodone = new Food(); 
		Food foodone = new Jjigae();
//		Food foodone = new Tang(); //&200 //대표자료Food(Tang, Object)//pa-cha 케이스
		guest.foodEat(foodone); //foodEat 메소드 대입
	}
}

class Food { //부모클래스
	public void cook() { //&200 X
		System.out.println("Food 간맞추기"); //2
	}
}

class Jjigae extends Food {
	public void cook() {
		System.out.println("Jjigae 간맞추기"); //2
	}
}

class Tang extends Food {
	//public Tang( ){ super(); } 숨겨져 있음
	public void cook() { //&200 foodone
		System.out.println("Tang 간맞추기"); //출력
	}
}

class Guest {
	public void foodEat(Food somefood) { //somefood = foodone &200
		System.out.println("Guest 간맞추기"); //출력 1
		somefood.cook();
	}
}