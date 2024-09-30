package svc;

import java.util.List;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;
import dao.SubjectDAO;
import vo.Subject;

public class SubjectService {
    private SubjectDAO subjectDAO = SubjectDAO.getInstance(); // DAO 인스턴스 초기화

    // 모든 강의 목록 가져오기
    public List<Subject> getAllSubjects() {
        Connection con = getConnection();
        subjectDAO.setConnection(con);
        
        List<Subject> subjectList = subjectDAO.getAllSubjects();
        
        close(con);
        
        return subjectList;
    }

    // 강의 추가 메서드
    public boolean addSubject(Subject subject) {
        Connection con = getConnection();
        SubjectDAO subjectDAO = SubjectDAO.getInstance();
        subjectDAO.setConnection(con);
        
        boolean isAdded = subjectDAO.addSubject(subject);
        
        if (isAdded) {
            commit(con);
        } else {
            rollback(con);
        }
        
        close(con);
        
        return isAdded;
    }
    
    // 강의 수정 메서드 (이미지 포함)
    public boolean updateSubject(Subject subject) {
        Connection con = getConnection();
        SubjectDAO subjectDAO = SubjectDAO.getInstance(); 
        subjectDAO.setConnection(con);

        boolean isUpdated = subjectDAO.updateSubject(con,subject); // DAO의 update 메서드 호출

        if (isUpdated) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return isUpdated;
    }

    // 강의 삭제 메서드
    public boolean deleteSubject(String subjectId) {
        Connection con = getConnection();
        subjectDAO.setConnection(con);
        
        boolean isDeleted = subjectDAO.deleteSubject(subjectId);
        
        if (isDeleted) {
            commit(con);        
        } else {
            rollback(con);
        }
        
        close(con);
        
        return isDeleted;
    }
}