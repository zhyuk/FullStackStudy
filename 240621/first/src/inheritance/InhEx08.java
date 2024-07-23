package inheritance;

public class InhEx08 {

	public static void main(String[] args) {
		Pt pt = new Pt();
		pt.display();

		Cd ch = new Cd();
		ch.setB(90);
		ch.display();

		Pt ch1 = new Cd();
		ch1.display();
	}

}

class Pt {
	private int a = 10;
	public int b = 20;

	void display() {
		System.out.println("Pt_a : " + a);
		System.out.println("Pt_b : " + b);
		System.out.println("===============");
	}

	public int getA() {
		return a;
	}

	public void setB() {
		this.b = 5;
	}
}

class Cd extends Pt {
	public int c = 30;

	void display() {
		// System.out.println("Cd_a : " + a);
		// 상속받은 private 필드, 가려짐.
		System.out.println("Cd_a : " + getA());
		System.out.println("Cd_b : " + b);
		// 상속받은 public 필드 참조
		System.out.println("Cd_c : " + c);
		// 자식 클래스에서 선언한 public 필드 참조
		System.out.println("===================");
	}

	public void setB(int b) {
		this.b = b;
	}
}
