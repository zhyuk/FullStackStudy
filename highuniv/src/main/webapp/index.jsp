<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
 		<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

            section {
                width: 100%;
                height: calc(100vh * 1020 / 1080);
                background: url(./public/img/index-bg.png);
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }

            section .login-box {
                display: flex;
                align-items: center;
                flex-direction: column;
                position: absolute;
                top: 0;
                right: 0;
                width: 500px;
                height: calc(100% - 60px);
                float: right;
                z-index: 5;
                background: rgba(0, 0, 0, 0.6);
            }

            section .login-box img {
                display: block;
                width: 200px;
                margin-top: 150px;
                /* border: solid 1px red; */
            }

            section .login-box .login-btn {
                position: absolute;
                top: 50%;
                left: 50%;
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
                transform: translate(-50%, -50%);
            }

            section .login-box .login-btn:hover {
                background: #0B4DA2;
            }

            footer {
                display: flex;
                justify-content: space-between;
                align-items: center;
                width: 100%;
                height: 60px;
                padding: 0 40px;
                background: #EAEAED;
                font-weight: 600;
            }
            
            @media screen and (max-width: 768px){
            	section .login-box {
            	width: 50%;
            	}
            	
            	section .login-box .login-btn {
            		width: 200px;
            		height: 50px;
            	}
            	
            }
            @media screen and (max-width: 425px){
            	section .login-box {
            		width: 100%;
            		height: calc(100vh - 50px);
            	}
            	
            	section .login-box .login-btn {
            		width: 200px;
            		height: 50px;
            		font-size: 20px;
            	}
            	
            	footer {
            		display:flex;
            		flex-direction: column;
            		height: 50px;
            		padding: 5px 0;
            		font-size: 10px;
            	}
            	
			}
        </style>
    </head>

    <body class="pretendard">
        <div id="wrap">
            <main>
                <section>
                    <div class="login-box">
                        <img src="./public/img/logo-blue.png" alt="로고이미지">
                        <button type="button" class="login-btn btn"
                            onclick="location.href='<%= request.getContextPath() %>/login.jsp';">
                            로그인
                        </button>
                    </div>
                </section>
            </main>
            <footer>
                <p>경기도 안양시 만안구 안양로314번길 10 Tel. 031-447-1414</p>
                <p>Copyright 2024 Team.HI All Rights Reserved.</p>
            </footer>
        </div>
    </body>

    </html>