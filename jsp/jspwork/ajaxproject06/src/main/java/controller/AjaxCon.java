package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import svc.AjaxSVC;

@WebServlet("/ajaxCon")
public class AjaxCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AjaxSVC svc = new AjaxSVC();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray starr = svc.getStudent();
		response.setContentType("application/x-json; charset=utf-8");
		response.getWriter().print(starr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
