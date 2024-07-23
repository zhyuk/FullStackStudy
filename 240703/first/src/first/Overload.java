package first;

public class Overload {
	void test() {
		System.out.println("매개변수 없음");
	}
	void test(int a, int b) {
		System.out.println("매개변수 int " + a + "와 int " + b);
	}
	double test(double a) {
		System.out.println("매개변수 double " + a);
		return a * 2;
	}
}
