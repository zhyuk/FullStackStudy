package collectionex;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry; //생략불가

public class CollEx07 {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		// key, value로 입력이 가능
		hm.put("hello", 123);
		hm.put("world", 345);
		
		// key를 null로 할 수 있고 value도 null로 할 수 있다.
		hm.put(null, 555);
		hm.put("nullKey", null);
		hm.put("world", 777);
		//put 메소드 기능 : 해당 key가 존재하지 않으면 추가, key가 존재하면 값 변경(설정)
		System.out.println(hm + "\n");
		
		for (String key : hm.keySet()) {
			System.out.println("key : " + key + ", value : " + hm.get(key));
		}
		System.out.println("\n==========================\n");
		
		//entrySet 메소드는 key, value를 볼 수 있게 해준다.
		for (Entry<String, Integer> s : hm.entrySet()) {
			System.out.println(s.getKey() + ", " + s.getValue());
		}
		System.out.println("\n=========================\n");
		
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		// key, value로 입력이 가능
		lhm.put("hello", 123);
		lhm.put("world", 345);
		
		// key를 null로 할 수 있고 value도 null로 할 수 있다.
		hm.put(null, 555);
		hm.put("nullKey", null);
		System.out.println(lhm + "\n");
		
		for (String key : lhm.keySet()) {
			System.out.println("key : " + key + ", value : " + lhm.get(key));
		}
		System.out.println("\n==========================\n");
		
		//entrySet 메소드는 key, value를 볼 수 있게 해준다.
		for (Entry<String, Integer> s : lhm.entrySet()) {
			System.out.println(s.getKey() + ", " + s.getValue());
		}
		System.out.println("\n=========================\n");

	}

}
