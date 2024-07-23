package second;

public class ThisTest {
	int x, y;

	// 기본생성자 호출
	public ThisTest() {
		// ThisTest 클래스 내 매개변수 두 개를 가진 ThisTest()를 호출
		this(10, 10);
	}

	public ThisTest(int x) {
		this(x, 10);
	}

	public ThisTest(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int a) {
		this.x = x;
	}

	public void showPoint() {
		System.out.println(x + "," + y);
	}
}
