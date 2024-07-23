package dbc5;

import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) {
		String ch;
		Score ob = new Score();
		Scanner sc = new Scanner(System.in);

		try {
			home: // 라벨
			while (true) {
				System.out.print("1. 입력 2. 수정 3. 삭제 4. 이름검색 5. 전체출력 6. 종료 =>");
				ch = sc.nextLine(); // 공백문자를 포함하고 있는 1줄을 가져옴 ==> "이름 검색" 입력시 ch는 "이름 검색" 그대로 받음

				switch (ch.replace(" ", "")) { // ch.replace(" ", "") -> 공백을 제거
				case "1":
				case "입력":
					if (ob.insertDate() != 0)
						System.out.println("입력 성공!");
					break;
				case "2":
				case "수정":
					if (ob.updateData() != 0) System.out.println("수정 성공!"); // ob.updateData() != 0 : ob.updateData() 메소드의 리턴값과 비교
					else System.out.println("수정 실패!");
					break;
				case "3":
				case "삭제":
					if (ob.deleteDate() != 0) System.out.println("삭제 성공!");
					else System.out.println("삭제 실패!");
					break;
				case "4":
				case "이름검색":
					ob.selectName();
					break;
				case "5":
				case "전체출력":
					ob.selectAll();
					break;
				case "6":
					System.out.println("종료되었습니다.");
					DBConn.close();
					break home; // home이라는 라벨을 가진 반복문 혹은 switch문을 탈출해주세요
//					System.exit(0); // 실행한 프로그램을 종료
				}

			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("시스템이 종료되었습니다.");
	}

}
