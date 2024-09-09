package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import VO.MemberVO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource ds;

	// DataSource 초기화
	public MemberDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean idCheck(MemberVO mv) {
		if (mv.getId() == null || mv.getId().length() == 0) {
			System.out.println("아이디가 없습니다.");
		}
		boolean idchk = false;
		String sql = "select count(*) as result from users where id = ?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mv.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int result = rs.getInt(1);
//				int result = rs.getInt("result");
				if (result > 0)
					idchk = true;
			}
			return idchk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idchk;
	}
}
