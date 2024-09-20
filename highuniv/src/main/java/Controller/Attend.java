package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendDAO;
import vo.AttendVO;

//@WebServlet("/professor/attend.jsp")
public class Attend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("attend 서블릿 실행");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		AttendDAO attendDAO = new AttendDAO();
		ArrayList<AttendVO> attendList = attendDAO.attendList();
		request.setAttribute("AttendList", attendList);
		RequestDispatcher rd = request.getRequestDispatcher("/professor/attend.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 실행");
//		doGet(request, response);
	}

}
