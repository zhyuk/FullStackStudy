package generic_003_method2;

public class CompareMethodExample {

	public static void main(String[] args) {
						   //&100          &100
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		                   //&200          &200
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
								   //&100 , &200
		boolean result1 = Util.compare(p1, p2);
//		         true           true
//		boolean result1 = Util.<Integer, String>compare(p1, p2);
//		   true
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
//		                    &300        &300
		Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
//		                    &400        &400
		Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		if(result2) {
			System.out.println("논리적으로 동등한 객체입니다.");
		} else {
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
		}

	}

