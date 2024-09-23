package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext; // ServletContext 임포트 추가
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;
import svc.SubjectService;
import vo.Subject;

@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
    private SubjectService subjectService;

    public void init() {
        ServletContext context = getServletContext();
        Connection conn = (Connection) context.getAttribute("DBConnection");
        if (conn == null) {
            System.err.println("DBConnection is null in AddSubjectServlet.");
        } else {
            System.out.println("DBConnection successfully retrieved in AddSubjectServlet.");
        }
        // SubjectDAO 객체를 Singleton 패턴으로 가져와서 Connection 설정
        SubjectDAO subjectDAO = SubjectDAO.getInstance();
        subjectDAO.setConnection(conn);

        // SubjectService에 SubjectDAO를 전달하여 초기화
        subjectService = new SubjectService(subjectDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addLecture.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String subject_Id = request.getParameter("subjectId");
        String subject_Name = request.getParameter("subjectName");
        String subject_Semester = request.getParameter("subjectSemester");
        int subject_Credit = Integer.parseInt(request.getParameter("subjectCredit"));
        String subject_StartTime = request.getParameter("subjectStartTime");
        String subject_EndTime = request.getParameter("subjectEndTime");
        String subject_Day = request.getParameter("subjectDay");
        String professor_Id = request.getParameter("professorId");
        String subject_Room = request.getParameter("subjectRoom");
        String subject_Content = request.getParameter("subjectContent");

        Subject subject = new Subject();

        // Subject 객체에 값 설정
        subject.setSUBJECT_ID(subject_Id);
        subject.setSUBJECT_NAME(subject_Name);
        subject.setSUBJECT_SEMESTER(subject_Semester);
        subject.setSUBJECT_CREDIT(subject_Credit);
        subject.setSUBJECT_STARTTIME(subject_StartTime);
        subject.setSUBJECT_ENDTIME(subject_EndTime);
        subject.setSUBJECT_DAY(subject_Day);
        subject.setPROFESSOR_ID(professor_Id);
        subject.setSUBJECT_ROOM(subject_Room);
        subject.setSUBJECT_CONTENT(subject_Content);

        boolean isAdded = subjectService.addSubject(subject);

        if (isAdded) {
            response.sendRedirect("ProfessorLectureList.jsp");
        } else {
            request.setAttribute("errorMessage", "강의 추가에 실패했습니다.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addLecture.jsp");
            dispatcher.forward(request, response);
        }
    }
}
