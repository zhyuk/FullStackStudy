package generic_003_method2;

public class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		          //true       //1         비교     1
		boolean keyCompare = p1.getKey().equals(p2.getKey());
				  //true	 // "사과"     비교      "사과"
		boolean valueCompare = p1.getValue().equals(p2.getValue());
				  //true        //true
		return keyCompare && valueCompare;
	}
}
