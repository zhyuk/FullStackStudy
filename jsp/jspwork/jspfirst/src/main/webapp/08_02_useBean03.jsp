<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<%-- <%@ page import="com.dto.Person"%> + <% Person person = new Person(); %> --%>
	<%-- <jsp:useBean id="person" class="com.dto.Person"/> --%>
	<jsp:useBean id="person" class="com.dto.Person" scope="request"/> <%-- request 내장 객체에 person 객체가 있으면 그 객체를 가져오고 없으면 객체 생성 --%>
	<p>아이디 : <%= person.getId() %></p>
	<p>이 름 : <%= person.getName() %></p>
</body>
</html>