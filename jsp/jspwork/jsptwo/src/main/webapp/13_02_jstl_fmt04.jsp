<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> <jsp:useBean id="now" class="java.util.Date"/> </p>
	<!-- ${} 안에 올 수 있는 것들 : jsp 액션태그로 만든 변수나 객체, jstl로 만든 변수나 객체, Attribute로 설정한 변수나 객체 -->
	<p> date: <fmt:formatDate value="${now}" type="date"/></p> <!-- yyyy.MM.DD. -->
	<p> time: <fmt:formatDate value="${now}" type="time"/></p> <!-- 오후 HH:mm:ss -->
	<p> both: <fmt:formatDate value="${now}" type="both"/></p><hr> <!-- date + time -->
	
	<p> short : 
		<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/>
	</p> <!-- yy.MM.DD. 오후 YY:mm -->
	<p> default : 
		<fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default"/>
	</p> <!-- 기본값 -->
	<p> medium : 
		<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/>
	</p> <!-- 기본값과 동일함 -->
	<p> long : 
		<fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/>
	</p> <!-- yyyy년 MM월 dd일 오후 HH시 mm분 ss초 표준시단축형식 -->
	<p> full : 
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
	</p>
	<p> pattern : 
		<fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초 E요일"/>
	</p>
	<p> pattern2 : 
		<fmt:formatDate value="${now}" type="both" pattern="yyyy-MM-dd HH:mm:ss (E)"/>
	</p>
	<p>**formatDate의 pattern은 SimpleDateFormat과 동일함.</p>

</body>
</html>