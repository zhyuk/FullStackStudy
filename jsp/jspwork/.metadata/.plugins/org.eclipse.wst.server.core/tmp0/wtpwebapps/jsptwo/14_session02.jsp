<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 	요청에 대한 응답완료 시 request 객체는 사라지기 때문에 절대 가져올 수 없음.
	// 	String user_id = request.getParameter("id");
	// 	String user_pw = request.getParameter("passwd");
	
		// String 형 변환이 가능한 이유 : 
		// 형 변환하려는 대상이 변환하고자 하는 자료형을 갖고 있어야 함. => userID 속성이 String 자료형을 갖고 있음.
		String user_id = (String) session.getAttribute("userID");
		String user_pw = (String) session.getAttribute("userPW");
		
		out.println("설정된 세션의 속성 값 [1] : " + user_id + "<br>");
		out.println("설정된 세션의 속성 값 [2] : " + user_pw);
	%>
</body>
</html>