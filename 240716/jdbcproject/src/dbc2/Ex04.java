package dbc2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex04 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "test";
		String pass = "1111";
		Connection con = null;

		try {
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");

			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연동 성공");

			// DataBaseMetaData는 Connection의 getMetaData()를 이용, instance를 얻고 해당 객체를 이용하여 DBMS에 관련된 사항을 얻을 수 있다.
			DatabaseMetaData data = con.getMetaData();
			System.out.println("1. 데이터베이스 종류 : " + data.getDatabaseProductName());
			System.out.println("2. 데이터베이스 버전정보 : " + data.getDatabaseProductVersion());
			System.out.println("3. 데이터베이스 드라이버명 : " + data.getDriverName());

			System.out.println("4. 데이터베이스 url 정보 : " + data.getURL());
			System.out.println("5. 데이터베이스 연결된 계정정보 : " + data.getUserName());

			// 현재 데이터베이스에서 사용할 수 있는 스키마 이름들(계정명들)을 검색
			ResultSet rs = data.getSchemas();

			while (rs.next()) {
				System.out.println("계정명 : " + rs.getString(1));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
