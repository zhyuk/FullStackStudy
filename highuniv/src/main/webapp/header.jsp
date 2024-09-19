<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style>
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
                font-family: "Pretendard Variable";
            }

            /* class */
            .pretendard {}

            .clear {
                clear: both;
            }

            .btn {
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
                background: #0B4DA2;
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
        </style>
    </head>

    <body>
        <div id="wrap">
            <header>
                <!-- 로고 이미지 영역 -->
                <div class="logo-box">
                    <img src="" alt="로고">
                    <p>하이대학교</p>
                </div>
                <!-- 사용자 영역 -->
                <div class="user-box">
                    <p>
                        <%=session.getAttribute("name")%>님
                    </p>
                    <p class="btn" onclick="location.href='<%=request.getContextPath()%>/index.jsp';">로그아웃</p>
                </div>
            </header>
            <%@ include file="aside.jsp"%>
    </body>

    </html>