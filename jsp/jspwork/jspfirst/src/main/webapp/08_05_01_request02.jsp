<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="08_05_01_request02_process.jsp" method="post">
<!-- 	<form method="get"> -->
		<p>아 이 디 : <input type="number" name="id"></p>
		<p>이름 : <input type="text" name="name"></p>
		<!-- 파라미터명이 user_id이고 memberBean 객체의 멤버필드는 id이므로 <jsp:setProperty name="memberBean" property="*"/>로 연결할 수 없음. -->
		<!-- <p>아 이 디 : <input type="number" name="user_id"></p>  -->
		<!-- <p>이름 : <input type="text" name="user_name"></p>  -->

        <p>취미</p>
        <input type="checkbox" name="hobby" value="영화">영화</input>
        <input type="checkbox" name="hobby" value="독서">독서</input>
        <input type="checkbox" name="hobby" value="여행">여행</input>
        
        <!-- 
        request Parameter
        속성명(name)	|	속성값(value)
        ------------------------------------
        id			|	5
        name		|	관리자
        hobby		|	["영화","독서","여행"]
         -->

        <p><input type="submit" value="전송"></p>
    </form>
</body>
</html>