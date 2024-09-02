<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>----- 세션 유효 시간 변경 전 -----</h4>
	<%
		// 세션 기본값 1,800초
		int time = session.getMaxInactiveInterval() / 60;
		out.println("세션 유효 시간 : " + time + "분<br>");
	%>
	<h4>----- 세션 유효 시간 변경 후 -----</h4>
	<%
		// 세션 유효시간 설정 60초 = 1분 설정
		// 유효시간 이후 세션 자동 만료됨
		// 세션의 유효시간을 0이나 음수로 설정하면 세션 유효시간이 없는 상태가 됨.
		// 서버가 종료될 때(브라우저가 종료될 때)는 유효시간을 설정해도 세션이 종료됨.
		session.setMaxInactiveInterval(60);
		time = session.getMaxInactiveInterval() / 60;
		out.println("세션 유효 시간 : " + time + "분<br>");
	%>
</body>
</html>