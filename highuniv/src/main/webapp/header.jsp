<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

				a {
					text-decoration: none;
					color: #242424;
				}

				div#wrap {
					width: 100%;
					max-width: 2560px;
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
					padding: 0;
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
					font-weight: 700;
					color: #EAEAED;
					background: #005ACD;
					z-index: 3;
				}

				header .logo-box {
					width: 250px;
					height: 100%;
					/* border: 1px solid red; */
				}

				header .logo-box img {
					width: 60px;
					height: 100%;
					float: left;
					/* border: 1px solid red; */
				}

				header .logo-box p {
					position: absolute;
					top: 50%;
					display: inline;
					margin-left: 10px;
					float: left;
					font-size: 24px;
					transform: translateY(-50%);
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

				header .header-ham-btn {
					position: relative;
					top: 50%;
					right: 10px;
					width: 50px;
					height: 50px;
					text-align: center;
					transform: translate(0, -50%);
					display: none;
				}

				header .header-ham-btn span {
					width: 40px;
					height: 5px;
					background: #EAEAED;
					position: absolute;
					top: 50%;
					left: 50%;
					transform: translate(-50%, -50%);
				}

				header .header-ham-btn span:nth-child(1) {
					top: 25%;
				}

				header .header-ham-btn span:nth-child(3) {
					top: 75%;
				}

				#modal {
					position: absolute;
					top: 60px;
					left: 0;
					width: 100%;
					display: none;
					background: rgba(0, 0, 0, 0.6);
					z-index: 2;
				}

				#modal ul {
					position: absolute;
					width: 100%;
					background: #444444;
					z-index: 3;
				}

				#modal ul li {
					margin: 0 auto;
					padding: 20px 0;
					font-size: 20px;
					font-weight: 700;
					color: #EAEAED;
					text-align: center;
					border: 1px solid #212121;
				}

				#modal button {
					position: absolute;
					top: 346px;
					left: 50%;
					height: 30px;
					font-size: 14px;
					color: #EAEAED;
					font-weight: 700;
					background: none;
					border: none;
					transform: translateX(-50%);
				}



				@media screen and (max-width: 425px) {
					header .logo-box {
						width: 70%;
					}

					header .logo-box p {
						font-size: 18px;
					}

					header .user-box p.Btn {
						display: none;
					}

					header .user-box p:first-child {
						margin-left: auto;
						margin-right: 30px;

					}

					header .user-box p {
						font-size: 16px;
					}

					header .header-ham-btn {
						display: block;
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
					<div class="clear"></div>
					<!-- 사용자 영역 -->
					<div class="user-box">
						<p>
							<%=session.getAttribute("name")%>님
						</p>
						<p class="Btn" onclick="location.href='<%= request.getContextPath() %>/logout';">로그아웃</p>
					</div>

					<div class="header-ham-btn">
						<span></span> <span></span><span></span>
					</div>
				</header>

				<div id="modal">
					<c:choose>
						<c:when test="${sessionScope.role == 'professor'}">
							<ul>
								<li onclick="location.href='<%=request.getContextPath()%>/ProfessorLectureServlet';">
									강의정보</li>
								<li onclick="location.href='<%=request.getContextPath()%>/professor/studentlist.pr';">
									학생정보</li>
								<li onclick="location.href='<%=request.getContextPath()%>/attend';">출석정보</li>
								<li onclick="location.href='<%=request.getContextPath()%>/professor/noticeList.nt';">
									공지사항</li>
								<li onclick="location.href='<%=request.getContextPath()%>/boardList.bo';">게시판</li>
							</ul>

							<button class="Btn"
								onclick="location.href='<%= request.getContextPath() %>/logout';">로그아웃</button>
						</c:when>

						<c:when test="${sessionScope.role == 'student'}">
							<ul>
								<li onclick="location.href='<%=request.getContextPath()%>/mypage.jsp'">내정보</li>
								<li
									onclick="location.href='<%=request.getContextPath()%>/course_register/Courselist.cl';">
									수강신청</li>
								<li onclick="location.href='<%=request.getContextPath()%>/ProfessorLectureServlet';">
									강의정보</li>
								<li onclick="location.href='<%=request.getContextPath()%>/professor/noticeList.nt';">
									공지사항</li>
								<li onclick="location.href='<%=request.getContextPath()%>/boardList.bo';">게시판</li>
							</ul>

							<button class="Btn"
								onclick="location.href='<%= request.getContextPath() %>/logout';">로그아웃</button>
						</c:when>
					</c:choose>
				</div>
				<jsp:include page="aside.jsp" />

				<script>

					$(".header-ham-btn").click(() => {
						const bodyHeight = document.body.scrollHeight;
						const viewHeight = window.innerHeight;
						//             		console.log(bodyHeight);
						//              	console.log(viewHeight);

						window.scrollTo({ top: 0, behavior: 'smooth' });
						if (viewHeight > bodyHeight) {
							$("#modal").height(viewHeight + "px");
						} else {
							$("#modal").height(bodyHeight + "px");
						}
						$("#modal").toggle();
					});
				</script>
		</body>

		</html>