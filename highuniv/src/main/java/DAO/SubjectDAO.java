package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import vo.Subject;

public class SubjectDAO {
    private static SubjectDAO instance; // 싱글턴 인스턴스를 저장할 정적 변수
    private Connection conn;

    // private 생성자
    private SubjectDAO() {
        // 초기 DB 연결 설정을 하지 않습니다.
        this.conn = null;
    }

    // 싱글턴 인스턴스 반환 메서드
    public static synchronized SubjectDAO getInstance() {
        if (instance == null) {
            instance = new SubjectDAO();
        }
        return instance;
    }

    // Connection 설정 메서드
    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    // Connection 유효성 검사 및 재설정 메서드
    private void checkConnection() throws SQLException {
        if (this.conn == null || this.conn.isClosed()) {
            System.err.println("Connection이 유효하지 않습니다. 새로 설정해야 합니다.");
            throw new SQLException("Connection이 유효하지 않습니다.");
        }
    }
    
    public Subject getSubject(String subject_id) {
      //  String sql = "select* from subject where subject_id= ? ";
        String sql = "SELECT s.SUBJECT_ID, s.SUBJECT_NAME, s.SUBJECT_SEMESTER, s.SUBJECT_CREDIT, " +
                "s.SUBJECT_STARTTIME, s.SUBJECT_ENDTIME, s.SUBJECT_DAY, " +
                "s.PROFESSOR_ID, s.SUBJECT_ROOM, s.SUBJECT_CONTENT, s.IMAGE_NAME, " +
                "p.PROFESSOR_NAME " +
                "FROM SUBJECT s " +
                "JOIN PROFESSOR p ON s.PROFESSOR_ID = p.PROFESSOR_ID where subject_id= ?";
        Subject subject = new Subject();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

            try {
            	checkConnection();
            	pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, subject_id); 
                
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    subject.setSUBJECT_ID(rs.getString("SUBJECT_ID"));
                    subject.setSUBJECT_NAME(rs.getString("SUBJECT_NAME"));
                    subject.setSUBJECT_SEMESTER(rs.getString("SUBJECT_SEMESTER"));
                    subject.setSUBJECT_CREDIT(rs.getInt("SUBJECT_CREDIT"));
                    subject.setSUBJECT_STARTTIME(rs.getString("SUBJECT_STARTTIME"));
                    subject.setSUBJECT_ENDTIME(rs.getString("SUBJECT_ENDTIME"));
                    subject.setSUBJECT_DAY(rs.getString("SUBJECT_DAY"));
                    subject.setPROFESSOR_ID(rs.getString("PROFESSOR_ID"));
                    subject.setPROFESSOR_NAME(rs.getString("PROFESSOR_NAME"));
                    subject.setIMAGE_NAME(rs.getString("IMAGE_NAME"));
                    subject.setSUBJECT_ROOM(rs.getString("SUBJECT_ROOM"));
                    subject.setSUBJECT_CONTENT(rs.getString("SUBJECT_CONTENT"));
                    
                    System.out.println("Fetched subject: " + subject.getSUBJECT_NAME());
                }
            } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println("SQLException: " + e.getMessage());
            }

        return subject;
    }
    
    // 모든 강의 목록을 가져오는 메서드
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT s.SUBJECT_ID, s.SUBJECT_NAME, s.SUBJECT_SEMESTER, s.SUBJECT_CREDIT, " +
                "s.SUBJECT_STARTTIME, s.SUBJECT_ENDTIME, s.SUBJECT_DAY, " +
                "s.PROFESSOR_ID, s.SUBJECT_ROOM, s.SUBJECT_CONTENT, s.IMAGE_NAME, " +
                "p.PROFESSOR_NAME " +
                "FROM SUBJECT s " +
                "JOIN PROFESSOR p ON s.PROFESSOR_ID = p.PROFESSOR_ID";

        try {
            checkConnection(); // 연결 확인

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {


                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setSUBJECT_ID(rs.getString("SUBJECT_ID"));
                    subject.setSUBJECT_NAME(rs.getString("SUBJECT_NAME"));
                    subject.setSUBJECT_SEMESTER(rs.getString("SUBJECT_SEMESTER"));
                    subject.setSUBJECT_CREDIT(rs.getInt("SUBJECT_CREDIT"));
                    subject.setSUBJECT_STARTTIME(rs.getString("SUBJECT_STARTTIME"));
                    subject.setSUBJECT_ENDTIME(rs.getString("SUBJECT_ENDTIME"));
                    subject.setSUBJECT_DAY(rs.getString("SUBJECT_DAY"));
                    subject.setPROFESSOR_ID(rs.getString("PROFESSOR_ID"));
                    subject.setPROFESSOR_NAME(rs.getString("PROFESSOR_NAME"));
                    subject.setIMAGE_NAME(rs.getString("IMAGE_NAME"));
                    subject.setSUBJECT_ROOM(rs.getString("SUBJECT_ROOM"));
                    subject.setSUBJECT_CONTENT(rs.getString("SUBJECT_CONTENT"));

                    System.out.println("Fetched subject: " + subject.getSUBJECT_NAME());
                    subjects.add(subject);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLException: " + e.getMessage());
        }

        return subjects;
    }

    // 강의 추가 메서드
    public boolean addSubject(Subject subject) {
        String sql = "INSERT INTO SUBJECT (SUBJECT_ID, SUBJECT_NAME, SUBJECT_SEMESTER, SUBJECT_CREDIT, " +
                     "SUBJECT_STARTTIME, SUBJECT_ENDTIME, SUBJECT_DAY, PROFESSOR_ID, SUBJECT_ROOM, SUBJECT_CONTENT, IMAGE_NAME) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            checkConnection(); // 연결 확인

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, subject.getSUBJECT_ID());
                pstmt.setString(2, subject.getSUBJECT_NAME());
                pstmt.setString(3, subject.getSUBJECT_SEMESTER());
                pstmt.setInt(4, subject.getSUBJECT_CREDIT());
                pstmt.setString(5, subject.getSUBJECT_STARTTIME());
                pstmt.setString(6, subject.getSUBJECT_ENDTIME());
                pstmt.setString(7, subject.getSUBJECT_DAY());
                pstmt.setString(8, subject.getPROFESSOR_ID());
                pstmt.setString(9, subject.getSUBJECT_ROOM());
                pstmt.setString(10, subject.getSUBJECT_CONTENT());
                pstmt.setString(11, subject.getIMAGE_NAME());

                int result = pstmt.executeUpdate();
                return result > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL 오류: " + e.getMessage());
            return false;
        }
    }

    // 강의 삭제 메서드
    public boolean deleteSubject(String subjectId) {
        String sql = "DELETE FROM SUBJECT WHERE SUBJECT_ID = ?";

        try {
            checkConnection(); // 연결 확인

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, subjectId);
                int result = pstmt.executeUpdate();
                return result > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


//강의 정보 업데이트
public boolean updateSubject(Connection con, Subject subject) {
    String sql = "UPDATE SUBJECT SET SUBJECT_NAME = ?, SUBJECT_CONTENT = ?,"
    		+ " SUBJECT_DAY = ?, SUBJECT_STARTTIME = ?, "
    		+ "SUBJECT_ENDTIME = ?, SUBJECT_CREDIT = ? ,IMAGE_NAME = ? WHERE SUBJECT_ID = ?";
    
    
    
    try (
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, subject.getSUBJECT_NAME());
        pstmt.setString(2, subject.getSUBJECT_CONTENT());
        pstmt.setString(3, subject.getSUBJECT_DAY());
        pstmt.setString(4, subject.getSUBJECT_STARTTIME());
        pstmt.setString(5, subject.getSUBJECT_ENDTIME());
        pstmt.setInt(6, subject.getSUBJECT_CREDIT());
        pstmt.setString(7, subject.getIMAGE_NAME());
        pstmt.setString(8, subject.getSUBJECT_ID());
       
        int rowsAffected = pstmt.executeUpdate();
        System.out.println("업데이트된 행의 수: " + rowsAffected);
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("SQL 오류: " + e.getMessage());
    }
	return false;
}}