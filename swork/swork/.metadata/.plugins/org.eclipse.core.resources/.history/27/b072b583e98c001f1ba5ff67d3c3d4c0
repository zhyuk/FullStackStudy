<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ include file="header.jsp" %>
<body>
<%!String greeting = "환영합니다";
String tagline = "Welcome to Gesipan!";%>
<div class="jumbotron" style="background-color: #ccc!important;text-align:center;padding-bottom:30px!important">
	<div class="container">
		<h1 class="display-3">
			<%=greeting%> ${board.seq }
		</h1>
		<h3>
			<%=tagline%>
		</h3>
	</div>
</div>

<%@ include file="menu.jsp" %>  
	<div class="container">
		<div class="text-center">
			<%
				Date day = new java.util.Date();
				String am_pm;
				int hour = day.getHours();
				int minute = day.getMinutes();
				int second = day.getSeconds();
				if (hour / 12 == 0) {
					am_pm = "AM";
				} else {
					am_pm = "PM";
					hour = hour - 12;
				}
				String CT = hour + ":" + minute + ":" + second + " " + am_pm;
				out.println("현재 접속  시각: " + CT + "\n");
			%>
		</div>
		<hr>
	</div>	
</body>
</html>