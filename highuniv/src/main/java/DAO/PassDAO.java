package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JdbcUtil;
import vo.StudentVO;

public class PassDAO {
	 public StudentVO getStudent_id(String id) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        StudentVO user = null;

	        try {
	            con = JdbcUtil.getConnection(); // 데이터베이스 연결
	            String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                user = new StudentVO();
	                user.setStudent_id(rs.getString("student_id"));
	                user.setStudent_pw(rs.getString("student_pw"));  // 데이터베이스에서 비밀번호 가져옴
	                // 다른 필요한 필드도 추가 가능
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JdbcUtil.close(rs, pstmt, con);
	        }
	        return user;
	    }

}
