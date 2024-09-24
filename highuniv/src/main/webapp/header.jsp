<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style>
            /* font */
            @import url("https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/variable/pretendardvariable-dynamic-subset.css");

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                list-style: none;
                user-select: none;
            }

            div#wrap {
                width: 100%;
                max-width: 2560px;
                /* border: 1px solid red; */
            }

            body {
                background: #EAEAED;
            }

            /* class */
            .pretendard {
                font-family: "Pretendard Variable";
            }

            .clear {
                clear: both;
            }

            .Btn {
                cursor: pointer !important;
            }

            /* header */
            header {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 60px;
                display: flex;
                justify-content: space-between;
                padding-right: 40px;
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
                align-items: center;
                text-align: center;
                /* border: 1px solid red; */
            }

            header .user-box p:first-child {
                display: inline;
                margin: 0 10px;
            }

            header .user-box p {
                font-size: 22px;
            }


            @media screen and (max-width: 425px) {
                header .logo-box {
                    width: 150px;
                }

                header .logo-box p {
                    font-size: 18px;
                }

                header .user-box p:first-child {
                    margin-left: auto;
                }

                header .user-box p {
                    font-size: 16px;
                }
            }
        </style>
    </head>

    <body class="pretendard">
        <div id="wrap">
            <header>
                <!-- 로고 이미지 영역 -->
                <div class="logo-box">
                    <img src="<%= request.getContextPath() %>/public/img/logo.png" alt="로고">
                    <p>하이대학교</p>
                </div>
                <!-- 사용자 영역 -->
                <div class="user-box">
                    <p>
                        <%=session.getAttribute("name")%>님
                    </p>
                    <p class="Btn" onclick="location.href='<%= request.getContextPath() %>/logout';">로그아웃</p>
                </div>
            </header>
            <jsp:include page="aside.jsp" />
    </body>

    </html>