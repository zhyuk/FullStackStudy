<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  선언태그만 제외하고 기술된 자리에 맞춰 인식됨. 선언태그는 마지막에 기술되어도 먼저 컴파일된다. -->
	<%!int data = 50;%>
	<%
		out.print("Value of the variable is : " + data + "<br>"); // 50 출력
	
		String data = "하하하";
		out.print("2_Value of the variable is : " + data); // 하하하 출력
	%>
	<%=data %> <!--  하하하 출력 -->
</body>
</html>