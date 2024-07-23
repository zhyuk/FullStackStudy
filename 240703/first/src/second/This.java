package second;

public class This {
	int num = 1; //2
	String str = "한글"; //"테스트"
	//public This(){}가 숨겨져있다.
	
	public void setNum(int num, String str) {
		this.num = num; //2
		this.str = str; //"테스트"
	}
	
	public int getNum() {
		return num; // 2
	}
	
	public int getNum(int j) { // 5
		this.num = num * j; // 2 * 5
		return num;
	}
	
	public void amd() {
		int num = 5;
		int str = 7;
		if (num <= 5) {
			System.out.println("this.num 는 " + this.num); //1 2
			System.out.println("this.str는 " + this.str); //한글 테스트 
			System.out.println("num 는 " + num); //5 5
			System.out.println("str는 " + str); //7 7
		}
		System.out.println("num 는 " + num); //5 5
		System.out.println("str는 " + str); //7 7
		System.out.println();
	}
}
