<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<%
	String value = "자바";
	String encodedValue = URLEncoder.encode(value, "UTF-8");
// 	response.sendRedirect("08_06_index.jsp?name" + value);
	response.sendRedirect("08_06_index.jsp?name" + encodedValue);
	/* sendRedirect : 리다이렉트 방식의 페이지 이동방식.
	이동할 페이지를 기술할 때, 현재 url을 기준으로 상대경로로 작성해야 함.
	여기서 "./" = "http://localhost:8090/jspfirst/"를 의미함.
	리다이렉트 방식의 이동이 발생한 경우, request 객체에 저장된 정보들이 다 사라짐.
	리다이렉트 방식은 아스키코드를 벗어난 값은 깨짐.
	페이지 이동이 리다이렉트 방식의 경우, out.print()를 작성하더라도 다 무시되고 페이지 이동이 실행된다. 
	*/
%>