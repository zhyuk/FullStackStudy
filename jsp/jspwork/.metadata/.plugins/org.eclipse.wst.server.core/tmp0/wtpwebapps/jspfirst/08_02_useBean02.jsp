<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="com.dao.Calculator" %> --%>
<%-- <% Calculator bean = new Calculator(); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<%-- 객체 생성 및 객체 사용의 의미. 자바에서 Bean은 객체를 의미함 --%>
	<jsp:useBean id="bean" class="com.dao.Calculator" />
	<%
	int m = bean.process(5);
	out.print("5의 3제곱 : " + m);
	%>
</body>
</html>