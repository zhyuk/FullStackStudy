<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<script>
	$(document).ready(function() {
		$("#goBack").click(function() {
			history.back();
		});
	});
</script>
<body>
	<div class="jumbotron">
		<h1>에러 400</h1>
	</div>
	<div class="alert alert-danger">
		<strong>런타임에러 발생</strong> <br>런타임에러가 발생되었습니다..
	</div>
	<div id="footer">
		<button type="button" id="goBack" class="btn btn-primary">돌아가기</button>
	</div>
</body>
</html>
