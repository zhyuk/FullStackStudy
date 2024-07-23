package generic_003_method1;

public class Util {
	
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>(); // &100
		box.set(t);
		return box;
		
	}
}
