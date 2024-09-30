<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
/* 기본 레이아웃 스타일 */
body {
    font-family: Arial, sans-serif;
    background-color: #f7f7f7;
    margin-top: 0;
    padding: 0;
}

h1 {
    color: #333;
    font-size: 24px;
    margin-bottom: 20px;
    text-align: center;
    margin-top:60px;
    
}

form {
    width: 400px;
    margin: 50px auto;
    background-color: white;
    padding: 30px;
    border: 1px solid #e0e0e0;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

form div {
    margin-bottom: 20px;
}

label {
    display: block;
    font-size: 16px;
    margin-bottom: 5px;
    color: #333;
}

input[type="password"] {
    width: 100%;
    padding: 10px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

input[type="password"]:focus {
    border-color: #ff5050;
    outline: none;
}

#errorMessage {
    color: red;
    margin-top: 10px;
}

/* 버튼 스타일 */
button {
    width: 100%;
    padding: 12px 0;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

button[type="button"] {
    background-color: #f5f5f5;
    color: #333;
    margin-bottom: 10px;
}

button[type="submit"] {
    background-color: #ff5050;
    color: white;
}

button:hover {
    opacity: 0.9;
}

/* 추가 설명 텍스트 */
div {
    text-align: center;
    
}

.comment {
   font-weight:bold;
   font-size:20px;
   

}

.comment1 {
   margin-top:10px;
   

}

span#errorMessage {
    color: red;
}

.ima{
   margin-bottom:20px;

}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
<h1>비밀번호인증</h1>
<img src="./image/password.png" alt="사진" width="100px" class="ima">
<div class="comment">개인 정보 보호를 위해</div>
<span class="comment" style="color:red;">비밀번호</span><span class="commnet">를 한번 더 입력해주세요.</span>
<div class="comment1">비밀번호가 타인에게 노출되지 않도록 항상 주의해주세요.</div>
<form action="Mypass" method="post">
   <div>
        <label for="password"></label>
        <input type="password" id="password" name="password" placeholder="비밀번호">
        <span id="emailErrorMessage" style="display: none; color: red;">비밀번호가 일치하지 않습니다.</span>
        <%
            if (errorMessage != null) {
        %>
        <div style="color:red;"><%= errorMessage %></div>
        <%
            }
        %>
    </div>
    <div>
       <button type="button" onclick="window.location.href='main'">취소</button>
       <button type="submit">확인</button>
    </div>
</form>
<script>
    $(document).ready(function () {
        // 폼의 submit 버튼 클릭 시
        $("form").submit(function (event) {
            // id와 password의 입력값을 가져옴
            
            let passwordValue = $("#password").val();

            // id와 password 값이 빈 문자열이 아닌지 확인
            if (passwordValue === "") {
                // 값이 비어있으면 submit 방지
                event.preventDefault();
                alert("비밀번호를 입력해주세요.");
            }
        });
    });
</script>
<%@ include file="footer.jsp" %>
</body>
</html>