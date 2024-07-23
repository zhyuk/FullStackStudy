package second;

public class ThisTestEx {

	public static void main(String[] args) {

		// 객체 생성문 
		ThisTest t01 = new ThisTest(10, 20);
		t01.showPoint();

		ThisTest t02 = new ThisTest(30);
		t02.showPoint();

		ThisTest t03 = new ThisTest();
		t03.showPoint();
	}
}
