package dbc1;

import java.sql.*;

public class InsertTest {
	// 멤버필드들
	private Connection con; // null
	private Statement st; // null
	private PreparedStatement pst; // null
	private ResultSet rs; // null

	public static void main(String[] args) {
		new InsertTest(1, "Tom", 100);
		new InsertTest(2, "Javaking", 500);
	}

	// 기타생성자(생성자가 하나라도 있으면 기본생성자는 사라진다. 클래스명과 동일하고 리턴타입이 없으면 생성자임)
	public InsertTest(int empno, String ename, double sal) {
		try {
			User user = new User(); // User 클래스를 사용할 수 있도록 메모리에 할당시켜라는 의미
			Class.forName(user.getDriver());
			con = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());
			System.out.println("DB 연결 성공");

			// insert into emp(empno, ename, sal) values(9999, '홍길동', 5000)
			String sql = "insert into emp(empno, ename, sal)" + " values" + "(" + empno + ",'" + ename + "' ," + sal + ")"; 
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			// insert, update, delete는 executeUpdate() 메소드 : 처리한 행 수 반환(정수값)
			System.out.println("처리된 레코드 개수 : " + result);
			st.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e + " => 드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println(e + "=> Sql 예외");
		} catch (Exception e) {
			System.out.println(e + "=> 일반 예외");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("연결객체닫기 오류");
			}
		}
	}

}
