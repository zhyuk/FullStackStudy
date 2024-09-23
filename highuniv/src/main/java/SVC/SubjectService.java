package svc;

import java.util.List;
import java.util.ArrayList;
import dao.SubjectDAO;
import vo.Subject;

public class SubjectService {
    private SubjectDAO subjectDAO;

    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    // 모든 강의 목록 가져오기
    public List<Subject> getAllSubjects() {
        try {
            return subjectDAO.getAllSubjects();
        } catch (Exception e) {
            e.printStackTrace();
            // 예외 발생 시 빈 리스트를 반환하여 NullPointerException 방지
            return new ArrayList<>();
        }
    }

    // 강의 추가 메서드
    public boolean addSubject(Subject subject) {
        return subjectDAO.addSubject(subject);
    }

    // 강의 삭제 메서드
    public boolean deleteSubject(String subjectId) {
        return subjectDAO.deleteSubject(subjectId);
    }
}
