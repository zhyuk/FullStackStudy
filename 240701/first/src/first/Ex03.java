package first;

public class Ex03 {
	public static int abs(int a) { // 절댓값 호출
		if(a < 0) a = -a;

		return a;
	}		
	
	public static void main(String[] args) {
		System.out.println(abs(-5));
				
	}

}
