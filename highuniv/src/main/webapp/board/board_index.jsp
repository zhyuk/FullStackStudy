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

h2 {
	text-align: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

#main {
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
	padding: 10px 0;
}

#pageList {
	text-align: center;
}

#searchForm {
	text-align: center;
	margin-bottom: 20px;
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
						<tr style="<c:if test='${article.BOARD_NUM == 0}'>font-weight: bold;</c:if>">
							<td>
								<c:choose>
									<c:when test="${article.BOARD_NUM == 0}">
										<div id="main">[공지]</div>
									</c:when>
									<c:otherwise>${article.BOARD_NUM}</c:otherwise>
								</c:choose>
							</td>
							<td style="text-align: left;">
								<a href="boardDetail.bo?board_no=${article.BOARD_NO}&page=${pageInfo.page}">${article.BOARD_SUBJECT}</a>
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

	<br><br>

	<section id="searchForm">
    <form action="boardSearch.bo" method="get"id="searchFoam" name="search-form">
       <select name="type" class="type-box">
            <option value="BOARD_SUBJECT">제목</option>
            <option value="BOARD_CONTENT">내용</option>
            <option value="BOARD_NAME">작성자</option>
            <option value="BOARD_SUBJECT,BOARD_CONTENT">제목 + 내용</option>
        </select>
        <input class="inputId" type="text" name="keyword" placeholder="검색어 입력">
        <input class="submitBtn" type="submit" value="검색">
    </form>
</section>

	
	<section id="pageList">
		<c:choose>
			<c:when test="${pageInfo.page <= 1}">[이전]&nbsp;</c:when>
			<c:otherwise>
				<a href="boardList.bo?page=${pageInfo.page-1}">[이전]</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
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
		<a href="boardWriteForm.bo">글 작성</a>
	</section>

</body>
</html>
