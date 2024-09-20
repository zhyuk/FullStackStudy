<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>하이대학교</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
<style>
.inner h1.title {
	text-align: center;
	font-size: 50px;
	font-weight: 600;
}

.inner p.date {
	float: left;
	width: calc(100% - 80px);
	text-align: center;
	margin: 40px 0;
	border: solid 1px red;
}

.inner table {
	width: 100%;
	background: #D9D9D9;
	border-collapse: collapse;
}

.inner table, .inner tr, .inner th, .inner td {
	border: 1px solid black;
}

.inner th, .inner td {
	height: 50px;
}

.inner th:nth-child(1) {
	width: 50px;
}

.inner th:nth-child(2) {
	width: 250px;
}

.inner th:nth-child(3), .inner th:nth-child(4) {
	width: 200px;
}

.inner th:nth-child(5), .inner th:nth-child(6) {
	width: 300px;
}

.inner td {
	padding: 0 10px;
	background: #fff;
	text-align: center;
}

.inner td:nth-child(5) ul {
	width: 100%;
}

.inner td:nth-child(5) ul li {
	width: 25%;
	text-align: center;
}

.inner td:nth-child(5) ul li input {
	display: inline-block;
}

.inner td:nth-child(6) {
	padding: 0;
}

.inner td:nth-child(6) input {
	width: 100%;
	height: 100%;
	padding: 10px;
	font-size: 16px;
	border: none;
}

.radio-Box>ul {
	width: 100%;
	display: flex;
	list-style: none;
}

.radio-Box>ul>li>* {
	display: block;
}

.hide {
	display: none;
}

.button {
	float: right;
	width: 40px;
	margin: 40px 0;
	margin-right: 40px;
	background: none;
	font-size: 18px;
	font-weight: 600;
	border: solid 1px red;
	cursor: pointer;
}
</style>
</head>

<body class="pretendard">
	<jsp:include page="../header.jsp" />
	<h1 class="title">출석정보</h1>
	<div>
		<p class="date">${AttendList[0].attend_date}</p>
		<button class="button show">수정</button>
		<button class="button hide">저장</button>
	</div>
	<table>
		<tr>
			<th class="hide"><input type="checkbox" class="allChk"></th>
			<th>과목명</th>
			<th>학번</th>
			<th>이름</th>
			<th>상태</th>
			<th>비고</th>
		</tr>

		<c:set var="num" value="0" />
		<c:forEach var="attend" items="${AttendList}">
			<tr>
				<td class="hide"><input type="checkbox" class="chk"></td>
				<td class="subject_name">${attend.subject_name}</td>
				<td class="student_id">${attend.student_id}</td>
				<td class="">${attend.student_name}</td>
				<td><span class="show status-msg">${attend.status}</span>
					<div class="radio-Box hide">
						<ul>
							<li><label for="attend${num}">출석</label> <input type="radio"
								name="attend${num}" id="attend${num}" value="출석"
								<c:set var="i" value="출석" />
								<c:if test="${i eq attend.status}">checked</c:if>></li>
							<li><label for="late${num}">지각</label> <input type="radio"
								name="attend${num}" id="late${num}" value="지각"
								<c:set var="i2" value="지각" />
								<c:if test="${i2 eq attend.status}">checked</c:if>></li>
							<li><label for="ealry${num}">조퇴</label> <input type="radio"
								name="attend${num}" id="ealry${num}" value="조퇴"
								<c:set var="i3" value="조퇴" />
								<c:if test="${i3 eq attend.status}">checked</c:if>></li>
							<li><label for="absence${num}">결석</label> <input
								type="radio" name="attend${num}" id="absence${num}" value="결석"
								<c:set var="i4" value="결석" />
								<c:if test="${i4 eq attend.status}">checked</c:if>></li>
						</ul>
					</div></td>
				<td><span class="show">${attend.attend_remarks}</span> <input
					type="text" id="comment${num}" class="hide"
					value="${attend.attend_remarks}"></td>
			</tr>

			<c:set var="num" value="${num + 1}" />
		</c:forEach>
	</table>
	<script>
		$(function() {
			$(".button")
					.click(
							function() {
								// 				console.log("클릭");
								// 				console.log($(this).text());

								if ($(this).text() === '수정') {
									$(".hide").show();
									$(".show").hide();
									$("input .hide").text(
											$("span .show").text());
								} else if ($(this).text() === '저장') {
									$(".hide").hide();
									$(".show").show();

									$("input.chk:checked")
											.each(
													function() {
														let $row = $(this)
																.closest("tr");
														let status = $row
																.find(
																		"input[name^='attend']:checked")
																.val(); // 출석 상태
														let comment = $row
																.find(
																		"input[type=text]")
																.val(); // 비고
														let studentId = $row
																.find(
																		"td.student_id")
																.text();
														let subjectName = $row
																.find(
																		"td.subject_name")
																.text();
														let statusSpan = $($row)
																.children().eq(
																		4)
																.children(
																		"span");
														let commentSpan = $(
																$row)
																.children().eq(
																		5)
																.children(
																		"span");

														// 							        console.log(status);
														// 							        console.log(comment);
														// 							        console.log(studentId);
														// 							        console.log(subjectName);
														// 							        console.log(statusSpan);
														// 							        console.log(commentSpan);

														// AJAX를 통해 서버로 status 값을 전송
														$
																.ajax({
																	type : "POST",
																	url : "attendUpdate", // 서버에서 처리할 URL (서블릿이나 JSP 파일 경로)
																	data : {
																		status : status,
																		comment : comment,
																		studentId : studentId,
																		subjectName : subjectName
																	},
																	cache : false,
																	success : function(
																			response) {
																		console
																				.log("ajax 데이터 전송 성공");
																		// 											console.log(typeof response, response);
																		if (response.message == "OK") {
																			alert("수정되었습니다.");
																			$(
																					statusSpan)
																					.text(
																							$row
																									.find(
																											"input[name^='attend']:checked")
																									.val());
																			$(
																					commentSpan)
																					.text(
																							$row
																									.find(
																											"input[type=text]")
																									.val());

																		} else {
																			alert("수정실패");
																		}
																	},
																	error : function(
																			error) {
																		console
																				.log("ajax 데이터 전송 실패");
																	}
																});
													});

								}
							});
		});
	</script>
	<jsp:include page="../footer.jsp" />

</body>

</html>