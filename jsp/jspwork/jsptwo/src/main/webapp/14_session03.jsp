<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name, value;
	Enumeration en = session.getAttributeNames();
	int i = 0;
	
	while(en.hasMoreElements()){
		i++;
		// en 객체에 접근해서 다음 요소를 가져옴. toString() : 문자열로 반환. (String 자료형으로 반환)이지만 요소가 null인 경우 에러발생.
// 		name = en.nextElement().toString();
		name = (String)en.nextElement();
		value = session.getAttribute(name).toString();
		out.println("설정된 세션의 속성 이름 [ " + i + "] : " + name + "<br>");
		out.println("설정된 세션의 속성 값 [ " + i + "] : " + value + "<br>");
	}
%>
</body>
</html>