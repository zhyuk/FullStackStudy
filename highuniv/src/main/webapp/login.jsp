<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                list-style: none;
            }

            body {
                background: #EAEAED;
            }

            section {
                width: 600px;
                height: 100vh;
                margin: 0 auto;
                padding: 50px;
                background: #0B4DA2;
                color: #EAEAED;
                font-weight: 700;
                border: 1px solid red;
            }

            section h1 {
                margin-bottom: 140px;
                text-align: center;
                font-size: 50px;
            }

            /* input[type=radio] {
                display: none;
            } */
            input:not([type=radio]) {
                width: 100%;
                height: 60px;
                padding: 0 10px;
                border-radius: 10px;
                border: none;
                font-size: 20px;
            }

            input[type=radio]:checked~label {
                color: red;
            }

            label {
                font-size: 28px;
            }

            button#submitBtn {
                width: 100%;
                height: 100px;
                margin-top: 60px;
                border: none;
                border-radius: 10px;
                font-size: 40px;
                font-weight: 700;
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <div id="wrap">
            <main>
                <section>
                    <h1>하이대학교</h1>

                    <form action="login" method="post">
                        <label for="id">아이디(학번)</label>
                        <input type="text" id="id" name="id">
                        <label for="password">비밀번호</label>
                        <input type="text" id="password" name="password">

                        <ul>
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

                    </form>
                </section>
            </main>
        </div>

        <script>
            $(document).ready(function () {
                // 폼의 submit 버튼 클릭 시
                $("form").submit(function (event) {
                    // id와 password의 입력값을 가져옴
                    let idValue = $("#id").val();
                    let passwordValue = $("#password").val();

                    // id와 password 값이 빈 문자열이 아닌지 확인
                    if (idValue === "" || passwordValue === "") {
                        // 값이 비어있으면 submit 방지
                        event.preventDefault();
                        alert("아이디와 비밀번호를 모두 입력해주세요.");
                    }
                });
            });
        </script>
    </body>

    </html>