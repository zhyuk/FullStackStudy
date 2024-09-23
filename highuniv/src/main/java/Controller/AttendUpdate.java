package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import svc.AttendSVC;
import vo.AttendVO;

//@WebServlet(name = "attendUpdate", urlPatterns = { "/attendUpdate" })
public class AttendUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet 성공");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 성공");
		request.setCharacterEncoding("utf-8");
		String status = request.getParameter("status");
		String comment = request.getParameter("comment");
		String studentId = request.getParameter("studentId");
		String subjectName = request.getParameter("subjectName");

		if (status != null) {
			// 받은 값 처리
			System.out.println("attend: " + status); // attend : 지각
			System.out.println("attend: " + comment); // attend : 사유: 테스트
			System.out.println("attend: " + studentId); // attend : 20240912001
			System.out.println("attend: " + subjectName); // attend : 자바스크립트

			AttendVO avo = new AttendVO();
			avo.setSubject_name(subjectName);
			avo.setStudent_id(studentId);
			avo.setStatus(status);
			avo.setAttend_remarks(comment);

			AttendSVC asvc = new AttendSVC();
			int result = asvc.updateAttend(avo);
			
			if (result > 0) {
				JSONObject jObject = new JSONObject();
				jObject.put("message", "OK");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().println(jObject);
			}
			
			

		}
	}

}
