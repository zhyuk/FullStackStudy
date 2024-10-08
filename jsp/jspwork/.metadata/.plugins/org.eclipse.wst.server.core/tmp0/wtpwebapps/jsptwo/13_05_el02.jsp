<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.Thermometer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 객체의 메소드 호출하기</title>
<%
	Thermometer thermometer = new Thermometer();
	// request 영역 - Attribute 영역에 "t" 이름을 가진 파라미터 생성. 속성값은 Thermometer 클래스 복제본의 주소값
	request.setAttribute("t", thermometer);
%>
</head>
<body>
	<h2>EL로 객체의 메소드 호출하기</h2>
	<!-- 파라미터명도 문자열로 오는 게 아닌 객체처럼 파라미터명.으로 접근 가능 -->
	${t.setCelsius('서울', 27.3)}
	<!-- 매개변수가 있는 경우, t.celsius로 접근 불가함 -->
	서울 온도 : 섭씨 ${t.getCelsius('서울')}도 / 화씨 ${t.getFahrenheit('서울')}
	
	<br>
	정보 : ${t.info}<br>
	테스트 : ${t.str}
</body>
</html>