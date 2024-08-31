<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core 태그</title>
<%
// 가장 좁은 범위, 가장 높은 우선순위
pageContext.setAttribute("name", "홍길동");
request.setAttribute("name", "고희동");
session.setAttribute("name", "둘리");
// 가장 넓은 범위, 가장 낮은 우선순위
application.setAttribute("name", "마이콜");
%>
</head>
<body>
	<%--	
	${} : EL 표기법.
	우선순위가 가장 높은 "홍길동" 적용. 
	--%>  

	name: ${name}<br>
	<!-- c:out을 사용하는 이유 : 보안. [참고] https://2ham-s.tistory.com/274 -->
	
	<h2>c:set태그 - 변수의 값을 설정(setAttribute와 동일한 역할을 한다.)</h2>
	<!-- var="변수명" : 변수 생성, value="값" : 해당 변수의 값을 설정 -->
	<c:set var="num" value="50"/>
<%-- <c:set var="num">50</c:set> <!-- 속성에 value값 기술하지 않으면 시작태그와 종료태그 사이에 작성된 텍스트가 값이 됨.--> --%>
<%-- <c:set var="num" value="50" scope="page"/> <!-- scope="" : 변수의 범위를 지정할 수 있음. --> --%>
	num값은 : ${num}<br><hr>
	
	<h2>c:out태그 - 변수의 값을 출력</h2>
	<!-- default="0" : 기본값 설정. num 변수에 값이 없으면 0 출력됨 -->
	<c:out value="${num}" default="0"/>
	<c:out value="작성자" default="admin"/>
	<c:out value="hello World!!!!!"/><br><hr>
	
	<h2>c:forEach태그 - 반복문 수행</h2>
	범위안에서 반복문을 수행한다. for와 동일한 역할을 한다.<br>
	begin : 초기 값, end : 마지막 값, step : 증감값<br><br>
	
	<c:out value="수식: resNum= {(i + num - 2)%7}"/><br>
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:set var="resNum" value="${(i + num - 2)%7}"/>
		<c:out value="num: ${num}"/>
		<c:out value="i: ${i}"/>
		<c:out value="resNum: ${resNum}"/><br>
	</c:forEach><hr>
	
	<table>
	<!--  var="i" : 변수 i 생성, begin="1" : 변수의 초기값은 1, end="10" :변수가 10이 될 때까지, step="1" : 1씩 증가  -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<tr><td>${i}</td></tr>
	</c:forEach>
<%-- 	<% --%>
<%-- 		for(var i = 1; i <= 10; i++){%> --%>
<!-- <!-- 			i를 jsp 액션태그, jstl 변수 혹은 객체, Attribute로 생성한 것이 아니기 때문에 EL 표기법 사용불가. -->
<%-- 			<tr><td><%= i %></td></tr>  --%>
<%-- 	<%}%> --%>
	</table><br><hr>
	
	<h2>c:if태그- 조건문 수행</h2>
	조건문을 수행한다. if와 동일한 역할을 한다.<br>
	<jsp:useBean id="memberBean" class="com.dto.MemberBean"/>
	<%-- memberBean.name : memberBean 클래스의 getName() 메소드 호출과 동일함. getter메소드의 경우 매개변수가 없기때문에 멤버필드명으로 호출할 수 있다.--%>
	<c:if test="${memberBean.name eq '이루마'}">
		<p>이름은 ${memberBean.name}입니다.</p>
	</c:if><hr>
	
	<h2>c:choose / c:when태그 - 조건문 수행</h2>
	if, else 구문 역할을 한다.<br>
	<c:choose>
		<%-- 
		<c:when> : 조건기술이 필요한 경우 사용. 조건기술 시 test="조건"으로 기술. 가장 첫번째에 작성된 태그는 if, 중간에 있는 태그는 else if
		<c:otherwise> : else와 동일함. 조건기술할 필요가 없다. 
		--%>
		<c:when test="${memberBean.name eq '고길동'}">
			<p>이름은 ${memberBean.name}입니다.</p>
		</c:when>
		<c:when test="${memberBean.name eq '홍길순'}">
			<p>이름은 ${memberBean.name}입니다.</p>
		</c:when>
		<c:otherwise>
			<p>이름은 ${memberBean.name}입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 참고사이트: https://yunamom.tistory.com/179 -->
</body>
</html>