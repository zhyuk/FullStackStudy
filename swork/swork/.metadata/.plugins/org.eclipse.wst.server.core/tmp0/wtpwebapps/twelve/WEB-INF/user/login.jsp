<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
<%@ include file="../../menu.jsp" %>  
	<div class="container" align="center">
		<div class="col-md-4">
			<div class="jumbotron"><h1 class="form-signin-heading">로그인</h1></div>
			<%
				if (request.getAttribute("error")!=null) {
					out.println("<div class='alert alert-danger'>");
					out.println("아이디와 비밀번호를 확인해 주세요");
					out.println("</div>");
				}
			
				if(request.getParameter("result") != null){
					out.println("<script>");
					out.println("alert('회원가입이 되었습니다.');");
					out.println("</script>");
				}
			%>
			<form class="form-signin" action="/login.do" method="post">
				<div class="form-group">
					<label for="inputUserName" class="sr-only">User Name</label> 
					<input	type="text" class="form-control" placeholder="ID" name="id" value="${userVO.id}" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label> 
					<input 	type="password" class="form-control" placeholder="Password" name="password" value="${userVO.password}" required>
				</div>
				<button class="btn btn btn-lg btn-success btn-inline" type="submit">로그인</button>
				<button class="btn btn btn-lg btn-success btn-inline" type="button" onclick="javascript:location.href='/joinForm.do'">회원가입</button>
			</form>
		</div>
	</div>
</body>
</html>