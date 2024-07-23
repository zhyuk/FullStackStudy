package inheritance;

import third.DifferSuperClass; // third 패키지에 있는 DifferSuperClass 클래스 사용하기 위해 선언

public class DifferSubClass extends DifferSuperClass {

	public void subMd() {
		md();
	}

	// public DifferSubClass(){
//		super();
//	} 생략되어있다.
	public static void main(String[] args) {
		DifferSubClass sp = new DifferSubClass(); // 싱글톤 패턴 // 내 클래스 자체를 새로운 공간에 복제해서 공간의 주소값을 sp 객체에 저장
		System.out.println(sp.sameVar); // sp가 자식클래스-자식클래스임으로 Cha-Cha 케이스임 + sameVar 객체의 접근제어자가  protected기 때문에 같은 패키지 내가 아니라면 상속관계일 때만 접근 가능
		sp.md(); // md()가 statitc이 아니더라도, sp 객체를 사용할 수 있기 때문에 접근할 수 있다.
	}

}
