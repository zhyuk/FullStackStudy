<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- action (데이터 = 파라미터를 보낼 페이지) 
	js, html 모두 경로를 기술할 때 ./, ../가 아닌 /만 기술하면 컨텍스트를 지우라는 의미임. -->
	<form action="08_06_response01_process.jsp" method="post">
	<!-- name속성명 = 파라미터명 / value 속성 = 파라미터값 -->
		<p> 아 이 디 : <input type="text" name="id"></p>
		<p> 비밀번호 : <input type="text" name="passwd"></p>
		<p><input type="submit" value="전송"></p>
	</form>
</body>
</html>