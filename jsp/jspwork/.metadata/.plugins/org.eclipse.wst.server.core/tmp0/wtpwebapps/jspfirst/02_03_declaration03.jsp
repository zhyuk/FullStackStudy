<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<%! String makeItLower(String data){
		System.out.println("콘솔창에 출력"); 
		// out.println("콘솔창에 출력"); // 에러. 해당 위치는 자바의 클래스 내부와 동일함. 따라서 body영역에 출력할 수 없음.
		return data.toLowerCase();
	} %>
	<%
		out.println(makeItLower("Hello World"));
	%>
</body>
</html>