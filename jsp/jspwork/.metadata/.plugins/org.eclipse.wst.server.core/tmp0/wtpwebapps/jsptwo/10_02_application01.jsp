<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page trimDirectiveWhitespaces = "true" %>
<html>
<head>
<meta charset="UTF-8">
<title>로그 메시지 기록</title>
</head>
<body>
	<%-- application 내장 객체에 fruit라는 이름을 가진 속성을 갖고온다. 없으면 null 반환
		=> 서버 실행 후 10_02_application03.jsp 먼저 실행해서 application 내장 객체에 fruit 속성 추가한 뒤 접속하면 null로 출력되던 값이 해당 속성의 값으로 출력됨.
	 --%>
속성 설정 : <%= application.getAttribute("fruit") %>
<%
/* application.log : 
	- System.out.print()와 동일한 기능을 함
*/
application.log("로그 메시지 기록");
%>
로그 메시지를 기록합니다.
</body>
</html>