<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>MVC</title>
</head>
<body>
	<!-- get 방식은 쿼리스트링으로 전송하기 때문에 url에 "?name=관리자"가 추가됨-->
	<a href="hello?name=관리자">hello 서블릿 호출하기</a><br><br>

	<!-- action="member" : 서블릿으로 이동 -->
	<form method="post" action="member">
		<p>	아이디 : <input type="text" name="id"></p>
		<p>	비밀번호 : <input type="password" name="password"></p>
		<p>	<input type="submit" value="전송"></p>
	</form>
</body>
</html>