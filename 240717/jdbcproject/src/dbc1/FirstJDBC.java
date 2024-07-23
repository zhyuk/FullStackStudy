package dbc1;

import java.sql.*;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			// 오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");

			// Connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "TEST"; // 대소문자 구별 X
			String pw = "1111";

			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connected Success!");

			// Statement 객체 생성(명령문을 담고 실행할 수 있는 객체 생성)
//			Statement st = conn.createStatement();
			// select * from dept --> 대소문자 구별 X
//			ResultSet rs = st.executeQuery("select * from dept where deptno = 10");
			// Statement 객체인 경우 동일한 쿼리문에 값만 변경되더라도 쿼리문을 또 작성해줘야함 ==> 컴파일 2번으로 메모리 낭비
//			rs = st.executeQuery("select * from dept where deptno = 20"); 
			
			// Statement의 메모리 낭비를 대신할 동적 객체 PreparedStatement 객체로 활용하는 게 좋다.
//			PreparedStatement => prepareStatement()
			PreparedStatement ps = conn.prepareStatement("select * from dept where deptno = ? and dname = ?");
			ps.setInt(1, 20);
			ps.setString(2, "RESEARCH"); // 문자열값은 자동으로 '(작은따옴표)를 붙여나가기 때문에 따로 기술할 필요없음
			ResultSet rs = ps.executeQuery();			

			while (rs.next()) {
				int dno = rs.getInt(1); // 첫번째 칸의 데이터인 deptno의 데이터를 가져온다. --> 나중에 숫자 대신 컬럼명이 올 경우, 대소문자 구별 X
				String dnm = rs.getString(2); // 두번째 컬럼인 dname의 데이터를 가져온다.
				String loc = rs.getString(3); // 세번째 컬럼인 loc의 데이터를 가져온다.
				System.out.println(dno + ", " + dnm + ", " + loc);
			}
			
			ps.setInt(1, 30);
			ps.setString(2, "SALES"); 
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int dno = rs.getInt(1); 
				String dnm = rs.getString(2); 
				String loc = rs.getString(3);
				System.out.println(dno + ", " + dnm + ", " + loc);
			}

			rs.close();
//			st.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류입니다.");
		} catch (SQLException e) {
			System.out.println("SQL명령 오류 및 Connection객체 오류입니다.");
		}

	} // 메인메소드

}
