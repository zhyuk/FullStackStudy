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
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		String hobby1 = request.getParameter("hobby1");
		String hobby2 = request.getParameter("hobby2");
		String hobby3 = request.getParameter("hobby3");
		String[] hobby = request.getParameterValues("hobby");
		String comment = request.getParameter("comment");
	%>
    <p>아이디 : <%= id %></p>
    <p>비밀번호 : <%= passwd %></p>
    <p>이름 : <%= name %></p>
    <p>연락처 : <%= phone1 %>-<%= phone2 %>-<%= phone3 %></p>
    <p>성별 : <%= gender %></p>
    <p>취미 : <%= hobby %></p>
    <p>취미(배열 사용 X) : <%= hobby1 %><%= hobby2 %><%= hobby3 %></p>
    <!--  입력창에서 줄 바꿈은 \n 이지만, body에 작성되기 때문에 \n 적용 X. 따라서 replace("\n", "<br>")로 body의 줄 바꿈으로 변경 -->
    <p>가입인사 : <%= comment.replace("\n", "<br>") %> </p>
</body>
</html>