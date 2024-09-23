<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>하이대학교 게시판</title>
	<link rel="stylesheet" type="text/css" href="./css/board_modify.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<section id = "writeForm">
<h2>게시판글수정</h2>
<form action="boardModifyPro.bo" method="post" name = "modifyform" >
<input type = "hidden" name = "BOARD_NO" value = "${article.BOARD_NO}">
<input type = "hidden" name = "page" value = "${page }">
<table>
	<tr>
		<td class="td_left">
			<label for = "BOARD_SUBJECT">제 목</label>
		</td>
		<td class="td_right">
			<input name="BOARD_SUBJECT" type="text" id = "BOARD_SUBJECT" value = "${article.BOARD_SUBJECT}">
			<label for="main">공지</label>
			<input type="checkbox" id="main" name="BOARD_MAIN" value="M">
		</td>
	</tr>
	<tr>
		<td class="td_left">
			<label for = "BOARD_CONTENT">내 용</label>
		</td>
		<td>
			<textarea id = "BOARD_CONTENT" name="BOARD_CONTENT" cols="40" rows="15">${article.BOARD_CONTENT}</textarea>
		</td>
	</tr>
</table>
	<section id = "commandCell">
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
	</section>
</form>
</section>
</body>
</html>