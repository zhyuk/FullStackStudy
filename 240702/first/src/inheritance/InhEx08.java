package inheritance;

public class InhEx08 {

	public static void main(String[] args) {
		Pt pt = new Pt(); //&100//대표자료:Pt(Object)
		pt.display();
		
		Cd ch = new Cd(); //&200//대표자료:Cd(Pt, Object)//cha-cha 케이스
		ch.setB(90);
		ch.display();
		
		Pt ch1 = new Cd(); //&300//대표자료:Pt(Cd, Object)//pa-cha 케이스
		ch1.display();
	}

}

class Pt{ //부모클래스
	private int a = 10;
	public int b = 20;
	void display() { //메소드 이름이 동일하면 외부접근에서 자식것을 먼저 가져온다.
		System.out.println("Pt_a: " + a);
		System.out.println("pt_b: " + b);
		System.out.println("=====================");
	}
	
	public int getA() { return a; }
	public void setB() { this.b = 5; } //메소드 오버로딩 - 이름이 동일해도 다르다.
}

class Cd extends Pt { //Cd는 자식 자리, Pt는 부모 자리 이므로 Pt가 부모 클래스이다.
	public int c = 30;
	void display() { //메소드 이름이 동일하면 외부접근에서 자식것을 먼저 가져온다.
		//System.out.println("Cd_a: " + a);
		//상속받은 private 필드, 가려짐.
		System.out.println("cd_a: " + getA());
		System.out.println("cd_b: " + b);
		//상속받은 public 필드 참조
		System.out.println("Cd_c: " + c);
		//자식 클래스에서 선언한 public 필드 참조
		System.out.println("=====================");
	}
	
	public void setB(int b) { //메소드 오버로딩 - 이름이 동일해도 다르다.
		this.b = b; //super도 가능하다.
	}
}
