<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<%
		// 지역변수들
		int a= 2;
		int b = 3;
		int sum = a + b;
		out.println("2 + 3 = " + sum + "<br>"); // println이라 줄 바꿈되는 것이 아닌, <br> 태그때문에 줄 바꿈되는 것임.
		
		int z = 7;
		out.println("a + z = " + a+z); // 문자열 결합으로 인해 a + z = 27 출력됨.
		out.println("a + z = " + (a+z));
	%>
</body>
</html>