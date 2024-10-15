<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajax Test</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<style>
		table {border-collapse:collapse;border: 1px solid #333;width:60%;}
		th, td {border: 1px solid #333;}
		th {background-color:#aaa; color:#fff;}
	</style>

<script>
//####################스크립트 작성하기####################//
</script>
</head>
<body>	
	<h2>ajax Array 받기</h2>
	<div id="demo1">
		<button type="button" onclick="getBoard1(2)">데이터 불러오기</button>
	</div>
	<p id="demo1_con"></p>
	<hr><br><br>
	
	<h2>ajax Object 받기</h2>
	<table id="status">
	<tr><th>번호</th><th>제목</th><th>작성자</th></tr>
	</table>
	<br><br>
	
	<div id="demo2">
		<button type="button" onclick="getBoard2(2)">데이터 불러오기</button>
	</div><br><br>
	<hr><br><br>
	
	<button onclick="ajaxTest()">테스트</button>
</body>
</html>
