package interfaceex;

public class XInterEx06 {

	public static void main(String[] args) {
		InterfaceClass ic = new InterfaceClass();
		
		ic.xmeth1();
		ic.xmeth2();
		ic.ymeth1();
		ic.zmeth1();
	}
}

class InterfaceClass implements Z {
	public void xmeth1() {
		System.out.println("xmeth1() 메소드의 구현");
	}
	
	public void xmeth2() {
		System.out.println("xmeth() 메소드의 구현");
	}
	
	public void ymeth1() {
		System.out.println("ymeth1() 메소드의 구현");
	}
	
	public void zmeth1() {
		System.out.println("zmeth1() 메소드의 구현");
	}
}