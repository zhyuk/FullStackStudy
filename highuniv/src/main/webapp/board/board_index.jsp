<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>하이대학교 게시판</title>
<style>
* {
	box-sizing: border-box;
}

section > * {
	font-size: 20px;
}

h2 {
	text-align: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

#main, #COMMENT_COUNT {
	color: red;
}

#tr_top {
	border-bottom: 1px solid #0b4da2;
	border-top: 1px solid #0b4da2;
	background-color: aliceblue;
	font-weight: bold;
	text-align: center;
}

table tr {
	border-bottom: 1px solid #ccc;
}

tr td {
	text-align: center;
	height: 50px;
}

#pageList {
	text-align: center;
}

#searchForm {
	text-align: center; /* 검색 폼 전체를 중앙 정렬 */
	margin-bottom: 20px; /* 아래 여백 추가 */
}

#searchForm select, #searchForm input[type="text"], #searchForm input[type="submit"]
	{
	display: inline-block; /* 요소들을 한 줄에 배치 */
	height: 40px;
	margin: 5px; /* 각 요소들 사이의 간격 */
	padding: 8px;
	font-size: 16px;
}

#searchForm input[type="submit"] {
	border-radius: 5px;
	width: 85px;
	background-color: #0B4DA2; /* 파란색 배경 */
	color: white; /* 글자색 흰색 */
	font-weight: bold; /* 글자 두껍게 */
	border: none;
	
}

#searchForm input[type="submit"]:hover {
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
	cursor: pointer
}


.inputId {
	width: 200px; /* 입력 창 너비 */
}

.notice-checkbox {
	display: none;
}

div.notice-buttons {
	text-align: center;
}

input[type="button"], input[type="submit"] {
	display: inline-block;
	margin: 0 10px; /* 두 버튼 사이에 10px 간격 */
}

/* 기존 스타일 유지 */
#commandList {
	text-align: right; /* 오른쪽 정렬 */
	margin-top: 20px; /* 위쪽 여백 */
}

#commandList a {
	display: inline-block;
	background-color: #0B4DA2; /* 파란색 배경 */
	color: white; /* 글자색 흰색 */
	padding: 10px 20px; /* 내부 여백 */
	text-decoration: none; /* 밑줄 제거 */
	border-radius: 5px; /* 둥근 테두리 */
	font-weight: bold; /* 글자 두껍게 */
}

#commandList a:hover {
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
}

a {
	text-decoration: none;
	color: #242424;
}
</style>
</head>

<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<!-- 게시판 리스트 -->
	<h2>게시판</h2>
	<br>



	<section id="listForm">
		<c:choose>
			<c:when test="${ not empty articleList }">
				<table>
					<tr id="tr_top">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
						<td>조회수</td>
					</tr>

					<c:forEach var="article" items="${articleList}">
						<tr
							style="<c:if test='${article.BOARD_NUM == 0}'>font-weight: bold;</c:if>">
							<td><c:choose>
									<c:when test="${article.BOARD_NUM == 0}">
										<div id="main">[공지]</div>
									</c:when>
									<c:otherwise>${article.BOARD_NUM}</c:otherwise>
								</c:choose></td>
							<td style="text-align: left;"><a
								href="boardDetail.bo?board_no=${article.BOARD_NO}&page=${pageInfo.page}">${article.BOARD_SUBJECT}</a>
								<c:if test="${article.COMMENT_COUNT != 0}"><span id="COMMENT_COUNT"> [${article.COMMENT_COUNT}]</span></c:if>
							</td>
							<td>${article.BOARD_NAME}</td>
							<td>${article.BOARD_DATE}</td>
							<td>${article.BOARD_READCOUNT}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<section id="emptyArea">등록된 글이 없습니다.</section>
			</c:otherwise>
		</c:choose>
	</section>

	<br>
	<br>
	<section id="commandList" class="clear">
		<a href="boardWriteForm.bo">글 작성</a>
	</section>

	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.page <= 1}">[이전]&nbsp;</c:when>
			<c:otherwise>
				<a href="boardList.bo?page=${pageInfo.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<c:forEach var="a" begin="${pageInfo.startPage }"
			end="${pageInfo.endPage }" step="1">
			<c:choose>
				<c:when test="${a == pageInfo.page }">
					<span style="color: red; font-weight: bolder;">[${a}]</span>
				</c:when>
				<c:otherwise>
					<a href="boardList.bo?page=${a}">[${a}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${pageInfo.page == pageInfo.maxPage}">[다음]</c:when>
			<c:otherwise>
				<a href="boardList.bo?page=${pageInfo.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>

	</section>
	<br>

	<section id="searchForm">
		<form action="boardSearch.bo" method="get" id="searchFoam"
			name="search-form">
			<select name="type" class="type-box">
				<option value="BOARD_SUBJECT">제목</option>
				<option value="BOARD_CONTENT">내용</option>
				<option value="BOARD_NAME">작성자</option>
				<option value="BOARD_SUBJECT,BOARD_CONTENT">제목 + 내용</option>
			</select> <input class="inputId" type="text" name="keyword"
				placeholder="검색어 입력"> <input class="submitBtn" type="submit"
				value="검색">
		</form>
	</section>
</body>
</html>
