<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이대학교 게시판</title>
<style>
#registForm {
	width: 100%;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 90%;
}

.td_left {
	width: 50px;
	background: indigo;
	color: white;
	text-align: center;
}

.td_right {
	width: 90%;
	background: skyblue;
}

#BOARD_CONTENT {
	width: 100%;
}

#BOARD_SUBJECT {
	width: 90%;
	margin: 5px;
}

#commandCell {
	text-align: center;
}

#submit {
	width: 80px;
	height: 30px;
	background-color: #333;
	color: white;
	border-radius: 10px;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- 게시판 등록 -->

	<section id="writeForm">
		<h2>게시판글등록</h2>
		<!-- 		BoardFrontController.java이동 -->
		<form action="boardWritePro.bo" method="post" enctype="multipart/form-data" name="boardform">
			<input type="hidden" name="BOARD_NAME" value="${sessionScope.name}" >
			<input type="hidden" name="BOARD_ID" value="${sessionScope.id}" >
			<table>
				<tr>
					<td class="td_left"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" required> 
					<c:if test="${sessionScope.id==article.BOARD_ID || sessionScope.id=='admin' }">
					<label for="main">공지</label> <input type="checkbox" id="main" name="BOARD_MAIN" value="M">
					</c:if>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15" required></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_FILE"> 파일 첨부 </label></td>
					<td class="td_right"><input name="BOARD_FILE" type="file"
						id="BOARD_FILE"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input id="submit" type="submit" value="작성완료">&nbsp;&nbsp;
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>