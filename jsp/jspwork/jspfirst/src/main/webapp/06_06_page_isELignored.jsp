<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%> <!-- 표현언어를 무시한다는 의미. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%
	request.setAttribute("RequestAttribute", "request 내장 객체");
	%>
	<%-- 2번 줄의 표현언어를 무시한다는 코드를 작성했기 때문에 문자열 그대로 출력됨. --%>
	${RequestAttribute}
</body>
</html>