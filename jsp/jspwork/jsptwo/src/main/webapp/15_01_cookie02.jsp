<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<%
		// 쿠키는 기본적으로 세션ID를 갖고 있음. => 쿠키는 null이 나올 수 없음
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			out.println("현재 설정된 쿠키의 개수 => " + cookies.length + "<br>");
			out.println("==========================<br>");
			
			for(int i = 0; i < cookies.length; i++){
				out.println("설정된 쿠키의 속성 이름 [ " + i + " ] : " + cookies[i].getName() + "<br>");
				out.println("설정된 쿠키의 속성 값 [ " + i + " ] : " + cookies[i].getValue() + "<br>");
				out.println("------------------------------<br>");
			}
		} else {
			out.print("");
		}
	%>
</body>
</html>