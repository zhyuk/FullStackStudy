package third;

public class Company {
	// private static으로 선언된 클래스명이 자료형으로 생성된 멤버필드의 유무
	private static Company instance;
	private Company() {}
//	private static int count = 0;
	
	public static Company getInstance() {
		if(instance == null ) {
			instance = new Company();
		}
//		count++;
//		System.out.println(count);
		return instance;
	}
}
