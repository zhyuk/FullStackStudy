package first;

public class Point02Ex {	
	
	public static void md() {
		System.out.println("md메소드 호출");
	}
	
	public static void main(String[] args) {
        Point02 pt02 = new Point02(100, 200);
        System.out.println( pt02.x + ", " + pt02.y );
        pt02.showPoint();
        
        Point02 pt02_1 = new Point02();
        System.out.println( pt02_1.x + ", " + pt02_1.y);
        pt02_1.showPoint();
	} 

}
