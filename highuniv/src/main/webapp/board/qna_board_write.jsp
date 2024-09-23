<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이대학교 게시판</title>
<link rel="stylesheet" type="text/css" href="./css/board_write.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<!-- 게시판 등록 -->

	<section id="writeForm">
		<h2>게시판글등록</h2>
<!-- 		BoardFrontController.java이동 -->
		<form action="boardWritePro.bo" method="post" enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" required>
					<label for="main">공지</label>
					<input type="checkbox" id="main" name="BOARD_MAIN" value="M"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="40" rows="15" required></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_FILE"> 파일 첨부 </label></td>
					<td class="td_right"><input name="BOARD_FILE" type="file" id="BOARD_FILE"></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
			</section>
		</form>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>