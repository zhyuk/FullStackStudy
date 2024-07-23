package generic_003_method1;

public class Utill {//          Integer 100
	public static <T> Box<T> boxing(T t) { // T = Integer
		 // 			&200
		Box<T> box = new Box<T>(); // T = Integer
		box.set(t);  
		return box;
	}
}
