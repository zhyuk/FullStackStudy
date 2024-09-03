<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String memberId = request.getParameter("memberId");
	out.print("memberId: " + memberId + "<br>");
	session.setAttribute("MEMBER", memberId);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 성공<br>
	<a href="<%= request.getContextPath() %>/board/boardList.jsp">게시판 보기</a>
</body>
</html>