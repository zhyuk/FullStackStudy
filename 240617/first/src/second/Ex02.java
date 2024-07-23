package second;

public class Ex02 {

//	public Ex02() {
//		System.out.println("second 패키지 안의 Ex02 클래스로 객체 생성");
//	}

	public static void main(String[] args) {
//		String s = new String("Hello");
//		System.out.println(System.identityHashCode(s));
//		System.out.println(s.hashCode());
//		String s1 = ("Hello");
//		System.out.println(System.identityHashCode(s1));
//		System.out.println(s1.hashCode());
//		String s2 = ("Hello"); // new가 없기 때문에 값을 보고 동일한 값을 갖고 있는 주소값을 복사해온다.
//		System.out.println(System.identityHashCode(s2));
//		System.out.println(s2.hashCode());

		String s = new String("빨간불");
		String s1 = "빨간불"; // 단축형식
		// 단축형식과 new를 통한 객체선언은 주소값이 다르다.

		if (s == s1) /* false */ {
			System.out.println("빨간불입니다.");
		} else {
			System.out.println("빨간불이 아닙니다."); // 출력
		}

		// 객체1.equals(객체2) : 객체1과 객체2가 갖고있는 값 비교
		if (s.equals(s1)) /* true */ {
			System.out.println("빨간불입니다."); // 출력
		} else {
			System.out.println("빨간불이 아닙니다.");
		}

//		System.out.println(s == s1);
//		System.out.println(s1 == s2);
	}
}
