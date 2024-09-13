<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
		<style>
			aside {
				float: left;
				width: 250px;
				height: calc(100vh - 60px);
				background: #444444;
				color: #EAEAED;
				font-weight: 700;
				font-size: 24px;
				position: fixed;
				top: 60px;
				left: 0;
			}

			aside nav {
				width: 100%;
				padding-top: 100px;
			}

			aside ul li {
				width: 100%;
				height: 60px;
				text-align: center;
				line-height: 60px;
				color: #BDBDBD;
			}

			aside ul li.active {
				background: #212121;
				color: #EAEAED;
			}

			aside ul li:hover {
				background: #212121;
				color: #0B4DA2;
			}

			/* === 햄버거 버튼 === (너비가 1549px보다 작을 때만 보여짐.) */
			aside .ham-btn {
				position: relative;
				width: 50px;
				height: 50px;
				text-align: center;
				display: none;
				/* border: 1px solid red; */
			}

			aside .ham-btn span {
				width: 40px;
				height: 5px;
				background: #EAEAED;
				position: absolute;
				top: 50%;
				left: 50%;
				transform: translate(-50%, -50%);
			}

			aside .ham-btn span:nth-child(1) {
				top: 25%;
			}

			aside .ham-btn span:nth-child(3) {
				top: 75%;
			}

			/* 햄버거 메뉴바 */
			aside .ham-menu {
				position: absolute;
				top: 0;
				left: 50px;
				width: 200px;
				padding-top: 0;
				background: #444444;
				display: none;
			}

			/* === 햄버거 기능 종료 === */

			/* main */
			main {
				width: calc(100% - 250px);
				height: 1300px;
				float: right;
				margin: 0 auto;
				border: 1px solid red;

			}

			section>div.inner {
				width: 100%;
				max-width: 1300px;
				height: 1000px;
				margin: 0 auto;
				padding-top: 130px;
				border: 1px solid red;
			}

			/* 너비가 1549px일 때까지만 적용 */
			@media screen and (max-width: 1549px) {

				/* === 사이드 메뉴바 햄버거 처리 === */
				aside {
					width: 50px;
				}

				aside div.ham-btn {
					display: block;
				}

				aside> :not(.ham-btn):not(.ham-menu) {
					display: none;
				}

				main {
					width: calc(100% - 50px);
				}
			}
		</style>
	</head>

	<body>
		<aside>
			<!-- 햄버거 메뉴 -->
			<div class="ham-btn">
				<span></span> <span></span><span></span>
			</div>
			<nav class="ham-menu">
				<ul>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">강의
						정보</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">수강신청</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">공지사항</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/.jsp';">게시판</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/.jsp';">학생정보</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/attend.jsp';">출석정보</li>
				</ul>
			</nav>
			<nav>
				<ul>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">강의
						정보</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">수강신청</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">공지사항</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">게시판</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/';">학생정보</li>
					<li onclick="location.href='<%=request.getContextPath()%>/professor/attend.jsp';">출석정보</li>
				</ul>
			</nav>
		</aside>
		<script>
			$(function () {
				const hamBtn = $(".ham-btn");
				const hamMenu = $(".ham-menu");
				// console.log(hamBtn);
				// console.log(hamMenu);

				hamBtn.click(() => {
					if (hamMenu.css('display') == 'none') {
						// console.log(hamMenu.css('display'));
						hamMenu.show();
					} else {
						// console.log(hamMenu.css('display'));
						hamMenu.hide();
					}

				});

			});</script>
		<main>
			<section class="content">
				<!-- 실제 콘텐츠영역 -->
				<div class="inner">
	</body>

	</html>