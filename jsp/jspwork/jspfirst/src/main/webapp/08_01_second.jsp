<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<h2>이 파일은 second.jsp입니다.</h2>
	<p>현재 정보는 <%=(new java.util.Date()).toLocaleString() %>입니다.</p>
	<%
	int count = 0;
	out.println(count + "<br>");
	%>
</body>
</html>