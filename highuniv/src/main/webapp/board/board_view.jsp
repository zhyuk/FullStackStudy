<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이대학교 게시판</title>
<script>
	function hideDiv() {
		document.getElementById("imgDiv").style.display = "none";
	}

	function removeCheck() {
		if (confirm("정말 삭제하시겠습니까?") == true) {
			location.href = "boardDelete.bo?board_no=${article.BOARD_NO}&page=${page}&session_id=${sessionScope.id}";
		} else {
			return false;
		}
	}
	
	function removeComment(commentNo) {
	    if (confirm("정말 삭제하시겠습니까?") == true) {
	        location.href = "commentDelete.bo?board_no=${article.BOARD_NO}&page=${page}&comment_no=" + commentNo + "&comment_id=${sessionScope.id}";
	    } else {
	        return false;
	    }
	}
</script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.link {
	text-decoration: underline;
	color: #005ACD;
}

#articleForm {
	width: 100%;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	padding: 10px;
	margin: 10px;
	position: relative;
	height: 50px;
	text-align: left;
	border-top: solid 2px #000;
	border-bottom: solid 2px #000;
}

#basicInfoArea h3 {
	float: left;
}

#basicInfoArea p {
	float: right;
}

#articleNameArea {
	display: flex;
	align-items: center;
	justify-content: space-between;
	widht: 100%;
	height: 30px;
	margin: 10px;
	padding: 0 10px;
	text-align: right;
	margin-bottom: 0px;
}

#articleNameArea .btn-list {
	display: flex;
}

#articleNameArea .btn-list li {
	margin: 0 5px;
}

#articleContentArea {
	background: #EAEAED;
	padding: 10px;
	margin: 10px;
	min-height: 350px;
	height: fit-content;
	border-top: solid 2px #000;
}

#articleFileArea {
	widht: 100%;
	height: 30px;
	margin: 10px;
	padding: 0 10px;
	text-align: right;
	margin-top: 0px;
}


#commandList {
	margin: auto;
	width: 100%;
	text-align: center;
}

#imgDiv {
	position: absolute;
	top: 0;
	left: 20px;
	width: 90%;
	height: 250px;
	border: 1px solid #ccc;
	border-radius: 8px;
	overflow-y: auto;
	background-color: #fff;
	padding: 0px;
}

#commentsSection {
	margin: 10px;
	border-top: solid 2px #000;
}

#commentsSection .comment {
	margin-top: 10px;
}

#commentsSection .comment div strong {
	
}

#commentsSection .comment div span {
	float: right;
	font-size: 14px;
	color: #242424;
}

#commentsSection .comment div:nth-of-type(2) {
	margin-top: 10px;
	border-bottom: solid 1px #ccc;
}

#commentsSection .comment div p {
	display: inline-block;
	width: calc(100% - 40px);
	margin-bottom: 10px;
}

#commentsSection .comment div button {
	width: 35px;
	float: right;
	border: none;
	cursor: pointer;
}

#comment {
	border: 1px solid #ccc;
	width: 100%;
	height: 100px;
	padding: 10px;
	overflow: auto;
}

#commentwrite {
	display: flex;
	justifiy-content: center;
	width: 100%;
	padding: 10px 0;
	/* 	border: 1px solid #ccc; */
}

#commentwrite strong {
	width: 50px;
	line-height: 60px;
	text-align: center;
}

#commentwrite textarea {
	width: calc(100% - 100px);
	height: 60px;
	padding: 5px;
	border-radius: 5px 0 0 5px;
}

#commentwrite button {
	width: 50px;
	border: 1px solid #242424;
	border-radius: 0 5px 5px 0;
}

img {
	display: block;
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

input, textarea {
	font-size: 16px;
}
</style>


</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<h2>게시판</h2>
	<section id="articleForm">
		<div id="basicInfoArea">
			<h3>${article.BOARD_SUBJECT}</h3>
		</div>
		<div id="articleNameArea">
			<div>${article.BOARD_NAME}</div>
			<div>${article.BOARD_DATE}</div>
		</div>
		<c:if test="${article.BOARD_FILE ne null}">
		<div id="articleFileArea">
		
				<p>
					첨부파일 : <a class="link"
						href="filedown.bo?fname=${article.BOARD_FILE}">${article.BOARD_FILE}</a>
				</p>
			
		</div>
		</c:if>
		<%
		pageContext.setAttribute("lf", "\n");
		%>
		<div id="articleContentArea">
			<c:if test="${article.BOARD_FILE ne null and (fn:endsWith(article.BOARD_FILE, '.jpg') or fn:endsWith(article.BOARD_FILE, '.jpeg') or fn:endsWith(article.BOARD_FILE, '.png') or fn:endsWith(article.BOARD_FILE, '.gif') or fn:endsWith(article.BOARD_FILE, '.bmp'))}">
			<img src="/highuniv/boardUpload/${article.BOARD_FILE}">
			</c:if>
			<p>${fn:replace(article.BOARD_CONTENT, lf, "<br>")}</p>
		</div>

	</section>


	<section id="commentsSection">
		<c:forEach var="comment" items="${commentList}">
			<div class="comment">
				<span style="display: none;">${comment.COMMENT_NO}</span>
				<div>
					<strong>${comment.COMMENT_NAME}</strong> <span>${comment.COMMENT_DATE}</span>
				</div>
				<div>
					<p>${comment.COMMENT_CONTENT}</p>
					<c:if
						test="${sessionScope.id==article.BOARD_ID || sessionScope.id=='admin' }">
						<button onclick="removeComment(${comment.COMMENT_NO})">[삭제]</button>
					</c:if>
				</div>
			</div>
		</c:forEach>

		<form action="commentWrite.bo" method="post" id="commentwrite">
			<input type="hidden" name="COMMENT_ID" value="${sessionScope.id}">
			<input type="hidden" name="COMMENT_NAME" value="${sessionScope.name}">
			<input type="hidden" name="board_no" value="${article.BOARD_NO}">
			<input type="hidden" name="page" value="${param.page}"> <strong>${sessionScope.name}</strong>
			<textarea id="COMMENT_CONTENT" name="COMMENT_CONTENT" required></textarea>

			<button>등록</button>
		</form>
	</section>
	
	<section id="commandList">
		<c:if
			test="${sessionScope.id==article.BOARD_ID || sessionScope.id=='admin' }">
			<a href="boardModifyForm.bo?board_no=${article.BOARD_NO}&page=${page}&session_id=${sessionScope.id}">수정</a>&nbsp;
			<a href="javascript:removeCheck();">삭제</a>&nbsp;
		</c:if>
		<a href="boardList.bo?page=${page}">목록</a>&nbsp;
	</section>
</body>

</html>
