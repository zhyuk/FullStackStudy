package dbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class Ex03 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "test";
		String password = "1111";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 드라이버 설치
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");
			// DB 연결
			con = DriverManager.getConnection(url, userid, password);
			System.out.println("데이터베이스 연결 성공");

			// 동적쿼리문
			String query = "SELECT empno, ename, hiredate FROM emp WHERE hiredate >= ?";
			// String query = "SELECT empno, ename, to_char(hiredate, 'yyyy-mm-dd') hiredate FROM emp WHERE hiredate >= ?"; 
			// hiredate 컬럼의 자료형을 문자형으로 변환하게 만들어주면 시/분/초 정보 출력되지 않는다. 다만, 컬럼에 꼭 별칭을 지어주고 출력할 때 별칭명을 입력해야 받아올 수 있음.
			// 명령문 객체(동적객체) 생성
			pstmt = con.prepareStatement(query);

			Calendar c = Calendar.getInstance(); // 이 명령문을 실행한 시점(현재)의 년/월/일 시간 등의 정보
//			 c.set(1981,8,28); // 1981년 9월 28일
			Date d = new Date(c.getTimeInMillis()); // c의 자료형을 Date 자료형으로 변환하여 담아둔다.
			//Date d = new Date(81, 8, 8);

			System.out.println("입력한 일자: " + d);
			pstmt.setDate(1, d);
			
			// 자동 형 변환을 이용해 문자열 자료형으로 할 때의 방식
			// pstmt.setString(1, "810928");
			// pstmt.setString(1, "19810928");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String hiredate = rs.getString("hiredate"); // Date 자료형을 String 자료형으로 출력했기 때문에 시/분/초까지 출력됨.
				System.out.println(empno + " " + ename + " " + hiredate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
