package dbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JoinEx {
	public static int cntResult(String str) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) { // 방금 입력한 텍스트를 한글자씩 떼와서 반복함
			int aciiCode = (int) str.charAt(i);

			if (aciiCode < 48) {
				System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
				cnt++;
				break;
			}
			if (aciiCode > 58 && aciiCode < 64) {
				System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
				cnt++;
				break;
			}

			if (aciiCode > 90 && aciiCode < 97) {
				System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
				cnt++;
				break;
			}

			if (aciiCode > 122) {
				System.out.println("영어대소문자, 숫자만 입력하실 수 있습니다.");
				cnt++;
				break;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			// 1. 드라이버 설치
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");

			// 2. Connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "test";
			String password = "1111";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연동 성공");

			// 3. 명령문 객체 생성
			// insert into member (mid, mpw, mnm, mph, mzip, maddr) values(?, ?, ?, ?, ?,?);
			String sql = "insert into member (mid, mpw, mnm, mph, mzip, maddr)" + "values(?, ?, ?, ?, ?,?)";
			ps = con.prepareStatement(sql);
			// 4. 명령문 실행
			Scanner sc = new Scanner(System.in);

			// 0-9 : 아스키코드 48~57 , A-Z : 아스키코드 65 ~ 90 a-z : 아스키코드 97-122
			while (true) {
				System.out.print("아이디(영어대소문자,숫자포함20자이내)>>");
				String mid = sc.next();

				if (cntResult(mid) == 0) {
					ps.setString(1, mid);
					break;
				}
			}
			while (true) {
				System.out.print("비밀번호(영어대소문자,숫자 포함 20자이내) >> ");
				String mpw = sc.next();
				ps.setString(2, mpw);

				if (cntResult(mpw) == 0) {
					ps.setString(2, mpw);
					break;
				}
			}

			sc.nextLine(); // String mpw = sc.next();의 엔터를 상쇄시키기 위해 기술
			System.out.print("이름입력 >> ");
			String mnm = sc.nextLine();
			ps.setString(3, mnm);

			System.out.print("전화번호입력 (예: 01012345678 >> ");
			String mph = sc.next();
			ps.setString(4, mph);

			System.out.print("우편번호입력 (예: 12345 >> ");
			System.out.print("입력여부 선택 : 1.예 2. 아니오");
			int yes_no = sc.nextInt();
			if (yes_no == 1) {
				System.out.println("우편번호 입력");
				String mzip = sc.next();
				ps.setString(5, mzip);
			} else {
				ps.setString(5, null);
				System.out.println();
			}

			sc.nextLine(); // String mzip = sc.next();의 엔터를 상쇄시키기 위해 기술
			System.out.print("주소입력 >> ");
			System.out.print("입력여부 선택 : 1.예 2. 아니오");
			yes_no = sc.nextInt();
			if (yes_no == 1) {
				System.out.println("주소 입력");
				String maddr = sc.nextLine();
				ps.setString(6, maddr);
			} else {
				ps.setString(6, null);
			}

			int rs = ps.executeUpdate();
			if (rs > 0)
				System.out.println("회원가입 완료");
			else
				System.out.println("회원가입 실패");

		} catch (

		ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연동 오류");
		} finally {
			// 5. 객체 닫기
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("객체닫기 오류");
			}

		}

	}

}
