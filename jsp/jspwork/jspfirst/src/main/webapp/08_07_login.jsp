<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// post 방식으로 데이터를 가져올 때 필수작성이긴 하지만, 아스키코드 범위 내의 데이터만 다룰 경우 생략가능.
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("memberId");
	String pw = request.getParameter("memberPass");	
	
	// null값을 처리해줘야할 땐 반드시 가장 먼저 작성해야함. NullPointException 에러를 방지하기 위해서
	if(id != null && id.equals("admin") && pw != null && pw.equals("1234")){
		response.sendRedirect("08_06_index.jsp");
	}else{%>
		<!DOCTYPE html>
		<html><head><title>로그인에 실패</title></head>
		<body>잘못된 아이디입니다.</body>
		</html>
	<%} %>
