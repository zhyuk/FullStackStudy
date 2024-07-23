package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		new UpdateTest(7844, "TURNER", 8000);

	}

	public UpdateTest(int empno, String ename, double sal) {
		try {
			/* User 클래스를 활용해서 드라이버 설치, DB 연동하는 방법
			User user = new User();
			Class.forName(user.getDriver());			
			Connection conn = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());
			 */
			
			// 오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "TEST";
			String password = "1111";

			// DB와 데이터를 주고 받기 위한 연결객체 생성(통로 오픈)
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연동 성공");

			// 정적객체 Statement 사용
//			Statement st = conn.createStatement();
//			int resultRowCount = st.executeUpdate("update emp set ename= '" + ename + "', sal = " + sal + "where empno =" + empno);
			
			// 동적객체 PreparedStatement 사용
			String sql = "update emp set ename= ?, sal = ? where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setDouble(2, sal);
			ps.setInt(3, empno);
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
			System.err.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.err.println("DB 연결 실패");
			e.printStackTrace();
		}

	}
}
