<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp 스크립트 태그에는 지시태그를 제외한 모든 곳에 자바 소스코드가 작성되야 한다.
		<%= %> : 표현태그. body에 출력되는 코드를 작성. *세미콜론(;) 기술 시 에러.
	--%>
	<p>
		Today's date:
		<%=new java.util.Date()%></p>
	<%
	// 자바 내부와 동일하기 때문에 // /**/ 주석 사용
	int a = 10;
	int b = 20;
	int c = 30;
	%>
	t( a + b + c %>
	<%-- body에 60 출력 --%>
	<%-- <%= a + b + c %> jsp 주석. 한 줄/여러 줄 동일--%>
	<!-- <p>test1</p> html 주석. 개발자도구에 보여짐. -->
	<%-- <p>test2</p> jsp 주석. 개발자도구에 보여지지 않음. --%>
	<p>test3</p>

</body>
</html>