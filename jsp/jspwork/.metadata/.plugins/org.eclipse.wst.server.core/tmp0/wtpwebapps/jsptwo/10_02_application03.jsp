<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("abc"); // name = fruit
	if (name != null) application.setAttribute(name, "orange"); // 실행. 속성명 = fruit, 속성값 = orange로 설정함.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 속성 지정</title>
</head>
<body>
	<%	if (name != null) { %>
	
		application 기본 객체의 속성 설정: <%= name %>
		= <%= application.getAttribute(name) %>
	<% } else { %>
		
		application 기본 객체의 속성 설정 안함
		<br> 쿼리스트링으로 추가하고 재실행해주세요.
		<br> 추가할 문자열 : ?abc=fruit
	<% } %>
	
	
	<%--
	request객체 Parameter (get) => String 또는 String[] 자료형으로 반환
	request객체 : 요청에 응답을 완료하거나 리다이렉트를 만나기 전까지 살아있는 객체
	속성명	속성값
	-------------
	abc		fruit
	
	application객체 Attribute영역 => Object 자료형으로 반환(out.print() 기능을 하는 곳에서는 자동으로 문자열로 형 변환되어 출력됨.)
	application객체 : 프로젝트가 실행되는 순간부터 프로젝트가 종료되는 순간까지(=서버가 실행되는 순간부터 서버가 종료될 때까지) 살아있는 객체
	속성명	속성값
	--------------
	fruit	orange
	 --%>
</body>
</html>