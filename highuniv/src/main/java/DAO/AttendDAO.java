package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import vo.AttendVO;

import static util.JdbcUtil.*;

public class AttendDAO {
	private Connection con;
	private Statement st;
	private DataSource ds;

	public AttendDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AttendVO> attendList() {
		System.out.println("attendList 실행");
		ResultSet result = null;
		ArrayList<AttendVO> AttendList = new ArrayList<AttendVO>();
		AttendVO avo = null;

		String sql = "SELECT a.course_id, s.subject_name, st.student_id, st.student_name, a.status, a.attend_date, a.attend_remarks FROM attend a JOIN course e ON a.course_id = e.course_id JOIN subject s ON e.subject_id = s.subject_id\n"
				+ "JOIN course_register cr ON a.course_id = cr.course_id JOIN student st ON cr.student_id = st.student_id";

		try {
			con = ds.getConnection();
			st = con.createStatement();
			result = st.executeQuery(sql);

			while (result.next()) { // 모든 결과를 처리
				avo = new AttendVO();
				avo.setCourse_id(result.getString("course_id"));
				avo.setAttend_date(result.getString("attend_date"));
				avo.setStatus(result.getString("status"));
				avo.setAttend_remarks(result.getString("attend_remarks"));
				avo.setSubject_name(result.getString("subject_name"));
				avo.setStudent_id(result.getString("student_id"));
				avo.setStudent_name(result.getString("student_name"));

				AttendList.add(avo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return AttendList;
	}

	public int updateAttend(AttendVO avo) {
		PreparedStatement ps = null;
		ResultSet result = null;
		String sql = "";
		int rs = 0;

		sql = "UPDATE ATTEND SET STATUS = ?, ATTEND_REMARKS = ? WHERE STUDENT_ID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, avo.getStatus());
			ps.setString(2, avo.getAttend_remarks());
			ps.setString(3, avo.getStudent_id());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(con);
		}

		return rs;

	}
}
