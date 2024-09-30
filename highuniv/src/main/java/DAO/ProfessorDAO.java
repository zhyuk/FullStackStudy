package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.ProfessorVO;

public class ProfessorDAO {
    private Connection conn;

    public ProfessorDAO(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection 객체가 null입니다.");
        }
        this.conn = conn;
    }

    // 교수 ID로 교수 정보 가져오기
    public ProfessorVO getProfessorById(String professorId) {
        String sql = "SELECT * FROM PROFESSOR WHERE PROFESSOR_ID = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, professorId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	ProfessorVO professor = new ProfessorVO();
                professor.setProfessor_id(rs.getString("PROFESSOR_ID"));
                professor.setProfessor_pw(rs.getString("PROFESSOR_PW"));
                professor.setProfessor_name(rs.getString("PROFESSOR_NAME"));
                professor.setProfessor_email(rs.getString("PROFESSOR_EMAIL"));
                professor.setProfessor_ph(rs.getString("PROFESSOR_PH"));
                professor.setProfessor_status(rs.getString("PROFESSOR_STATUS"));
                return professor;
            } else {
                // 교수 정보가 없을 경우
                System.out.println("해당 ID의 교수를 찾을 수 없습니다: " + professorId);
            }

        } catch (SQLException e) {
            System.err.println("SQL 오류: " + e.getMessage());
            // 로그를 사용하여 예외 기록
            // Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return null; // 교수 정보가 없거나 오류가 발생한 경우 null 반환
    }
}
