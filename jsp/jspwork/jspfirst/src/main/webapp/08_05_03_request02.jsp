<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table{border-collapse: collapse;}
		table, th, td {border: 1px solid #000;}
		th {background-color: #ccc;}
		td, th {padding: 10px 20px;}
	</style>
</head>
<body>
	<%
		String md = request.getMethod(); // 데이터 전송방식. // 개발자도구 network창에서 Request Method:의 값 가져옴.
		String hostValue = request.getHeader("host"); // 개발자도구 network창에서 host:의 값 가져옴.
		String alValue = request.getHeader("accept-language"); // 개발자도구 network창에서 accept-language:의 값 가져옴.
		String cookie = request.getHeader("cookie"); // 개발자도구 network창에서 cookie:의 값 가져옴.
		String cookies = request.getCookies()[0].getValue();
		// request에 유일하게 담아가는 것이 session id임. -> 각 클라이언트의 id값을 담고있음. 개발자도구 Application창에 Cookies에서 확인가능.
	%>
	메소드 : <%= md %><br>
	쿠키 : <%= cookies %><br>
	<table>
		<tr>
			<th>호스트명</th>
			<th>설정된 언어</th>
			<th>쿠키</th>
		</tr>
		<tr>
			<td><%= hostValue %></td>
			<td><%= alValue %></td>
			<td><%= cookie %></td>
		</tr>
	</table>
</body>
</html>