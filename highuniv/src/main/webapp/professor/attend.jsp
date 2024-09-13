<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>하이대학교</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
			<style>
				.inner h1.title {
					text-align: center;
					font-size: 50px;
					font-weight: 600;
				}

				.inner table {
					width: 100%;
					background: #D9D9D9;
					border-collapse: collapse;
				}

				.inner table,
				.inner tr,
				.inner th,
				.inner td {
					border: 1px solid black;
				}

				.inner th,
				.inner td {
					height: 50px;
				}

				.inner td {
					padding: 0 10px;
				}

				.inner th:nth-child(1) {
					width: 30px;
				}

				.inner th:nth-child(2) {
					width: 250px;
				}

				.inner th:nth-child(3),
				.inner th:nth-child(4) {
					width: 200px;
				}

				.inner th:nth-child(5),
				.inner th:nth-child(6) {
					width: 250px;
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

				.inner td:nth-child(6) input {
					width: 100%;
					height: 100%;
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
			</style>
		</head>

		<body class="pretendard">
			<jsp:include page="../header.jsp" />
			<h1 class="title">출석정보</h1>
			<button class="button">수정</button>
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
						<td>${attend.subject_name}</td>
						<td>${attend.student_id}</td>
						<td>${attend.student_name}</td>
						<td><span class="show">${attend.status}</span>
							<div class="radio-Box hide">
								<ul>
									<li><label for="1">출석</label> <input type="radio" name="attend${num }" id="1"
											value="출석" <c:set var="i" value="출석" />
										<c:if test="${i eq attend.status}">checked</c:if>>
									</li>
									<li><label for="2">지각</label> <input type="radio" name="attend${num }" id="2"
											value="지각" <c:set var="i2" value="지각" />
										<c:if test="${i2 eq attend.status}">checked</c:if>>
									</li>
									<li><label for="3">조퇴</label> <input type="radio" name="attend${num }" id="3"
											value="조퇴" <c:set var="i3" value="조퇴" />
										<c:if test="${i3 eq attend.status}">checked</c:if>>
									</li>
									<li><label for="4">결석</label> <input type="radio" name="attend${num }" id="4"
											value="결석" <c:set var="i4" value="결석" />
										<c:if test="${i4 eq attend.status}">checked</c:if>>
									</li>
								</ul>
							</div>
						</td>
						<td><span class="show">${attend.attend_remarks}</span>
							<input type="text" class="hide" value="${attend.attend_remarks}">
						</td>
					</tr>
					<c:set var="num" value="${num=num+1 }" />
				</c:forEach>
			</table>
			<jsp:include page="../footer.jsp" />
			<script>
				$(function () {
					$(".button").click(function () {
						console.log("클릭");
						console.log($(this).text());

						if ($(this).text() == '수정') {
							$(this).text("저장");
							$(".hide").show();
							$(".show").hide();
							$("input .hide").text($("span .show").text());
						} else {
							$(this).text("수정");
							$(".hide").hide();
							$(".show").show();
							

							// $.ajax({
							// 	url: "/attend.update",
							// 	type: "GET",
								// data: { "status": },
								// async: true 또는 false, // 비동기(true), 동기(false) 여부
								// cache: true 또는 false, // 데이터를 주고 받을 때 데이터를 저장(true)할 지, 저장해 놓지 않을지(false) 여부
							// 	success: function (data) {
							// 		alert("완성");
							// 	},
							// 	error: function () {
							// 		alert('error');
							// 	}
							// });
						}

					});
				});
			</script>
		</body>

		</html>