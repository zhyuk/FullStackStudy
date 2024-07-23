package dbc7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionTest {
	Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.Oracle.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TransactionTest tt = new TransactionTest(); // main 메소드는 static 이기 때문에 insert(), connect()로 호출할 수 없음. -> 따라서 지역변수로 나를 인스턴스한 후 메소드 사용
		// static 메소드는 종료될 때까지 메모리에 담겨있어 메모리 낭비
		tt.insert();
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "test", "1111");

			// 자동커밋여부 제어
			con.setAutoCommit(false);
			System.out.println("Connection Success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		connect();
		Statement stmt = null;
		boolean isOrderSuccess = false;
		try {
			System.out.println("1번");
			stmt = con.createStatement();
			String sql = "insert into pay values ('ccc', '001', 1000)";			
			stmt.executeUpdate(sql);
			
			System.out.println("2번");
			sql = "insert into orderList values ('001', 'p2014001')";			
			stmt.executeUpdate(sql);
			
			System.out.println("3번");
			sql = "insert into orderList values ('001', 'p2014001')";			
			stmt.executeUpdate(sql);
			
			System.out.println("4번");
			sql = "insert into pay values('aaa', '001', 1000)";
			stmt.executeUpdate(sql);
			
			System.out.println("5번");
			isOrderSuccess = true;
			System.out.println("6번");
		} catch (Exception e) {
			System.out.println("추가 실패");
			e.printStackTrace();
		} finally {
			if (isOrderSuccess) {
				try {
					con.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					con.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
