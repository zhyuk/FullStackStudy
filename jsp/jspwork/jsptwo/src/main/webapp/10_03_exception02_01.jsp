<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="10_03_exception02_02.jsp" %> : 해당 코드가 작성된 페이지에서 에러 발생 시 10_03_exception02_02.jsp 페이지로 이동. 
이동할 때 데이터 전송, URL 변경 안됨. => 포워드 방식으로 페이지 이동 --%>
<%@ page errorPage="10_03_exception02_02.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 처리</title>
</head>
<body>
	<h2>에러 페이지</h2>
	
	<%
		try{%>
		name 파라미터 값 : <%= request.getParameter("name").toUpperCase()%>
	<% }catch(Exception e){%>
		여기서 에러 처리<br>
	 <%}%>
	 
<%-- 	name 파라미터 값 : <%= request.getParameter("name").toUpperCase() %><br><hr> --%>
</body>
</html>