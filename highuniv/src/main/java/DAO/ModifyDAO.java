package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import vo.StudentVO;

public class ModifyDAO {
	
	public static ModifyDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private ModifyDAO() {
		
	}
	public static ModifyDAO getInstance(){
		if(instance == null){
			instance = new ModifyDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public int modifyPh(StudentVO ph) {
		pstmt =  null;
		String sql ="";
		int insertCount = 0;
		
		try {
			sql = "UPDATE STUDENT SET STUDENT_PH=? WHERE STUDENT_ID =? ";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ph.getStudent_ph());
			pstmt.setString(2, ph.getStudent_id());
			
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("StudentInsert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	public int modifyEmail(StudentVO email) {
		pstmt =  null;
		String sql ="";
		int insertCount = 0;
		
		try {
			sql = "UPDATE STUDENT SET STUDENT_EMAIL=? WHERE STUDENT_ID =? ";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email.getStudent_email());
			pstmt.setString(2, email.getStudent_id());
			
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("StudentInsert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	public int modifyAddress(StudentVO address) {
		pstmt =  null;
		String sql ="";
		int insertCount = 0;
		
		try {
			sql = "UPDATE STUDENT SET STUDENT_ADDRESS=? WHERE STUDENT_ID =? ";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address.getStudent_address());
			pstmt.setString(2, address.getStudent_id());
			
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("StudentInsert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

}
