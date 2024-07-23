package collectionex;

import java.util.*;



public class CollEx05 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
//		map 은 put을 사용해서 한다.
		map.put("one", "하나");
		map.put("two", "둘"); 
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		Set<String> keys = map.keySet(); // "one", "two", "three", "four", "five"
//		for(String s : keys){
//		System.out.printf("key: %s\t value: %s\n" + s, map.get(s));
//
		
		Iterator<String> iter = keys.iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.printf("key : %s\t value: %s\n", key, map.get(key));
		}
		
		System.out.println("\n==========================\n");
		Collection<String> value = map.values();
		iter = value.iterator();
		while (iter.hasNext()) {
			System.out.printf("value : %s\n", iter.next());
		}
	}

}
