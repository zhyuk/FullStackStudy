
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

@WebServlet("/course_register/Courselist.cl")
public class CourselistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("id");
		System.out.println("세션값 login : " + login_id);

		ArrayList<CourseVO> courseList = new ArrayList<>();
		CourseService courseService = new CourseService();
		
//		int listcount = 0;
		
		String subjectSearch = request.getParameter("subjectSearch");
		if(subjectSearch == null || subjectSearch.equals("")) subjectSearch = "";
		
		System.out.println(subjectSearch);
		System.out.println("컨트롤러->서비스호출");
		
//		if (subjectSearch == null || subjectSearch.equals("")){
			courseList = courseService.courseArticleList(login_id, subjectSearch);
//		} else {
//			listcount = courseService.searchSubject(subjectSearch); //////////////설명 <- 검색 갯수 구하는 것 같은데 반환받은 listcount 값은 어디에도 쓰이지않음 밑에 print만 출력함
//			courseList = courseService.searchSubjectList(login_id, subjectSearch); //////////////설명 <- 없어도됨
//		}
		
		System.out.println("서비스다녀옴 courseList: " + courseList.size());
//		System.out.println("서비스다녀옴 listcount: " + listcount);
		
		
		request.setAttribute("subjectSearch", subjectSearch);
		request.setAttribute("courseList", courseList);

//		ArrayList<String> courseId = new ArrayList<>();
//		ArrayList<Integer> registrationCount = new  ArrayList<>();
//		
//		for(int i =0 ; i< courseList.size() ; i++) {
//			registrationCount.add(courseService.getCourseRegisterCount(courseList.get(i).getCourseId()));
//		}		

		// CourseService를 통해 등록된 수강생 수 가져오기
//		courseService = new CourseService();
		// 결과를 request 객체에 저장
//		request.setAttribute("registrationCount", registrationCount);

//        request.getRequestDispatcher("/course_register/course_list.jsp").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/course_register/course_list.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/course_list/course_list.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

// 배열의 길이만큼 반복하여 CourseVO 객체를 생성하고 리스트에 추가
//if (courseIds != null) {
//  for (int i = 0; i < courseIds.length; i++) {
//      CourseVO course = new CourseVO();
//
//      course.setCourseId(courseIds[i]);
//      course.setSubjectId(subjectIds[i]);
//      course.setSubjectName(subjectNames[i]);
//      course.setSubjectCredit(Integer.parseInt(subjectCredits[i]));
//      course.setSubjectSemester(subjectSemesters[i]);
//      course.setProfessorName(professorNames[i]);
//      course.setCourseMaxPeople(Integer.parseInt(courseMaxPeoples[i]));
//      course.setCourseStatus(courseStatuses[i]);
//
//      courseList.add(course);
//  }
//}

// 이후 courseList를 request에 담아서 jsp나 다른 페이지로 넘길 수 있음