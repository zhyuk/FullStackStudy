package Controller.st.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.CourseService;

@WebServlet("/course_register/coursedelete.cl")
public class CourseRegisterDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteRegister = 0;
		CourseService registerDelete = new CourseService();
		HttpSession session = request.getSession();
		String studentId = (String) session.getAttribute("id");
		String[] courseId = request.getParameterValues("courseId");
		
		deleteRegister = registerDelete.registerDelete(courseId, studentId);
		
		if(deleteRegister > 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter success = response.getWriter();
			success.println("<script>");
			success.println("alert('수강취소가 완료되었습니다.');");
			success.println("window.location.href ='/highuniv/course_register/coursemylist.cl';");
			success.println("</script>");
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
