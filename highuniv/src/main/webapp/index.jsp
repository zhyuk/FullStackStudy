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
                list-style: none;
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
                width: 500px;
                height: 100%;
                color: #EAEAED;
                float: right;
                z-index: 5;
                background: rgba(0, 0, 0, 0.6);
            }
            
            section .login-box form {
            	width: 90%;
            	margin: 0 auto;
            }

            section .login-box img {
                display: block;
                width: 200px;
                margin-top: 150px;
                /* border: solid 1px red; */
            }

           section .login-box ul.role {
                width: 100%;
                display: flex;
                margin-top: 30px;
            }

            section .login-box ul.role>li {
                width: 50%;
                height: 50px;
                background: #EAEAED;
                color: #212121;
                text-align: center;
                line-height: 50px;
                border: 1px solid #212121;
            }

            section .login-box ul.role>li:nth-child(1) {
                border-radius: 10px 0 0 10px;
            }

            section .login-box ul.role>li:nth-child(2) {
                border-radius: 0 10px 10px 0;
            }

            section .login-box ul.role>li>label {
                width: 100%;
                display: inline-block;
            }

           	section .login-box input[type=radio] {
                display: none;
            }

            section .login-box input:not([type=radio]) {
                width: 100%;
                height: 50px;
                padding: 0 10px;
                border-radius: 10px;
                border: none;
                font-size: 20px;
            }

            section .login-box input[type=radio]:checked~label {
                color: #005ACD;
            }

            section .login-box label {
                display: inline-block;
                font-size: 24px;
            }

            section .login-box label.password {
                margin-top: 30px;
            }

           section .login-box button#submitBtn {
                width: 100%;
                height: 60px;
                margin-top: 60px;
                background: #005ACD;
                color: #EAEAED;
                font-size: 30px;
                font-weight: 700;
                border: none;
                border-radius: 10px;
                cursor: pointer;
            }

            ul.infoBtn {
                display: flex;
                width: fit-content;
                margin: 0 auto;
                margin-top: 30px;
                font-size: 16px;
            }

            ul.infoBtn>li {
                margin: 0 10px;
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
            	}
            	
            	section .login-box img {
            		margin-top: 50px;
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
                    <form action="login" method="post">
                        <label for="id">아이디(학번)</label>
                        <input type="text" id="id" name="id">
                        <label for="password" class="password">비밀번호</label>
                        <input type="password" id="password" name="password">

                        <ul class="role">
                            <li>
                                <input type="radio" name="role" id="professor" value="professor" checked>
                                <label for="professor">교수</label>
                            </li>
                            <li>
                                <input type="radio" name="role" id="student" value="student">
                                <label for="student">학생</label>
                            </li>
                        </ul>

                        <button type="submit" id="submitBtn">로그인</button>
                        <ul class="infoBtn">
                            <li class="btn">아이디 찾기</li>
                            <li>|</li>
                            <li class="btn">비밀번호 찾기</li>
                            <li>|</li>
                            <li class="btn" onclick="location.href='<%=request.getContextPath()%>/join.jsp';">회원가입</li>
                        </ul>
                    </form>
                    </div>
                    <div class="clear"></div>
                </section>
            </main>
            <footer>
                <p>경기도 안양시 만안구 안양로314번길 10 Tel. 031-447-1414</p>
                <p>Copyright 2024 Team.HI All Rights Reserved.</p>
            </footer>
        </div>
        
        

<!--         <script> -->
//             $(document).ready(function () {
//                 // 폼의 submit 버튼 클릭 시
//                 $("form").submit(function (event) {
//                     // id와 password의 입력값을 가져옴
//                     let idValue = $("#id").val();
//                     let passwordValue = $("#password").val();

//                     // id와 password 값이 빈 문자열이 아닌지 확인
//                     if (idValue === "" || passwordValue === "") {
//                         // 값이 비어있으면 submit 방지
//                         event.preventDefault();
//                         alert("아이디와 비밀번호를 모두 입력해주세요.");
//                     }
//                 });
//             });

<!--         </script> -->
    </body>

    </html>