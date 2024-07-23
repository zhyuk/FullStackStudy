package dbc6;

import java.sql.*;

public class LoginSVC {
	Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			con = DriverManager.getConnection(url, "TEST", "1111");
			System.out.println("드라이버 연결 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public User login(String id, String passwd) {
		User user = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connect();
			st = con.createStatement();
			// "select * from member1 where id = '' and passwd ''";
			String sql = "select * from member1 where id = '" + id + "' and  passwd = '" + passwd + "'";
			rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				user = new User(id, passwd, name, age, addr, email);
			}

			/*
			 * PreparedStatement 동적 객체 사용 
			 * sql = * "select * from member1 where id = ? and passwd ?";
			 * ps = con.prepareStatement(sql); ps.setString(1, id); ps.setString(2, passwd); 
			 * rs = ps.executeQuery();
			 * 
			 * if(rs.next()) { String name = rs.getString("name"); int age =
			 * rs.getInt("age"); String addr = rs.getString("addr"); String email =
			 * rs.getString("email"); user = new User(id, passwd, name, age, addr, email); }
			 */

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	// 회원가입 메뉴
	public int insertMember(String id, String passwd, String name) {
		connect();
		PreparedStatement ps = null;
		String sql = "insert into member1 (id, passwd, name) values (?, ?, ?)";
		int cnt = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 회원탈퇴 (Delete)
	public int deleteMember(String id) {
		connect();
		PreparedStatement ps = null;
		String sql = "delete from member1 where id =?";
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
