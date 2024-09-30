package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.SubjectDAO;
import util.JdbcUtil;
import vo.Subject;

@WebServlet("/AddSubjectServlet")
@MultipartConfig // 파일 업로드 처리
public class AddSubjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addLecture.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // 폼 데이터 받기
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
        
        System.out.println("폼 데이터 수집 완료: " + subject_Name);
        
        System.out.println("강의 ID: " + subject_Id);
        System.out.println("학기: " + subject_Semester);
        System.out.println("학점: " + subject_Credit);


        
        // 파일 업로드 처리 (강의 이미지)
        Part filePart = request.getPart("lectureImage");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
             
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        filePart.write(uploadPath + File.separator + fileName);
        
        System.out.println("파일 업로드 완료: " + fileName);

        // Subject 객체 생성 및 값 설정
        Subject subject = new Subject();
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
        subject.setIMAGE_NAME(fileName); // 이미지 파일 이름 저장
        
        System.out.println("Subject 객체 생성 완료");

        // DB 연결 설정 및 DAO 사용
        Connection conn = null;
        boolean success = false;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false); // Auto-commit 비활성화

//            if (conn == null) {
//                System.err.println("DB 연결이 설정되지 않았습니다. Connection is null.");
//                throw new NullPointerException("DB 연결이 설정되지 않았습니다.");
//            }

            // DAO 싱글톤 인스턴스 가져오기
            SubjectDAO subjectDAO = SubjectDAO.getInstance();
            // DAO에 Connection 설정
            subjectDAO.setConnection(conn);

            // 강의 추가 메서드 호출
            success = subjectDAO.addSubject(subject);
            
            if (success) {
                
            	conn.commit(); // 트랜잭션 커밋

                List<Subject> subjectList = subjectDAO.getAllSubjects();
                
                System.out.println("Total subjects fetched: " + subjectList.size());
                request.setAttribute("subjectList", subjectList);
            } else {
                conn.rollback(); // 실패 시 롤백
            }

                       
            System.out.println("강의 추가 성공 여부: " + success);
        } catch (Exception e) {
            System.err.println("강의 추가 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 연결 종료
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) { /* Ignored */ }
            }
        }

     // 강의 목록 페이지로 리다이렉트 또는 포워드
        if (success) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ProfessorLectureServlet");
            dispatcher.forward(request, response); // 강의 목록을 전달하면서 페이지로 이동
        } else {
            request.setAttribute("errorMessage", "강의 추가에 실패했습니다.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addLecture.jsp");
            dispatcher.forward(request, response);
        }
    }}

