package generic_000_none;

public class BoxExample {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("홍길동");
		String name = (String) box.get();
		
		box.set(new Apple());
		Apple apple = (Apple) box.get();
		apple.setNum(100);
		System.out.println(apple.getNum());
	}

}
