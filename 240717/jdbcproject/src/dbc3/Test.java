package dbc3;

public class Test {
		// a = 5 -> 10 -> 15 
		// b = 7 -> 21 -> 14 -> 28
		private int a = 5; // 초기화순서 : 2
		private static int b  =7; // 초기화순서 : 1
		private final int c; // 자동초기화 값 없음. 꼭 초기화를 시켜줘야함
		
		{ // 초기화순서 : 4
			System.out.println("초기화블록 이전의 멤버필드 a의 값 : " + this.a + "/ b의 값 : " + this.b);
			System.out.println("초기화블록");
			this.a = 10;
			this.b = 14;
			this.c = 100; //멤버상수를 초기화하기 위해서는 초기화블록 or 기본생성자에서 1번만 초기화해야함
		}
		
		static { // 초기화순서 : 3
			System.out.println("static 초기화블록 이전의 멤버필드 b의 값 : " + b);
			System.out.println("static 초기화블록");
			b = 21;
		}
		
		public Test() { // 초기화순서 : 5
			System.out.println("생성자 호출 이전의 멤버필드 a의 값 : " + this.a + "/ b의 값 : " + this.b);
			System.out.println("생성자 호출");
			this.a = 15;
			this.b = 28;
//			this.c = 100; 멤버상수를 초기화하기 위해서는 초기화블록 or 기본생성자에서 1번만 초기화해야함
		}
		
		public int getA() {return a;} // 초기화순서 : 6
		public int getB() {return b;} // 초기화순서 : 7
}
