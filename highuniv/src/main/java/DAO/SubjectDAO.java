package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vo.Subject;

public class SubjectDAO {
    private static SubjectDAO instance; // 싱글턴 인스턴스를 저장할 정적 변수
    private Connection conn;

    // private 생성자
    private SubjectDAO() {
        // 기본 생성자
    }

    // 싱글턴 인스턴스 반환 메서드
    public static synchronized SubjectDAO getInstance() {
        if (instance == null) {
            instance = new SubjectDAO();
        }
        return instance;
    }

    public void setConnection(Connection con) {
        this.conn = con;
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

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // 쿼리 실행 시점
            System.out.println("Executing query: " + sql);

            while (rs.next()) {
                Subject subject = new Subject();
                // 쿼리에서 선택된 각 컬럼의 값을 ResultSet에서 가져옴
                subject.setSUBJECT_ID(rs.getString("SUBJECT_ID"));
                subject.setSUBJECT_NAME(rs.getString("SUBJECT_NAME"));
                subject.setSUBJECT_SEMESTER(rs.getString("SUBJECT_SEMESTER"));
                subject.setSUBJECT_CREDIT(rs.getInt("SUBJECT_CREDIT"));
                subject.setSUBJECT_STARTTIME(rs.getString("SUBJECT_STARTTIME"));
                subject.setSUBJECT_ENDTIME(rs.getString("SUBJECT_ENDTIME"));
                subject.setSUBJECT_DAY(rs.getString("SUBJECT_DAY"));
                subject.setPROFESSOR_ID(rs.getString("PROFESSOR_ID"));
                subject.setPROFESSOR_NAME(rs.getString("PROFESSOR_NAME"));
                subject.setIMAGE_NAME(rs.getString("IMAGE_NAME")); // 이미지 이름 추가
                subject.setSUBJECT_ROOM(rs.getString("SUBJECT_ROOM"));
                subject.setSUBJECT_CONTENT(rs.getString("SUBJECT_CONTENT"));

                // 각 행을 가져왔을 때
                System.out.println("Fetched subject: " + subject.getSUBJECT_NAME());
                subjects.add(subject);
            }

            // 쿼리 실행 결과 요약
            System.out.println("Total subjects fetched: " + subjects.size());

        } catch (SQLException e) {
            // 예외 발생 시
            e.printStackTrace();
            System.err.println("SQLException: " + e.getMessage());
        }

        return subjects;
    }

    // 강의 추가 메서드
    public boolean addSubject(Subject subject) {
        String sql = "INSERT INTO SUBJECT (SUBJECT_ID, SUBJECT_NAME, SUBJECT_SEMESTER, SUBJECT_CREDIT, " +
                     "SUBJECT_STARTTIME, SUBJECT_ENDTIME, SUBJECT_DAY, PROFESSOR_ID, SUBJECT_ROOM, SUBJECT_CONTENT) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

            int result = pstmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 강의 삭제 메서드
    public boolean deleteSubject(String subjectId) {
        String sql = "DELETE FROM SUBJECT WHERE SUBJECT_ID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subjectId);
            int result = pstmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
