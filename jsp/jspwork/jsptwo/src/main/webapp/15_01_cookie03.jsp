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
		Cookie[] cookies = request.getCookies();
	
		for(int i = 0; i < cookies.length; i++){
			//쿠키만료시간 설정
			cookies[i].setMaxAge(60*60);
			
			//쿠키삭제. setMaxAge(0) -> 쿠키 만료시간 0으로 설정
// 			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]); // 응답 객체에 다시 쿠키를 추가해야만 변경한게 적용됨. -> 동일한 이름은 덮어쓰기 됨.
		}
		// response.sendRedirect("15_01_cookie02.jsp");
	%>
	<a href="15_01_cookie02.jsp">쿠키 정보 보기</a>
</body>
</html>