<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${id ne null }">
		${id }님, 환영합니다. <a href = "logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href = "loginForm.html">로그인</a>
	</c:otherwise>
</c:choose>
</body>
</html>





