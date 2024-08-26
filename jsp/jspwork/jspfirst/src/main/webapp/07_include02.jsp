<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
</head>
<body>
	<%-- 07_include02_header.jsp 파일의 코드를 가져와서 해당 위치에 붙여넣기한 후 컴파일 --%>
	<%@ include file="07_include02_header.jsp"%>
	<p> <%-- 07_include02_header.jsp 내부의 코드를 가져와 붙여넣기 때문에 에러 X --%>
		이 사이트 방문은
		<%=pageCount%>번째 입니다.
	</p>
	<p>방문해 주셔서 감사합니다.</p>
	<%-- 07_include02_footer.jsp 파일의 코드를 가져와서 해당 위치에 붙여넣기한 후 컴파일 --%>
	<%@ include file="07_include02_footer.jsp"%>
</body>
</html>