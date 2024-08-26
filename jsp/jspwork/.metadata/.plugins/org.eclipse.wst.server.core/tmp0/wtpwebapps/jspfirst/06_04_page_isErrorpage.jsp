<%@ page errorPage="06_05_page_isErrorPage_error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%-- isErrorPage가 없으면 페이지에 대한 에러를 받아올 수 없음. --%>
	<%
	String str = null;
	out.println(str.toString());
	%>
</body>
</html>