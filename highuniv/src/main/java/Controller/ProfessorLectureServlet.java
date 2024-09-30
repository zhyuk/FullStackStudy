package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;
import svc.SubjectService;
import util.JdbcUtil;
import vo.Subject;

@WebServlet("/ProfessorLectureServlet")
public class ProfessorLectureServlet extends HttpServlet {
    private SubjectService subjectService = null;

//    @Override
//    public void init() throws ServletException {
//        try {
//            ServletContext context = getServletContext();
//            Connection conn = (Connection) context.getAttribute("DBConnection");
//            if (conn == null) {
//                // 새로운 DBConnection을 생성하고 ServletContext에 설정
//                conn = JdbcUtil.getConnection();
//                if (conn == null) {
//                    throw new ServletException("DBConnection을 설정할 수 없습니다.");
//                }
//                context.setAttribute("DBConnection", conn);
//                System.out.println("DBConnection을 생성하여 ServletContext에 설정했습니다.");
//            } else {
//                System.out.println("기존의 DBConnection을 사용합니다.");
//            }
//
//            // SubjectDAO의 싱글턴 인스턴스를 가져오고 연결 설정
//            SubjectDAO subjectDAO = SubjectDAO.getInstance();
//            subjectDAO.setConnection(conn);
//
//            // SubjectService를 SubjectDAO로 초기화
//            subjectService = new SubjectService(subjectDAO);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new ServletException("초기화 중 오류 발생: " + e.getMessage());
//        }
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjectList = null;
        
        try {
            // 데이터베이스에서 강의 목록 가져오기
        	subjectService = new SubjectService();
            subjectList = subjectService.getAllSubjects();

            System.out.println("강의 목록: " + subjectList);
        } catch (Exception e) {
            e.printStackTrace();
            subjectList = new ArrayList<>();
            request.setAttribute("errorMessage", "강의 목록을 불러오는 중 오류가 발생했습니다.");
        }

        // JSP에서 사용할 수 있도록 강의 목록을 request에 설정
        request.setAttribute("subjectList", subjectList);

        // 강의 목록 페이지로 이동
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProfessorCourseList.jsp");
        dispatcher.forward(request, response);
    }

    // POST 요청을 처리하여 강의를 삭제합니다.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String subjectId = request.getParameter("subjectId");
        
        System.out.println(subjectId);
        if ("delete".equals(action) && subjectId != null) {
            try {
                // 삭제 로직 수행
            	subjectService = new SubjectService();
                boolean isDeleted = subjectService.deleteSubject(subjectId);
                if (isDeleted) {
                    System.out.println("강의 삭제 성공: " + subjectId);
                } else {
                    System.out.println("강의 삭제 실패: " + subjectId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 삭제 후 다시 강의 목록으로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/ProfessorLectureServlet");
    }
}
