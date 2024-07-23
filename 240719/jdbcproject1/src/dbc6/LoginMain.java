package dbc6;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LoginSVC loginSVC = new LoginSVC();
		int selNum = 0;

		while (true) {
			if (selNum == 0) {
				System.out.println("메뉴를 선택해 주세요.");
				System.out.println("로그인은 1번, 회원가입은 2번, 회원탈퇴는 3번, 프로그램 종료는 4번을 입력해주세요.");
				selNum = sc.nextInt();
				// sc.nextLine(); // 공백을 포함하기 때문에 위에서 엔터된 것을 초기화시킬 수 없음. next(), nextInt(), nextDouble 등은 초기화 시킴
			} else if (selNum == 1) {
				// 로그인
				System.out.println("로그인 메뉴");
				System.out.println("아이디와 비밀번호를 입력하세요.");

				System.out.println("아이디 : ");
				String id = sc.next().toLowerCase();

				System.out.println("비밀번호 : ");
				String passwd = sc.next().toLowerCase();

				User user = loginSVC.login(id, passwd);
				if (user == null) {
					System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
					System.out.println("다시 입력은 1번, 회원가입은 2번, 취소는 3번, 프로그램 종료는 4번을 입력해주세요.");

					int sel = sc.nextInt();
					if (sel == 1) {
						selNum = 1;
					} else if (sel == 2) {
						selNum = 2;
					} else if (sel == 3) {
						selNum = 3;
					} else {
						selNum = 4;
					}
				} else {
					System.out.println("로그인 완료!");
					System.out.println("로그인한 사용자 정보");
					System.out.println(user);
					selNum = 0;
				}
			} else if (selNum == 2) {
				// 회원가입
				System.out.println("회원가입 메뉴");
				System.out.println("아이디 입력 : ");
				String id = sc.next().toLowerCase();

				System.out.println("비밀번호 입력 : ");
				String pw = sc.next().toLowerCase();

				sc.nextLine();

				System.out.println("이름 입력 : ");
				String nm = sc.nextLine().toLowerCase();

				System.out.println("입력완료: 1번, 다시 입력: 2번, 취소는 3번, 프로그램 종료는 4번을 입력해주세요.");
				int sel = sc.nextInt();
				if (sel == 1) {
					int c = loginSVC.insertMember(id, pw, nm);
					if (c > 0) {
						System.out.println("회원가입이 완료되었습니다.");
						selNum = 0;
					} else {
						System.out.println("다시 입력해주십시오.");
						selNum = 2;
					}
				} else if (sel == 2)
					selNum = 2;
				else if (sel == 3)
					selNum = 0;
				else
					selNum = 4;
			} else if (selNum == 3) {
				// 회원탈퇴메뉴
				System.out.println("회원탈퇴 메뉴");
				System.out.println("회원탈퇴를 하시려면 1번, 취소는 2번, 프로그램 종료는 3번을 입력해주세요.");

				int sel = sc.nextInt();
				if (sel == 1) {
					System.out.println("탈퇴할 아이디 입력: ");
					String id = sc.next().toLowerCase();
					int c = loginSVC.deleteMember(id);

					if (c > 0) {
						System.out.println("회원탈퇴 완료");
					} else {
						System.out.println("탈퇴가 되지 않았습니다.");
						continue;
					}
				} else if (sel == 2)
					selNum = 0;
				else
					selNum = 4;
			} else {return;} // return 키워드를 감싸고 있는 메소드를 종료한다.

		} // while문
	}

}
