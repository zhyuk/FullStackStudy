package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;

@WebServlet("/StudentModify")
public class StudentModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("StudentModify의 doPost()");
		// 세션에서 사용자 ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		if (userId == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		// 요청 파라미터 가져오기
		String email = request.getParameter("STUDENT_EMAIL");
		String phone = request.getParameter("STUDENT_PH");
		String postcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String comment = request.getParameter("comment");

		Connection con = null;
		try {
			con = util.JdbcUtil.getConnection();
			StudentDAO studentDAO = StudentDAO.getInstance();
			studentDAO.setConnection(con);

			// 업데이트할 필드들을 담을 Map 또는 VO 객체 생성
			Map<String, String> updateFields = new HashMap<>();

			if (email != null && !email.trim().isEmpty()) {
				updateFields.put("STUDENT_EMAIL", email.trim());
			}
			if (phone != null && !phone.trim().isEmpty()) {
				updateFields.put("STUDENT_PH", phone.trim());
			}
			if (postcode != null && !postcode.trim().isEmpty()) {
				// 주소 정보를 하나의 필드로 합쳐서 저장하거나, 각각의 필드로 저장할 수 있습니다.
				String fullAddress = addr1 + " " + addr2 + " " + comment;
				updateFields.put("STUDENT_ADDRESS", fullAddress.trim());
			}

			// 업데이트할 필드가 있는 경우에만 업데이트 수행
			if (!updateFields.isEmpty()) {
				System.out.println("11111");
				boolean updateSuccess = studentDAO.updateStudentInfo(userId, updateFields);
				if (updateSuccess) {
					System.out.println("11111-1");
					response.sendRedirect("mypage.jsp"); // 수정 후 마이페이지로 이동
				} else {
					// 업데이트 실패 처리
					System.out.println("11111-2");
					response.getWriter().println("정보 수정에 실패했습니다.");
				}
			} else {
				System.out.println("22222");
				response.getWriter().println("수정할 정보가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("예외가 발생했습니다.");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (Exception ignore) {}
		}
	}
}
