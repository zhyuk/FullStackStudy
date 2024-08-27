<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="memberBean" class="com.dto.MemberBean" />
	<!--  property : 멤버 변수명을 의미함 -->
	<!-- jsp:setProperty name="객체" property="멤버 변수" value="변경할 값" -> memberBean 객체의 멤버필드 id의 값을 2로 변경 -->
	<%-- <% memberBean.setId(2) %>와 동일한 코드임. --%>
	<jsp:setProperty name="memberBean" property="id" value="2" />


	<%-- <%= "아이디: " + memberBean.getId() %><br>와 동일한 코드임. --%>
	<!-- 	jsp:getProperty name="객체" property="멤버 변수" -> memberBean 객체의 멤버필드 name의 값 *출력*. out.print()의 기능도 갖고 있음.-->
	이름 : <jsp:getProperty name="memberBean" property="name"/><br>
</body>
</html>