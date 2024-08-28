<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파라미터 전송 테스트</h3>
	<p>request객체 표현</p><br>
	jsp:param 액션태그로 전송한 데이터는 request영역을 공유하며,<br>
	데이터 전송은 눈에 보이지는 않지만 쿼리스트링방식처럼 url뒤에 key=value형식으로 붙여 보낸다.<br><br>
	
	<%-- 액션태그 내에 주석 사용하지 X. 주석때문에 에러나는 경우가 있음. --%>
<%-- 	<jsp:include page="08_05_03_requestInfo.jsp"> --%>
<%-- 		<jsp:param name="id" value="admin"/>  --%>
<%-- 		<jsp:param name="name" value='<%= java.net.URLEncoder.encode("관리자") %>'/> --%>
<%-- 	</jsp:include> --%>
<%-- 	<jsp:param name="name" value="관리자"/> -> 받는 곳에서 디코딩 미처리 시 ??? 출력됨. --%>
	
	<jsp:forward page="08_05_03_requestInfo.jsp">
		<jsp:param name="id" value="admin"/>
		<jsp:param name="name" value='<%= java.net.URLEncoder.encode("관리자") %>'/>
	</jsp:forward>	
</body>
</html>