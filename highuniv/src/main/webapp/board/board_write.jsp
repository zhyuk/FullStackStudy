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

#td_main {
	width: 90%;
	text-align: right;
	font-size: 16pt;
}

input[type=checkbox] {
	transform: scale(1.2);
}

input, textarea {
	font-size: 16pt;
}

.td_right {
	width: 90%;
}

#BOARD_SUBJECT {
	width: calc(100%);
	height: 50px;
	padding: 5px;
	border-radius: 5px;
}

#BOARD_CONTENT {
	width: 100%;
	padding: 5px;
	border-radius: 5px;
}

.filebox {
	width: 100%;
	padding: 5px;
	border-radius: 5px;
	background-color: white;
}


#commandCell {
	text-align: center;
}

#submit {
	display: inline-block;
	background-color: #0B4DA2; /* 파란색 배경 */
	color: white; /* 글자색 흰색 */
	padding: 10px 20px; /* 내부 여백 */
	text-decoration: none; /* 밑줄 제거 */
	border-radius: 5px; /* 둥근 테두리 */
	font-weight: bold; /* 글자 두껍게 */
	border: none;
}

#submit:hover {
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
	cursor: pointer
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
			<input type="hidden" name="BOARD_NAME" value="${sessionScope.name}">
			<input type="hidden" name="BOARD_ID" value="${sessionScope.id}">
			<table>

				<tr>
					<td id="td_main">
					<c:if test="${sessionScope.id==article.BOARD_ID || sessionScope.id=='admin' }">
							<label for="main">공지</label>
							<input type="checkbox" id="main" name="BOARD_MAIN" value="M">
						</c:if>
						</td>
				</tr>
				<tr>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text"
						id="BOARD_SUBJECT" placeholder="제목을 입력해주세요	" required></td>
				</tr>
				<tr>

					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15" placeholder="내용을 입력해주세요" required></textarea></td>
				</tr>
				<tr>
					<td class="td_right">
						<div class="filebox">
							<input name="BOARD_FILE" type="file" id="BOARD_FILE">
						</div>
					</td>
				</tr>
			</table>
			<br>
			<section id="commandCell">
				<input id="submit" type="submit" value="작성완료">&nbsp;&nbsp;
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>