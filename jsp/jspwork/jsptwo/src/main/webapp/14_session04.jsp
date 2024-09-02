<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>----- 세션을 삭제하기 전 -----</h4>
	<%
		String user_id = (String)session.getAttribute("userID");
		String user_pw = (String)session.getAttribute("userPW");
		out.println("설정된 세션 이름 userID : " + user_id + "<br>");
		out.println("설정된 세션 값 userPW : " + user_pw + "<br>");
		
		// 단일 세션 삭제
		session.removeAttribute("userID");
	%>
	
	<h4>----- 세션을 삭제한 후 -----</h4>
	<%
// 		user_id = (String)session.getAttribute("userID");
// 		user_pw = (String)session.getAttribute("userPW");
// 		out.println("설정된 세션 이름 userID : " + user_id + "<br>");
// 		out.println("설정된 세션 값 userPW : " + user_pw + "<br>");

		String name, value;
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()){
			name = en.nextElement();
			value = (String)session.getAttribute(name);
			out.println("설정된 세션명 : " + name + "<br>");
			out.println("설정된 세션값 : " + value + "<br>");
		}
	%>
</body>
</html>