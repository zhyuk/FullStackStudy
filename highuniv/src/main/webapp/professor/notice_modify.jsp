<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.NoticeBean"%>
<%
	NoticeBean notice = (NoticeBean)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<script type="text/javascript">
	function modifyNotice(){
		modifyform.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="../css/notice_list.css">
<style type="text/css">
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<section id = "writeForm">
<h2>공지사항 수정</h2>
<form action="noticeModifyPro.nt" method="post" name = "modifyform" >
	<input type = "hidden" name = "NOTICE_ID" value = "<%=notice.getNotice_id()%>">
	<input type = "hidden" name = "page" value = "${page}">
	<table>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_WRITER">글쓴이</label>
			</td>
			<td class="td_right">
				<input type = "text" name="NOTICE_WRITER" id = "NOTICE_WRITER" value = "<%=notice.getNotice_writer()%>">
			</td>
		</tr>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_PASS">비밀번호</label>
			</td>
			<td class="td_right">
				<input name="NOTICE_PASS" type="password" id = "NOTICE_PASS">
			</td>
		</tr>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_TITLE">제 목</label>
			</td>
			<td class="td_right">
				<input name="NOTICE_TITLE" type="text" id = "NOTICE_TITLE" value = "<%=notice.getNotice_title()%>">
			</td>
		</tr>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_CONTENT">내 용</label>
			</td>
			<td>
				<textarea id = "NOTICE_CONTENT" name="NOTICE_CONTENT" cols="40" rows="15"><%=notice.getNotice_content()%></textarea>
			</td>
		</tr>
	</table>
		<section id = "commandCell">
				<a href="javascript:modifyNotice()">[수정]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[뒤로]</a>
		</section>
</form>
</section>





</body>
</html>