package second;

//클래스명이 곧 자료형
public class MyDate {
	// 전역변수
	private int y, m, d; // y, m, d = 0;
	private String str; // str = null;

	private void setMyDate(int r) {
		if (r == 1) {
			str = "유효한 날짜입니다.";
		} else {
			str = "유효하지 않은 날짜입니다.";
		}
	}

	public String getMyDate() {
		return str;
	}

	// private 사용 시 같은 클래스 내에서만 호출할 수 있다.
	private MyDate() {
	}

	// 기타생성자 선언문
	// 접근제어자를 작성하지 않으면 기본값 default임 => 같은 패키지 내에서만 호출 가능
	MyDate(int d, int m, int y) {
//		new MyDate();
		this.y = y;
		this.m = m;
		this.d = d;
	}

	public void isValid() {
		int r;
		switch (m) {
		case 4:
		case 6:
		case 9:
		case 11:
			r = (d <= 30) ? 1 : 0;
			break; // r과 (d <= 30)과 같다. 참이면 1, 거짓이면 0이 되는 삼항식
//				if(d <= 30) {
//					r = 1;
//				} else {
//					r = 0; break;
//				}
		case 2:
			if (y % 4 == 0) {
				r = (d <= 29) ? 1 : 0;
			} else {
				r = (d <= 28) ? 1 : 0;
			}
			break;
		default:
			r = (d <= 31) ? 1 : 0;
		}
		setMyDate(r);
	}
}
