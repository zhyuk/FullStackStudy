package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
//@WebServlet(urlPatterns = "/Consver")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // get 방식은 굳이 인코딩타입 안맞춰도 됨.
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter(); // response.getWriter() : 바디에 out의 역할을 하는 객체 생성
		out.println("<html>");
		out.println("<head><title>인사</title></head>");
		out.println("<body>");
		out.println("안녕하세요, ");
		out.println(request.getParameter("name"));
		out.println("님");
		out.println("</body></html>");
		out.close(); // 메모리 누수를 막기위해 close 해주는게 좋다.
	}

}