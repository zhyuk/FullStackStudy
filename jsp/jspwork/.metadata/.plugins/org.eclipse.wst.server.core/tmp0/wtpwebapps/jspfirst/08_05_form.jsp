<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 생성</title>
</head>
<body>
	<form action="08_05_formParameter.jsp" method="post">
	<!-- 	<form action="08_04_requestInfo.jsp?id=admin" method="post"> -->
		<label>이름: <input type="text" name="name" size="30"></label><br>
		<label>주소: <input type="text" name="address" size="30"></label>
		
		<br>좋아하는 동물 :
		<label><input type="checkbox" name="pet" value="dog">강아지</label>
		<label><input type="checkbox" name="pet" value="cat">고양이</label>
		<label><input type="checkbox" name="pet" value="pig">돼지</label>
		
		<br><input type="submit" value="전송">
	</form>
</body>
</html>