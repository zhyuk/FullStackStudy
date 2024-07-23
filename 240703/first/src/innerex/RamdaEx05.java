package innerex;

interface Ramda5 {
	void showString(String str); // public abstract 생략
}

public class RamdaEx05 {

	public static void main(String[] args) {
		Ramda5 lamda5 = returnString(); // 주소값으로 반환 받기
		lamda5.showString("Hello");
	}
	
	public static Ramda5 returnString() {
		return s -> System.out.println(s + " Java");
	}

}
