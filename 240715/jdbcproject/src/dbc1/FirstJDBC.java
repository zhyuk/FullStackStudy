package dbc1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			Statement st = conn.createStatement();
			// select * from dept --> 대소문자 구별 X
			ResultSet rs = st.executeQuery("select * from dept");
			ResultSet emprs = st.executeQuery("select * from emp where deptno = 10");

			while (rs.next()) { // next() : rs 객체에 다음줄이 있니? 있으면 rs에 데이터를 가져온다.
				// 10 ACCOUNTING NEW YORK
				// 20 RESEARCH DALLAS
				// 30 SALES CHICAGO
				// 40 OPERATIONS BOSTON

				int dno = rs.getInt(1); // 첫번째 칸의 데이터인 deptno의 데이터를 가져온다. --> 나중에 숫자 대신 컬럼명이 올 경우, 대소문자 구별 X
				String dnm = rs.getString(2); // 두번째 컬럼인 dname의 데이터를 가져온다.
				String loc = rs.getString(3); // 세번째 컬럼인 loc의 데이터를 가져온다.
				System.out.println(dno + ", " + dnm + ", " + loc);
			}

			while (emprs.next()) {
				int empno = emprs.getInt(1); // int empno = emprs.getInt("EMPNO");
				String ename = emprs.getString(2); // String ename = emprs.getString("ename");
				String job = emprs.getString(3); // String job = emprs.getString("job");
				int mgr = emprs.getInt(4); // int mgr = emprs.getInt("mgr");
				Date hrd = emprs.getDate(5); // Date hrd = emprs.getDate("hiredate"); // String 자료형으로 가져올 경우 시분초 정보까지
												// 포함. Date는 포함 X
				int sal = emprs.getInt(6); // int sal = emprs.getInt("sal");
				int comm = emprs.getInt(7); // int comm = emprs.getInt("comm");
				int dno = emprs.getInt(8); // int dno = emprs.getInt("deptno");
				String dname = emprs.getString(9); // String dname = emprs.getString("dname");
				System.out.print(empno + ", " + ename + ", " + job + ", " + mgr + ", " + hrd + ", " + sal + ", " + comm
						+ ", " + dno + ", " + dname + "\n");
			}
			rs.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류입니다.");
		} catch (SQLException e) {
			System.out.println("SQL명령 오류 및 Connection객체 오류입니다.");
		}

		// emp 테이블에서 deptno값이 10번인 사람의 정보만 출력하세요.

	} // 메인메소드

}
