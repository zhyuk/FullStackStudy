package Controller.st.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CourseService;
import vo.CourseVO;

@WebServlet("/course_register/courseinto.cl")
public class CourseintoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<CourseVO> courseregister = new ArrayList<>();
		CourseService courseService = new CourseService();
		
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("id");
		
		System.out.println(studentId);
		
		if (studentId == null || studentId.isEmpty()) {
			System.out.println("Student ID가 세션에 없습니다. 로그인 필요");
			return;
		} else {
            System.out.println("Student ID: " + studentId);
        }
		
		String[] subjectId = request.getParameterValues("subjectId");
		if (subjectId == null || subjectId.length == 0) {
			// 선택된 과목이 없을 경우 처리 (예: 에러 메시지 출력)
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter fail = response.getWriter();
			fail.println("<script>");
			fail.println("alert('과목을 선택해주세요.');");
			fail.println("location.href='Courselist.cl';");
			fail.println("</script>");
//			request.setAttribute("errorMessage", "No subjects selected.");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/error.jsp");
//			dispatcher.forward(request, response);
			return;
		} else {
			courseregister = courseService.courseRegisterList(subjectId, studentId);
			session.setAttribute("courseregister", courseregister);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter success = response.getWriter();
			success.println("<script>");
			success.println("alert('신청이 완료되었습니다.');");
			success.println("location.href='Courselist.cl';");
			success.println("</script>");
		}
//		System.out.println("컨트롤러에서 서비스 호출");
		// 서비스로 과목 등록을 요청 (studentId와 subjectId 배열을 전달)
		
//		System.out.println(studentId);
//		System.out.println("서비스 다녀옴, 등록된 과목 수: " + courseregister.size());
		
		// 등록된 과목 정보를 세션에 저장
		
//
//		// JSP로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/course_into.jsp");
//		dispatcher.forward(request, response);

//		String value[] = request.getParameterValues("subjectId");
//		System.out.println("value: " + value.length);
//
//		System.out.println("컨트롤러에서 서비스 호출");
//		courseregister = courseService.courseRegisterList(value);
//		System.out.println("서비스 다녀옴" + courseregister.size());
//
//		HttpSession session = request.getSession();
//		session.setAttribute("courseregister", courseregister); // 세션에 저장
//
//		// JSP로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/course_into.jsp");
//		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
