package collectionex;

import java.util.*;

public class CollEx06 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("admin", "admin");
		map.put("hong", "1234");
		map.put("haha", "1234");
		
		Scanner s = new Scanner(System.in);
//		콘솔창에서 라인(줄)단위로 입력을 받는 객체
		
		while (true) {
		System.out.println("id와 password를 입력해주세요.");
		System.out.print("id : ");
		String id = s.nextLine().trim();
		
		System.out.print("password: ");
		String password = s.nextLine().trim();
		System.out.println();
		
		if(!map.containsKey(id)) {
			System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.\n");
		} else {
			if(!(map.get(id)).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
			 break;
			}
	  	 }//바깥 else문 종료 중괄호
	  } //while문 종료 중괄호
   }  //main()메소드 종료 중괄호
}