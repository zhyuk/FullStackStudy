<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ids = request.getParameter("id")!= null ? request.getParameter("id") : "아이디없음";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objectes</title>
</head>
<body>
<!-- 	<form method="get"> -->
	<form action="08_05_01_request01_process.jsp"method="get">
		<p>아 이 디 : <input type="text" name="id" value="<%= ids %>"></p> <!--  admin -->
		<p>비밀번호 : <input type="password" name="passwd"></p> <!--  1234 -->
		<input type="submit" value="전송">
	</form>
	
	<!-- 
		request 객체 -> Parameter 영역 -> get 영역
		속성명(name) 	|  속성값(value)
		--------------------------
			id		|	admin
		  passwd	|   1234
		  
	08_05_01_request01_process.jsp 파일에서 해당 데이터를 가져오는 방법 : request.getParameter("id"); / request.getParameter("passwd");
	 -->
</body>
</html>