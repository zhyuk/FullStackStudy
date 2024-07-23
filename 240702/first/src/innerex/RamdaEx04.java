package innerex;

interface Ramda4 {
	public void showString(String string);
}

public class RamdaEx04 {

	public static void main(String[] args) {
		Ramda4 lamda4 = s -> System.out.println(s);
		// 정식형식
//		Ramda4 lamda4 = new Ramda4() {
//		
//			@Override
//			public void showString(String string) {
//				System.out.println(s);
//			}
//		};
		lamda4.showString("매개변수로 람다식 전달하기");
		showMyString(lamda4); // showMyString 메소드에 lamda4의 주소값 전달
	}
	
	public static void showMyString(Ramda4 r) {
		r.showString("전달한 람다식 이용하여 출력");
	}

}
