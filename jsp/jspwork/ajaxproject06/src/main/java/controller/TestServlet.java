package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String path = uri.substring(ctx.length());

		if (path.equals("/testCon.bo")) {
			System.out.println("uid1 : " + request.getParameter("uid"));
			RequestDispatcher rd = request.getRequestDispatcher("test1.bo");
			rd.forward(request, response);
		} else if (path.equals("/test1.bo")) {
			System.out.println("uid2 : " + request.getParameter("uid"));
			RequestDispatcher rd = request.getRequestDispatcher("test2.bo");
			rd.forward(request, response);
		} else if (path.equals("/test2.bo")) {
			System.out.println("uid3 : " + request.getParameter("uid"));
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
