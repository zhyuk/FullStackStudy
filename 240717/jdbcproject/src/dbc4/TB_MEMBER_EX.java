package dbc4;

import java.util.ArrayList;
import java.util.Scanner;

public class TB_MEMBER_EX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 콘솔창에 입력할 수 있는 객체 Scanner 생성
		TB_MEMBER_DAO dao = new TB_MEMBER_DAO(); // TB_MEMBER_DAO 클래스를 복제(=인스턴스)한 dao 객체 생성
		boolean tf = false;

		// 회원가입
		while (true) {
			System.out.println("회원가입을 시작합니다.");
			System.out.print("아이디 입력 >>");
			String mid = sc.next();

			System.out.print("비밀번호 입력 >>");
			String mpw = sc.next();

			System.out.print("이메일 입력 선택 1.예 2. 아니오");
			int yn = sc.nextInt();
			String memail = null;
			if (yn == 1)
				System.out.print("이메일 입력 >>");
				memail = sc.next();

			System.out.print("전화번호 입력 선택 1.예 2. 아니오");
			yn = sc.nextInt();
			String mph = null;
			if (yn == 1)
				System.out.print("전화번호 입력 >>");
				mph = sc.next();

			if (mid == null || mid.equals("") || mpw == null || mpw.equals("")) {
				continue; // 다시 while문 머리로 돌아가라.
			} else {
				int cnt = dao.join(mid, mpw, memail, mph);
				if (cnt > 0) {
					System.out.println("회원가입 성공");
					break;
				} else {
					System.out.println("회원가입 실패");
					continue; // 다시 while문 머리로 돌아가라.
				}
			}
		}

		// 로그인
		System.out.println("로그인 메뉴");
		while (true) {
			System.out.print("아이디 입력 >>");
			String id = sc.next(); // 공백없는 문자열로 받아오기 위해 sc.next() 선언 후 그 값을 문자열 자료형 변수 id에 담음
			System.out.print("비밀번호 입력 >>");
			String pw = sc.next(); // 공백없는 문자열로 받아오기 위해 sc.next() 선언 후 그 값을 문자열 자료형 변수 pw에 담음

			TB_MEMBER_VO vo = dao.login(id, pw); // dao 객체에 login(매개변수1, 매개변수2) 메소드 호출. -> 메소드가 실행되고 반환된 값을 vo 객체에 담음

			if (vo != null) {
				System.out.println("로그인 성공");
				tf = true;
				break;
			} else
				System.out.println("정보가 일치하는 회원이 없습니다.");
		}

		// 전체회원 목록 조회
		System.out.println("전체회원 목록 조회");
		if (tf) {
			ArrayList<TB_MEMBER_VO> mList = dao.memberList();
			if (mList.size() > 0) { // mList.size() > 0 : mList의 사이즈가 0보다 클 때(= 가져온 값이 1개라도 있을 때)
				for (TB_MEMBER_VO mvo : mList) {
					System.out.printf("아이디 : %s, 비밀번호 : %s, 이메일 : %s \n", mvo.getM_userid(), mvo.getM_pwd(),
							mvo.getM_email());
				}

			} else {
				System.out.println("회원 목록이 없습니다.");
			}
		}
		
		// 로그인한 사용자 보기
		System.out.println("로그인한 사용자 보기");
		while (true) {
			System.out.print("아이디 입력 >>");
			String id = sc.next(); // 공백없는 문자열로 받아오기 위해 sc.next() 선언 후 그 값을 문자열 자료형 변수 id에 담음
			System.out.print("비밀번호 입력 >>");
			String pw = sc.next(); // 공백없는 문자열로 받아오기 위해 sc.next() 선언 후 그 값을 문자열 자료형 변수 pw에 담음

			TB_MEMBER_VO vo = dao.login(id, pw);
			
			
			
			if (vo != null) {
				System.out.println("로그인 성공");
				System.out.println(id);
//				dao.selOne(id);
				
			} else
				System.out.println("정보가 일치하는 회원이 없습니다.");
		}

	}

}
