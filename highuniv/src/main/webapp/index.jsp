<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>하이대학교</title>
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
                /* border: solid 1px red; */
            }

            header {
                width: 100%;
                height: 60px;
                display: flex;
                justify-content: space-between;
/*                 padding-right: 40px; */
                font-weight: 700;
                color: #EAEAED;
                background: #005ACD;
            }

            header .logo-box {
                width: 250px;
                height: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                /* border: 1px solid red; */
            }

            header .logo-box img {
                width: 60px;
                height: 100%;
                /* border: 1px solid red; */
            }

            header .logo-box p {
                display: inline;
                margin-left: 10px;
                font-size: 24px;
            }

            header .user-box {
                width: 200px;
                display: flex;
                padding-left: 45px;
                align-items: center;
                text-align: center;
                /* border: 1px solid red; */
            }

            header .user-box p {
                display: inline;
                margin: 0 10px;
                font-size: 22px;
            }

            header .loginBtn {
                font-size: 20px;
            }

            section {
                width: 100%;
                height: fit-content;
            }

            section .bg-section {
                position: relative;
                width: 100%;
                height: 600px;
                background: url(./public/img/index-bg01.png);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            section .login-box {
                display: flex;
                justify-content: center;
                align-items: center;
                position: absolute;
                top: 0;
                right: 0;
                width: 500px;
                height: 100%;
                float: right;
                z-index: 5;
                background: rgba(0, 0, 0, 0.5);
            }

            section .login-box .login-btn {
                width: 400px;
                height: 100px;
                background: #005ACD;
                color: #EAEAED;
                font-size: 40px;
                font-weight: 600;
                text-align: center;
                vertical-align: middle;
                border-radius: 10px;
                border: none;
            }
            
            section .login-box .login-btn:hover {
            	background: #0B4DA2;
            }

            section .inner {
                width: 1300px;
                margin: 0 auto;
                margin-top: 60px;
            }
            
            footer {
            	position: absolute;
            	bottom: 0;
            	width: 100%;
            	height: 60px;
            	background: #0B4DA2;
            }
        </style>
    </head>

    <body class="pretendard">
        <div id="wrap">
            <header>
                <div class="logo-box">
                    <img src="<%=request.getContextPath()%>/public/img/logo.png" alt="로고">
                    <p>하이대학교</p>
                </div>
                <div class="user-box">
                    <p class="btn" onclick="location.href='<%=request.getContextPath()%>/login.jsp';">로그인</p>
                </div>
            </header>
            <main>
                <section>
                    <div class="bg-section">
                        <div class="login-box">
                            <button type="button" class="login-btn btn"
                                onclick="location.href='<%= request.getContextPath() %>/login.jsp';">
                                로그인
                            </button>
                        </div>
                    </div>
                    <div class="inner">
                    </div>
                </section>
            </main>
            
            <footer>
            </footer>
        </div>
    </body>

    </html>