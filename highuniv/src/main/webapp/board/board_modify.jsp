<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이대학교 게시판</title>
<script type="text/javascript">
	function modifyboard() {
		modifyform.submit();
	}
</script>
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

#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<section id="writeForm">
		<h2>게시판글수정</h2>
		<form action="boardModifyPro.bo" method="post" name="modifyform">
			<input type="hidden" name="SESSION_ID" value="${sessionScope.id}">
			<input type="hidden" name="BOARD_NO" value="${article.BOARD_NO}">
			<input type="hidden" name="page" value="${page}">
			<table>
				<tr>
					<td class="td_left"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text"
						id="BOARD_SUBJECT" value="${article.BOARD_SUBJECT}"> <label
						for="main">공지</label> <input type="checkbox" id="main"
						name="BOARD_MAIN" value="M"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15">${article.BOARD_CONTENT}</textarea></td>
				</tr>
			</table>
			<div id="commandCell">
				<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp; <a
					href="javascript:history.go(-1)">[뒤로]</a>
			</div>
		</form>
	</section>
</body>
</html>