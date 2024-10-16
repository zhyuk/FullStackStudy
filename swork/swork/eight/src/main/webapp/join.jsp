<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<style>
	.container{
		margin-top: 50px;
	}
</style>
<body>
<%@ include file="menu.jsp" %>  
	<div class="container">
	<h1>회원가입</h1>
	<form action="join.do" method="POST">
	
	<div class="form-group">
	<label for="id">아이디</label>
	<input type="text" id="id" class="form-control" name="id" placeholder="아이디 입력" required>
	</div>
	
	<div class="form-group">
	<label for="password">비밀번호</label>
	<input type="password" id="password" class="form-control" name="password" placeholder="비밀번호 입력" required>
	</div>
	
	<div class="form-group">
	<label for="name">이름</label>
	<input type="text" id="name" class="form-control" name="name" placeholder="이름 입력" required>
	</div>
	
	<div class="form-group">
  	<label for="role">역할</label>
	<select name="role" id="role" class="form-control">
        <option value="Admin">관리자</option>
        <option value="User">사용자</option>
    </select>
    </div>
	
	<div class="form-group">
	<button type="submit" class="btn btn-primary">회원가입</button>
	</div>
	
	</form>
	</div>
</body>
</html>