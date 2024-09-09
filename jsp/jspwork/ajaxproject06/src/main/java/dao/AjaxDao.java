package dao;

import static util.JdbcUtil.*;
import java.sql.*;
import org.json.simple.*;

public class AjaxDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public JSONArray getStudent() {
		JSONArray starr = null;
		String sql = "select * from member";
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				starr = new JSONArray();
				do {
					JSONObject vo = new JSONObject();
					vo.put("address", rs.getString("address"));
					vo.put("gender", rs.getString("gender"));
					vo.put("id", rs.getString("id"));
					vo.put("name", rs.getString("name"));
					starr.add(vo);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
			close(conn);
		}

		return starr;
	}
}