<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	int sum(int a, int b) {
		return a + b;
	}
	%>
	<%
		out.println("2 + 3 = " + sum(2,3)); // println 이지만 줄 바꿈 적용되지 않음. => body태그에 기술되기 때문에 \n 적용 안됨.
	%>
</body>
</html>