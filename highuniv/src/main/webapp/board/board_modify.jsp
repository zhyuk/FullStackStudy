<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이대학교 게시판</title>
<script type="text/javascript">
function modifyboard() {
    if (document.modifyform.BOARD_SUBJECT.value.trim() === "") {
        alert("제목을 입력해 주세요.");
        return;
    }
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
	font-size: 14pt;
}

#commandCell {
	text-align: center;
}

#commandCell a {
	display: inline-block;
	background-color: #0B4DA2; /* 파란색 배경 */
	color: white; /* 글자색 흰색 */
	padding: 10px 20px; /* 내부 여백 */
	text-decoration: none; /* 밑줄 제거 */
	border-radius: 5px; /* 둥근 테두리 */
	font-weight: bold; /* 글자 두껍게 */
}

#commandCell a:hover {
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<section id="writeForm">
		<h2>게시판글수정</h2>
		<form action="boardModifyPro.bo" method="post" enctype="multipart/form-data" name="modifyform">
			<input type="hidden" name="SESSION_ID" value="${sessionScope.id}">
			<input type="hidden" name="BOARD_NO" value="${article.BOARD_NO}">
			<input type="hidden" name="BOARD_NUM" value="${article.BOARD_NUM}">
			<input type="hidden" name="page" value="${page}">
			<table>
				<tr>
					<td id="td_main">
					<c:if test="${sessionScope.id=='admin'}">
					<label for="main">공지</label>
					<input type="checkbox" id="main" name="BOARD_MAIN" value="M" <c:if test="${article.BOARD_MAIN == 'M'}"> checked </c:if>>
					</c:if>
					</td>
				</tr>
				<tr>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text"
						id="BOARD_SUBJECT" value="${article.BOARD_SUBJECT}">
				</tr>
				<tr>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15">${article.BOARD_CONTENT}</textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<a href="javascript:modifyboard()">수정</a>&nbsp;&nbsp; <a
					href="javascript:history.go(-1)">뒤로</a>
			</section>
		</form>
	</section>
</body>
</html>