package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		new DeleteTest(1);

	}

	public DeleteTest(int empno) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "TEST";
			String password = "1111";

			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연동 성공");

			// 정적객체 Statement 사용
//			Statement st = conn.createStatement();
//			String sql = "delete from emp where empno = " + empno;
//			int resultRowCount = st.executeUpdate(sql);
			
			// 동적객체 PreparedStatement 사용
			String sql = "delete from emp where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			int resultRowCount = ps.executeUpdate();
			

			if (resultRowCount > 0) {
				System.out.println("데이터 수정 완료");
			} else {
				System.err.println("데이터 수정 실패");
			}

//			st.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 연결 실패");
		} catch (SQLException e) {
			System.err.println("데이터베이스 연동 실패");
		}

	}

}
