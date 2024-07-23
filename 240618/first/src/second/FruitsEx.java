package second;

public class FruitsEx {
	
	public static void main(String[] args) {
		// 지역변수는 접근제어자 불가능 기타제어자 "final"만 가능
//		int total;
//		
//		Fruits f1 = new Fruits(30, 30, 30);
//		total = f1.count();
//		
//		System.out.println("객체 f1의 총 개수 = " + total);
//		System.out.println("객체 f1의 apple 개수 = " + f1.apple);
//		System.out.println("객체 f1의 straw 개수 = " + f1.straw);
//		System.out.println("객체 f1의 grapes 개수 = " + f1.grapes);
		
		Fruits f1 = new Fruits(30, 30, 30);
		int total = f1.getSum();
		int appleCount = f1.getApple();
		int strawCount = f1.getStraw();
		int grapesCount = f1.getGrapes();
		
		System.out.println("객체 f1의 총 개수 = " + total);
		System.out.println("객체 f1의 apple 개수 = " + appleCount);
		System.out.println("객체 f1의 straw 개수 = " + strawCount);
		System.out.println("객체 f1의 grapes 개수 = " + grapesCount);
		
	}
}
