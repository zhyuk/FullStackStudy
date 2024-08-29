<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  buffter 기본값 8kb. autoFlush 기본값 true : 버퍼 용량이 넘치면 자동으로 비워줌. -->
<%@ page buffer="1kb" autoFlush="false"%>
<%@ page errorPage = "/error/viewErrorMessage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼 플러시 이후 에러 발생 결과</title>
</head>
<body>
	<%-- jsp 버퍼 오버플로우 오류.  --%>
	<% for(int i = 0; i < 300; i++) { out.println(i); } %>
</body>
</html>