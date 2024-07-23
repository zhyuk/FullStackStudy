package collectionex;

import java.util.Hashtable;
import java.util.Map.Entry;

public class CollEx08 {

	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable();
		ht.put("world", 321);
		ht.put("hello", 123);
		// key, value 각각에 null을 허용하지 않는다.
//		ht.put("hello", null);
//		ht.put(null, 123);
		for(String key : ht.keySet()) {
			System.out.println(ht.get(key));
		}
		for(Entry<String, Integer> entry : ht.entrySet()) {
			System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
		}
		Hashtable<Integer, Integer> ht1 = new Hashtable<>();
		ht1.put(1, 123);
		ht1.put(2, 321);
		
		for(int i = 1; i <= ht1.size(); i++) {
			System.out.println(ht1.get(i));
		}

	}

}
