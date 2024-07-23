package first;

public class Ex06 {
	public static void printstr(String str) {//printstr 메소드. String 매개변수 1개를 가지는
		System.out.println(str);		
	}
	public static void printstr(char ch, int cnt) {//오버로딩. printstr 메소드. char와 int 매개변수 2개를 가지는
		for(int i =0; i < cnt ; i++) {
			System.out.print(ch);		
		}
		System.out.println();
	}
	
	public static void main(String[] args) { // main 메소드. String[] 매개변수 1개를 가지는
		printstr("즐거운 점심시간입니다."); //첫번째 메소드 호출
		printstr('A', 10); // 두번째 메소드 호출		
	}

}
