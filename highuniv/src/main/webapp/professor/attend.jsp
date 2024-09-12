<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>하이대학교</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/public.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/media.css" type="text/css">


<style>
.inner h1.title {
	text-align: center;
	font-size: 50px;
	font-weight: 600;
}

.inner table {
	width: 100%;
	background: #D9D9D9;
	border-collapse: collapse;
}

.inner table, .inner tr, .inner th {
	border: 1px solid black;
}
</style>
</head>

<body class="pretendard">
	<div id="wrap">
		<!-- 헤더 -->
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
				<p class="btn"
					onclick="location.href='<%=request.getContextPath()%>/index.jsp';">로그아웃</p>
			</div>
		</header>

		<!-- 사이드메뉴바 -->
		<aside>
			<!-- 햄버거 메뉴 -->
			<div class="ham-btn">
				<span></span> <span></span> <span></span>
			</div>
			<nav class="ham-menu">
				<ul>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">강의
						정보</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">수강신청</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">공지사항</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/.jsp';">게시판</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/.jsp';">학생정보</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/attend.jsp';">출석정보</li>
				</ul>
			</nav>
			<nav>
				<ul>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">강의
						정보</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">수강신청</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">공지사항</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">게시판</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/';">학생정보</li>
					<li
						onclick="location.href='<%=request.getContextPath()%>/professor/attend.jsp';">출석정보</li>
				</ul>
			</nav>
		</aside>

		<!-- 콘텐츠영역 -->
		<main>
			<section class="content">
				<!-- 실제 콘텐츠영역 -->
				<div class="inner">
					<h1 class="title">출석정보</h1>
					<table>
						<tr>
							<th>과목명</th>
							<th>학번</th>
							<th>이름</th>
							<th>상태</th>
							<th>비고</th>
						</tr>
					</table>
				</div>
			</section>
		</main>

		<!-- float 클리어 진행 -->
		<div class="clear"></div>

	</div>

	<script src="./js/public.js"></script>
</body>

</html>