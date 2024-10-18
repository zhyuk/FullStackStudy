<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>

<%@ include file="../../menu.jsp" %>  
	<div class="container" align="center">
		<div class="col-md-10">
			<div class="jumbotron"><h1 class="form-signin-heading">회원가입</h1></div>
			
			<form class="form-signin" action="/join.do" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디 입력" name="id" required autofocus>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호 입력" name="password" required>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름 입력" name="name" required>
				</div>
				<div class="form-group">
					<select class="form-control" name="role" required>
						<option disabled>역할 선택</option>
						<option value="User">사용자</option>
						<option value="Admin">관리자</option>
					</select>
				</div>
				<button class="btn btn btn-lg btn-success btn-inline" type="submit">회원가입</button>
				<button class="btn btn btn-lg btn-success btn-inline" type="button" onclick="javascript:history.back();">취소</button>
			</form>
		</div>
	</div>
</body>
</html>