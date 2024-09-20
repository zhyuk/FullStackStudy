package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import vo.ProfessorVO;
import vo.StudentVO;

//@WebServlet("/login")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("로그인");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String role = request.getParameter("role");
//		System.out.println(role);
		HttpSession session = request.getSession();
			
			if(role.equals("professor")) {
				System.out.println("교수 로그인");
				ProfessorVO professorVO = new ProfessorVO();
				professorVO.setProfessor_id(id);
				professorVO.setProfessor_pw(pw);
				LoginDAO loginDAO = new LoginDAO();
				if(loginDAO.IdCheck(professorVO)) {
					System.out.println("로그인 성공");
					session.setAttribute("id", professorVO.getProfessor_id());
					session.setAttribute("pw", professorVO.getProfessor_pw());
					session.setAttribute("name", professorVO.getProfessor_name());
//					System.out.println(session.getAttribute("id"));
					response.sendRedirect("./professor/index.jsp");
				} else {
					System.out.println("로그인 실패");
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('아이디와 비밀번호를 확인해주세요.');");
					out.println("location.href='login.jsp';");
					out.println("</script>");
//					response.sendRedirect("login.jsp");
				}
//				System.out.println("입력한 id : " + professorVO.getProfessor_id());
			} else if (role.equals("student")) {
//				System.out.println("학생 로그인");
				StudentVO studentVO = new StudentVO();
				studentVO.setStudent_id(id);
				studentVO.setStudent_pw(pw);
				LoginDAO loginDAO = new LoginDAO();
				if(loginDAO.IdCheck(studentVO)) {
					System.out.println("로그인 성공");
					session.setAttribute("id", studentVO.getStudent_id());
					session.setAttribute("pw", studentVO.getStudent_pw());
					session.setAttribute("name", studentVO.getStudent_name());
//					System.out.println(session.getAttribute("id"));
					response.sendRedirect("./student/index.jsp");
				} else {
					System.out.println("로그인 실패");
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('아이디와 비밀번호를 확인해주세요.');");
					out.println("location.href='login.jsp';");
					out.println("</script>");
				}
			}
		}
//		doGet(request, response);
//	}

}
