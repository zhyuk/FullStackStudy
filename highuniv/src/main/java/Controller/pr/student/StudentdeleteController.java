package Controller.pr.student;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import svc.StudentService;

@WebServlet("/professor/student_info/studentdelete.pr")
public class StudentdeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String student_id = request.getParameter("student_id");

		// 삭제 로직 수행
		StudentService studentService = new StudentService();
		int isDeleted = studentService.deleteStudent(student_id);

		if (isDeleted > 0) {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int limit = 10; // 페이지당 표시할 학생 수

			// 삭제 후 남은 총 리스트 수
			int listCount = studentService.studentListCount();

			// 남은 데이터를 기준으로 최대 페이지 계산
			int maxPage = (int) Math.ceil((double) listCount / limit);

			// 현재 페이지가 maxPage보다 크다면 maxPage로 리다이렉트
			if (currentPage > maxPage) {
				currentPage = maxPage;
			}
			HashMap<String , Object> map = new HashMap<String , Object>();
			map.put("currentPage", currentPage);
			
			JSONObject jObject = new JSONObject();
			jObject.put("map", map);
			
			response.setContentType("application/x-json; charset=utf-8");
			response.getWriter().print(jObject); //데이터 보냄
			
		} else {
			response.getWriter().write("삭제 실패");
		}
	}
}
