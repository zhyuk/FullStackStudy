<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="06_03_page_errorPage_error.jsp" %> <%-- 에러 발생 시 06_03_page_errorPage_error.jsp 파일이 열림. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%
		out.print("에러테스트");
		String str = null;
		
		out.println(str.toString()); // 에러.
	%>
	<%-- 주석처리 --%>
</body>
</html>