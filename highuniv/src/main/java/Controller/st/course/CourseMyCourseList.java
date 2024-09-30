package Controller.st.course;

import java.io.IOException;
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

@WebServlet("/course_register/coursemylist.cl")
public class CourseMyCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("id");
		System.out.println("내수강목록 id : " +login_id);	
	
		ArrayList<CourseVO> myCourseList = new ArrayList<>();
		CourseService courseService = new CourseService();
	
		System.out.println("(수강목록)컨트롤러->서비스호출");
		myCourseList = courseService.myCourseList(login_id);
		System.out.println("(수강목록)서비스다녀옴 myCourseList: " + myCourseList.size());
	
		request.setAttribute("myCourseList", myCourseList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/course_mylist.jsp");

		dispatcher.forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
