package first;

public class Point01Ex {
	public static void main(String[] args) {
		// 객체 생성문 형식 => 자료형 객체명 = new 생성자호출문();
		// 생성자호출문 => 자료형()
		Point01 pt01 = new Point01(); //객체생성
		
		pt01.x =10;
		pt01.y = 20;
		System.out.println(pt01.x + ", " + pt01.y);
		
		Point01 pt02 = new Point01(); //객체생성
		
		pt01.x =30;
		pt01.y = 10;
		System.out.println(pt01.x + ", " + pt01.y);
		System.out.println(pt02.x + ", " + pt02.y);
	}

}