<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
<style>
/* font */
        @import url("https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/variable/pretendardvariable-dynamic-subset.css");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .pretendard {
            font-family: "Pretendard Variable";
        }

        .btn {
            cursor: pointer;
        }

        div#wrap {
            width: 100%;
            max-width: 2560px;
            border: solid 1px red;
        }

        header {
            width: 100%;
            height: 60px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 50px;
            background: aqua;
            color: red;
            font-weight: 600;
        }

        header .logo-box{
            width: 200px;
            height: 100%;
            line-height: 60px;
            border: 1px solid red;
        }

        header .logo-box p {
            display: inline-block;
            margin-left: 30px;
            font-size: 24px;
        }

        section {
            width: 100%;
            height: 600px;
            border: 1px solid red;
        }
</style>
</head>
<body class="pretendard">
    <div id="wrap">
        <header>
            <div class="logo-box">
                <img src="" alt="로고">
                <p>하이대학교</p>
            </div>

            <p class="loginBtn btn" onclick="location.href='<%= request.getContextPath() %>/login.jsp';">
                로그인
            </p>
        </header>
        <main>
            <section>
            </section>
        </main>
    </div>
</body>
</html>