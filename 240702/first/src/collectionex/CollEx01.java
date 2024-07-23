package collectionex;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class CollEx01 {

	public static void main(String[] args) {
		//리스트 생성
		ArrayList<String> arrList = new ArrayList<String>();
		
		//리스트에 요소의 저장
		arrList.add("넷");
		arrList.add("둘");
		arrList.add("셋");
		arrList.add("하나");
		
		System.out.println("arrList: " + arrList);
		// 리스트 요소의 출력
		for (String s : arrList) {
			System.out.println(s);
		}
		arrList.remove(1);
		//arrList.clear(); - 모든 공간을 삭제
		
		System.out.println("arrList: " + arrList);
		
		List<String> lst = new ArrayList<String>();
		lst.add("alpha");
		lst.add("beta");
		lst.add("charlie");
		System.out.println("lst객체: " + lst);
		System.out.println("\n=========================\n");
//		Iterator iter = lst.iterator(); 1.5버전 이하에서 사용 Object
		Iterator<String> iter = lst.iterator(); 
		
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		System.out.println("\n===========================\n"); // 값만 떼어올 수 있음
		for(String str : lst) {
			System.out.println(str);
		}
		System.out.println("\n===========================\n"); // 인덱스번호, 값을 가져올 때 사용
		for(int i=0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		}
}

