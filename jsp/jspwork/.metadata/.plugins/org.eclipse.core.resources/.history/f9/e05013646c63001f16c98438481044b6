<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String lang = "kor";

String greeting = "";
String tagline = "";

if (lang.equals("eng")) {
	greeting = "Welcome to Web Shopping Mall";
	tagline = "welcome to Web Market!";
} else {
	greeting = "쇼핑몰에 오신 것을 환영합니다.";
	tagline = "웹 마켓 쇼핑몰!!!";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Welcome</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./05_01_welcome.jsp">Home</a>
			</div>
		</div>
	</nav>
	<%-- <%!
	String greeting = "Welcome to Web Shopping Mall";
	String tagline = "welcome to Web Market!";
	--%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				<%=greeting%>
			</h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3>
				<%=tagline%>
			</h3>
		</div>
		<hr>
	</div>
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
</body>
</html>