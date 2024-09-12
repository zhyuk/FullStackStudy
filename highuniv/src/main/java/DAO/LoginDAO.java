package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import VO.ProfessorVO;
import VO.StudentVO;

public class LoginDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource ds;

	// DataSource 초기화
	public LoginDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IdCheck(ProfessorVO pvo) {
		System.out.println("idChk 메소드 실행");
		boolean idChk = false;
		if(pvo.getProfessor_id() == null || pvo.getProfessor_id().equals("")) {
			return idChk;
		}
		
		String sql = "select * from professor where professor_id = ? and professor_pw = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getProfessor_id());
			pstmt.setString(2, pvo.getProfessor_pw());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo.setProfessor_id(rs.getString("professor_id"));
				pvo.setProfessor_pw(rs.getString("professor_pw"));
				pvo.setProfessor_name(rs.getString("professor_name"));
				pvo.setProfessor_email(rs.getString("professor_email"));
				pvo.setProfessor_ph(rs.getInt("professor_ph"));
//				System.out.println("로그인 성공");
				idChk = true;
			} else {
				idChk = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idChk;
	}
	
	public boolean IdCheck(StudentVO svo) {
		System.out.println("idChk 메소드 실행");
		boolean idChk = false;
		if(svo.getStudent_id() == null || svo.getStudent_id().equals("")) {
			return idChk;
		}
		
		String sql = "select * from student where student_id = ? and student_pw = ?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, svo.getStudent_id());
			pstmt.setString(2, svo.getStudent_pw());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				svo.setStudent_id(rs.getString("student_id"));
				svo.setStudent_pw(rs.getString("student_pw"));
				svo.setStudent_name(rs.getString("student_name"));
				svo.setStudent_email(rs.getString("student_email"));
				svo.setStudent_ph(rs.getString("student_ph"));
				System.out.println("로그인 성공");
				idChk = true;
			} else {
				idChk = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idChk;
	}
	
}
