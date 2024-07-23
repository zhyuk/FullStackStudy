package dbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex05 {
	static PreparedStatement ps;
	static ResultSet rs;
	static Connection conn;
	static String tname = "TB_TEST";

	public static int countResult(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) AS CNT FROM USER_TABLES WHERE TABLE_NAME = ?"; // COUNT(*)을 통해 테이블이 없어도 0을 값으로 반환함
		// SELECT * FROM USER_TABLES WHERE TABLE_NAME = ?는 테이블이 없으면 반환하는 값이 없음.
		ps = conn.prepareStatement(sql);
		ps.setString(1, tname);
		rs = ps.executeQuery();

		int cnt = 0;
		while (rs.next()) {
			cnt = rs.getInt("cnt"); // count(*)의 컬럼명을 쉽게 가져오기 위해 sql 문에서 별칭 선언하는 것이 좋다.
		}
		return cnt;
	}

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "test";
			String pass = "1111";

			conn = DriverManager.getConnection(url, id, pass);
			System.out.println("데이터베이스 연결 성공");

			Statement st = conn.createStatement();
			boolean tf = st.execute("select * from dept"); // execute는 쿼리문이 ResultSet 자료형으로 반환될 경우 true, 아닐경우 false;
			if (tf) {
				System.out.println("결과 성공");
			} else {
				System.out.println("결과 실패");
			}

//			String sql = "SELECT COUNT(*) AS CNT FROM USER_TABLES WHERE TABLE_NAME = ?"; // COUNT(*)을 통해 테이블이 없어도 0을 값으로 반환함
//			// SELECT * FROM USER_TABLES WHERE TABLE_NAME = ?는 테이블이 없으면 반환하는 값이 없음.
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, tname);
//			rs = ps.executeQuery();
//
//			int cnt = countResult(conn);
//			while (rs.next()) {
//				cnt = rs.getInt("cnt"); // count(*)의 컬럼명을 쉽게 가져오기 위해 sql 문에서 별칭 선언하는 것이 좋다.
//			}
//
//			if (cnt <= 0) {
////				sql = "CREATE TABLE " + tname + " (TEST1 VARCHAR2(10) PRIMARY KEY, " + "TEST2 NUMBER NOT NULL)";
//				sql = "CREATE TABLE " + tname; // 테이블명, 컬럼명의 경우 동적객체로 처리할 때는 문자열안에 바로 넣으면 안된다. "+ 테이블명을 담은 변수 +" 의 형태로
//												// 기술해야함
//				sql += " (TEST1 VARCHAR2(10) PRIMARY KEY, ";
//				sql += "TEST2 NUMBER NOT NULL)";
//				System.out.println(sql + "문 실행!");
//
//				boolean tf = ps.execute(sql); // 생성 성공은 true 반환, 생성 실패는 false 반환함
//				cnt = countResult(conn);
//
//				if (cnt > 0)
//					System.out.println("테이블 생성 성공");
//				else
//					System.out.println("테이블 생성 실패");
//
//			} else {
//				System.out.println("테이블이 이미 생성되어 있습니다.");
//			}
//
//			rs.close();
//			ps.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("예외: 드라이버 로드 실패" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("예외 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
