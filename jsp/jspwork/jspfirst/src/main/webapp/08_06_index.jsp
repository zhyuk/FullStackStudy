<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- sendRedirect를 사용하여 데이터를 보낼 경우, 보내는 곳에서 인코딩은 필요하나 받는 곳에서 디코딩 처리를 하지 않아도 됨. --%>
	인덱스 페이지 : <%= request.getParameter("name") != null ? request.getParameter("name") : "로그인에서 이동 됨." %>

<%-- 	인덱스 페이지 : <%= request.getParameter("name") != null ? URLDecoder.decode(request.getParameter("name")) : "로그인에서 이동 됨." %> --%>
</body>
</html>