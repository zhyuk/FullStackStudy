<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Ajax Test</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
		<style>
			table {
				border-collapse: collapse;
				border: 1px solid #333;
				width: 60%;
			}

			th,
			td {
				border: 1px solid #333;
			}

			th {
				background-color: #aaa;
				color: #fff;
			}
		</style>

		<script>
			//####################스크립트 작성하기####################//
			function getBoard1(val) {
				var objParams = {
					seq: val
				};
				var values = []; //ArrayList 값을 받을 변수 선언
				$.ajax({
					url: "reqAjax1.do",
					type: "POST",
					data: objParams,
					cache: false,
					success: function (data) {
						$("#demo1").hide();
						console.log(data);
						console.log("성공");
						let str = "";
						$.each(data, function (i, o) {
							str += "[" + i + "] {" + o.seq + "," + o.title + ","
								+ o.writer + "}<br>";
						});
						$("#demo1_con").html(str);
					},
					error: function (request, status) {
						alert("오류가 발생했습니다");
					}
				});
			}

			function getBoard2(val) {
				var objParams = {
					seq: val
				};
				var values = [];
				$.ajax({
					method: "POST",
					url: "reqAjax2.do",
					data: objParams,
					cache: false,
					success: function (data) {
						console.log("data: " + data);
						
// 						$("#demo2").html(data);
						if (data.code == "OK") { //controller에서 넘겨준 성공여부 코드
							values = data.boardList; //java에서 정의한 ArrayList명을 적어준다.
							$.each(values, function (index, value) {
								console.log(index + " : " + value.title);
								$("#status").append(
									"<tr><td>" + value.seq + "</td><td>"
									+ value.title + "</td><td>"
									+ value.writer + "</td></tr>");
							});
							$("#demo2").hide();
							console.log("성공");
						} else {
							console.log("실패");
						}
					},
					error: function (request, status) {
						alert("오류가 발생했습니다");
					}
				});
			}

			function ajaxTest() {
				$.ajax({
					url: "ajaxTest.do",
					type: "post",
					contentType: 'application/json; charset=utf-8', // 보내는 데이터를 json형식으로 변환하여 전송.
// 					data: { "id": "admin", "password": "1111", "name": "관리자", "role": "Admin" },
					data: JSON.stringify(
						{ "id": "admin", "password": "1111", "name": "관리자", "role": "Admin" }
					), // 보내는 데이터를 json형식으로 파싱하여 전송.
					cache: false,
					success: function (result) {
						alert(result);
					}
				});
			}
		</script>
	</head>

	<body>
		<h2>ajax Array 받기</h2>
		<div id="demo1">
			<button type="button" onclick="getBoard1(2)">데이터 불러오기</button>
		</div>
		<p id="demo1_con"></p>
		<hr>
		<br>
		<br>

		<h2>ajax Object 받기</h2>
		<table id="status">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</table>
		<br>
		<br>

		<div id="demo2">
			<button type="button" onclick="getBoard2(2)">데이터 불러오기</button>
		</div>
		<br>
		<br>
		<hr>
		<br>
		<br>

		<button onclick="ajaxTest()">테스트</button>
	</body>

	</html>