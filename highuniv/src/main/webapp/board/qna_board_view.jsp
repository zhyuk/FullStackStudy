<%@page language="java" contentType="text/html; charset=UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>하이대학교 게시판</title>

				<script>
					function showDiv() {
						document.getElementById("imgDiv").style.display = "block";
					}

					function hideDiv() {
						document.getElementById("imgDiv").style.display = "none";
					}

					function removeCheck() {
						if (confirm("정말 삭제하시겠습니까?") == true) {
							location.href = "boardDelete.bo?board_no=${article.BOARD_NO}&page=${page}";
						} else {
							return false;
						}
					}
				</script>
				<link rel="stylesheet" type="text/css" href="./css/board_view.css">
			</head>

			<body>
				<jsp:include page="../header.jsp"></jsp:include>
				<h2>게 시 판</h2>
				<section id="articleForm">
					<section id="basicInfoArea">
						<h3>${article.BOARD_SUBJECT}</h3>
						<c:if test="${article.BOARD_FILE ne null}">
							첨부파일 : <a href="filedown.bo?fname=${article.BOARD_FILE}">${article.BOARD_FILE}</a>
							<br>
							<a href="javascript:showDiv();">이미지 보기</a>
							<div id="imgDiv" onclick="hideDiv()">
								<img src="/servletproject05/boardUpload/${article.BOARD_FILE}">
							</div>
						</c:if>
					</section>
					<% pageContext.setAttribute("lf", "\n" ); %>
						<section id="articleContentArea">${fn:replace(article.BOARD_CONTENT, lf, "<br>")}</section>

				</section>
				<section id="commandList">
					<a href="boardModifyForm.bo?board_no=${article.BOARD_NO}&page=${page}">
						[수정] </a> <a href="javascript:removeCheck();"> [삭제] </a> <a href="boardList.bo?page=${page}">
						[목록] </a>&nbsp;&nbsp;
				</section>

			</body>

			</html>