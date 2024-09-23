package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.ProfessorVO;

import static util.JdbcUtil.*;

public class JoinDAO {
	private Connection con;
	private PreparedStatement ps;
	private DataSource ds;

	public JoinDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public int insertInfo(ProfessorVO pvo) {

		ps = null;
		int result = 0;
		String sql = "insert into professor (professor_id, professor_pw, professor_name, professor_email, professor_ph) values (?, ?, ?, ?, ?)";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pvo.getProfessor_id());
			ps.setString(2, pvo.getProfessor_pw());
			ps.setString(3, pvo.getProfessor_name());
			ps.setString(4, pvo.getProfessor_email());
			ps.setString(5, pvo.getProfessor_ph());
			result = ps.executeUpdate();
			
			if(result > 0) {
				commit(con);
				System.out.println("DB입력성공");
			} else {
				rollback(con);
				System.out.println("DB입력실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}
		
		return result;

	}
}
