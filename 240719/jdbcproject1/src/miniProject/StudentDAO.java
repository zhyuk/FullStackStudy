package miniProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDAO {
	// 회원가입 기능
	public void joinStudent() {
		PreparedStatement ps = null;
		int sno = 0;
		int ascii;
		while (true) {

			try {
				System.out.println("DB 연결 성공");
				System.out.println("회원 가입 메뉴");
				System.out.println("학번 입력 >>");
				if (!ConnManager.getScanner().hasNextInt()) {
					System.out.println("숫자만 입력할 수 있습니다."); continue;
				}
				sno = ConnManager.getScanner().nextInt();
				System.out.println(sno);

				System.out.println("아이디 입력 >>");
				ConnManager.getScanner().nextLine();
				String sid = ConnManager.getScanner().nextLine();

				System.out.println("비밀번호 입력 >>");
				String spw = ConnManager.getScanner().nextLine();

				System.out.println("이름 입력 >>");
				String snm = ConnManager.getScanner().nextLine();

				joinStudentSQL(sid, spw, sno);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void joinStudentSQL(String sid, String spw, int sno) {
		String sql = "update student set sid = ?, spw = ?, slms = 'Y' where sno = ? and slms = 'N'";
		PreparedStatement ps = null;
		try {
			ps = ConnManager.getConnection().prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, spw);
			ps.setInt(3, sno);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("회원가입 완료");
			else
				System.out.println("회원 가입이 실패하였습니다.\n" + "사유: 없는 학번이거나 중복 아이디");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}