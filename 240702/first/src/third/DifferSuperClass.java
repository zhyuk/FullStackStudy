package third;

public class DifferSuperClass {
	protected String sameVar = "다른 패키지에 속하는 자식 클래스까지 허용"; // 같은 패키지 내, 상속관계 시
//	public DifferSuperClass() {} public이 없을 때, 상속받을 수 없음. 다른 패키지기 때문
	
	public void md() {
		System.out.println("부모클래스의 md()메소드 호출");
	}
}
