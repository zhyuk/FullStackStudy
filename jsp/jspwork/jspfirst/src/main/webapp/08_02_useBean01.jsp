<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dto.MemberBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	MemberBean mb = new MemberBean();
	mb.setId(240302001);
	out.print("나이: " + mb.getId() + "<br>");
	%>

	이름: <%=mb.getName()%><br>

	<%-- 1. <%@ page import="java.util.Date"%> --%>
	<%-- 2. <% Date date = new Date(); %> 1.과 2를 줄여놓은 코드가 아래의 코드 한 줄.--%>
	<jsp:useBean id="date" class="java.util.Date"/> <%-- import 공간에 기술해야하는 것을 class에 기술. id에는 객체명 기술. --%>
	<p><% out.print("오늘의 날짜 및 시각"); %></p>
	<p><%=date.toLocaleString() %></p><br><br>
	<hr>
	
	<%-- MemberBean mb = new MemberBean(); +  <%@ page import="com.dto.MemberBean"%> 의 단축--%>
	<jsp:useBean id="memberBean" class="com.dto.MemberBean"/>
	<%
		memberBean.setId(1);
		memberBean.setName("김효진");
		out.print("아이디 : " + memberBean.getId() + "<br>");
		out.print("이름 : " + memberBean.getName());
		
	%>
</body>
</html>