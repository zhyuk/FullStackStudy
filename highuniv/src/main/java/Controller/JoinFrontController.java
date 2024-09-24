package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.JoinSVC;
import vo.ProfessorVO;

@WebServlet("/join")
public class JoinFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProfessorVO pvo = new ProfessorVO();
		pvo.setProfessor_id(request.getParameter("id"));
		pvo.setProfessor_pw(request.getParameter("pw"));
		pvo.setProfessor_name(request.getParameter("name"));
		pvo.setProfessor_email(request.getParameter("email"));
		pvo.setProfessor_ph(request.getParameter("phone"));
		
		JoinSVC joinSVC = new JoinSVC();
		int result = joinSVC.insertProf(pvo);
		
		if(result > 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입되었습니다.');");
			out.println("location.href='login.jsp';");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 존재하는 아이디입니다.');");
			out.println("location.href='join.jsp';");
			out.println("</script>");
		}
		
	
	}

}
