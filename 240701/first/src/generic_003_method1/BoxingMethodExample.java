package generic_003_method1;

public class BoxingMethodExample {

	public static void main(String[] args) {
		Box<Integer> box1 = Utill.boxing(100);
//		Box<Integer> box1 = Utill.<Integer>boxing(100);
		System.out.println(box1.get());
		
		Box<String> box2 = Utill.boxing("홍길동");
		System.out.println(box2.get());

	}

}
