<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 에러 코드표 참조 사이트 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
		// 500 : 서버도 모르는 에러, 404 : 요청한 페이지 찾을 수 없음, 200 : 응답 성공
		// 에러를 발생시켜 무슨 에러인지 확인할 수 있음.
			response.sendError(404, "요청 페이지를 찾을 수 없습니다.");
	%>
</body>
</html>