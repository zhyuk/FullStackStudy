package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassDAO;
import vo.StudentVO;


@WebServlet("/Mypass")
public class Mypass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");
		 // 입력된 비밀번호를 가져옴
        String inputPassword = request.getParameter("password");
        
       
        PassDAO passDAO = new PassDAO();
        StudentVO user = passDAO.getStudent_id(userId);

        if (user != null) {
            // 데이터베이스의 비밀번호와 입력된 비밀번호 비교
            if (inputPassword.equals(user.getStudent_pw())) {
                // 비밀번호가 일치하면 세션에 인증 정보 저장
                session.setAttribute("authenticated", true);
                
                // 마이페이지로 리다이렉트
                response.sendRedirect("mypage.jsp");
            } else {
                // 비밀번호가 틀리면 에러 메시지를 전달하고 비밀번호 확인 페이지로 리다이렉트
                request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
                request.getRequestDispatcher("my.jsp").forward(request, response);
            }
        } else {
            // 사용자 정보가 없는 경우
            request.setAttribute("errorMessage", "사용자를 찾을 수 없습니다.");
            request.getRequestDispatcher("my.jsp").forward(request, response);
        }
       
    }
}


