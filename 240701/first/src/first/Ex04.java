package first;

public class Ex04 {
// 
//	public static void calc (int a, String d, int b) {
//		switch(d) {
//			case "+" : System.out.println( a + b ); break;
//			case "x" : System.out.println( a * b ); break;
//			case "/" : System.out.println( a / b ); break;
//			case "%" : System.out.println( a % b ); break;
//			default : System.out.println(a - b);	
//		}
//	}
//	
//	public static void main(String[] args) {
//		calc(5, "+", 10);
//		calc(5, "x", 10);
//		calc(10, "/", 5);
//		calc(10, "%", 5);
//		calc(5, "-", 10);
//		System.out.println();
//	}
	
	public static int calc (int a, String d, int b) {
		int result = 0;
		switch(d) {
			case "+" : result =  a + b ; break;
			case "x" : result =  a * b ; break;
			case "/" : result =  a / b ; break;
			case "%" : result =  a % b ; break;
			default : result =  a - b ;	
		}
		return result;
	}
	
	public static void main(String[] args) {
		int result = calc(5, "+", 10);
		System.out.println(result);
		
		result = calc(5, "x", 10);
		System.out.println(result);
		
		result = calc(10, "/", 5);
		System.out.println(result);
		
		result = calc(10, "%", 5);
		System.out.println(result);
		
		result = calc(5, "-", 10);
		System.out.println(result);
	}
	
}
