package dbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberInsert2 {

	public static void main(String[] args) {
		try {
			Connection conn = DBConnec1.getConnection();
			String userid = "tiger";
			String pwd = "1111";
			String email = "tiger@naver.com";
			String hp = "010-1111-3333";

			// Statement 정적객체 사용
			// String클래스의 format 메소드를 사용하여 보기좋게 작성.
			// format() : 서식지정자를 이용하여 문자열로 반환. (printf와 유사함) -> 첫번째 %s -> userid의 값으로 대체,
			// 2번째 %s -> pwd의 값으로 대체, ...
			String sql = String.format("insert into tb_member (m_seq, m_userid, m_pwd, m_email, m_hp)"
					+ "values(seq_tb_member.nextval, '%s', '%s', '%s', '%s')", userid, pwd, email, hp);

			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "개 행 입력");

//			// PreparedStatement 동적객체 사용
//			String sql = "insert into tb_member (m_seq, m_userid, m_pwd, m_email, m_hp)"
//					+ "values(seq_tb_member.nextval, :userid, :pwd, :email, :hp)";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			pstmt.setString(2, pwd);
//			pstmt.setString(3, email);
//			pstmt.setString(4, hp);
//			int count = pstmt.executeUpdate();
//			System.out.println(count + "개 행 입력");

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				DBConnec1.close();
			} catch (SQLException e) {
			}
		}

	}

}
