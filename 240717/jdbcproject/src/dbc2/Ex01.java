package dbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "TEST";
			String pwd = "1111";

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB 연동 성공");

			// 정적객체 Statement 사용
			String sql = "select empno, ename, job, hiredate from emp where deptno = 10";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			// 동적객체 PreparedStatement 사용
			sql = "select empno, ename, job, hiredate from emp where deptno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 10);
			rs = ps.executeQuery();

			while (rs.next()) {
//				int eno = rs.getInt("empno");
//				String ename = rs.getString("ename");
//				String job = rs.getString("job");
//				Date hrd = rs.getDate("hiredate");
//				System.out.println(eno + " " + ename + " " + job + " " + hrd);

				System.out.printf("%d \t %s \t %s \t %s \n", rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
			}

		} catch (ClassNotFoundException e) {

			System.err.println("드라이버 연결 실패");
		} catch (SQLException e) {
			System.err.println("DB 연동 실패");
		} finally { // 에러유무와는 관계없이 닫을 수 있도록 멤버필드로 선언 후 finally에서 닫아준다.
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println("객체닫기 오류");
			}

		}
	}

}
