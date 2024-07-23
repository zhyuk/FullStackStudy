package inheritance;

import third.DifferSuperClass;

public class DifferSubClass extends DifferSuperClass {
	public void subMd() {
		md();
	}
	
	//public DifferSubClass(){ super(); } 가 숨겨져있다.
	public static void main(String[] args) {		
		DifferSubClass sp = new DifferSubClass();//&100//cha-cha 케이스
		System.out.println(sp.sameVar);
		sp.md();
		sp.subMd();
	}
}
