<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 목록</title>
<style>
* {
	box-sizing: border-box;
}

.container {
	text-align: center;
	width: 80%;
	margin: 0 auto;
}

.student_search_form {
	width: 250px;
	float: right;
	margin-bottom: 10px;
}

.student_search_form input[type=text] {
	padding: 5px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

table tr:nth-child(1) {
	border-bottom: 1px solid #0b4da2;
	border-top: 1px solid #0b4da2;
	background-color: aliceblue;
}

table tr {
	border-bottom: 1px solid #ccc;
}

button {
	color: white;
	background-color: #0b4da2;
	border-radius: 5px;
	border: none;
	width: 50px;
	padding: 4px;
}

tr td {
	padding: 10px 0 10px 0;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>수강신청 목록</h1>
		<br> <br>

		<c:choose>
			<c:when test="${ not empty courseregister}">
				<div class="student_list">
					<table>
						<tr>
							<th>수강코드</th>
							<th>학생코드</th>
							<th>수강상태</th>
							<th>학점</th>
						</tr>
						<c:forEach var="courseregister" items="${courseregister}">
							<tr>
								<td>${courseregister.courseId}</td>
								<td>${courseregister.studentId}</td>
								<td>${courseregister.courseStatus}</td>
								<td class="totalcredit">${courseregister.courseGrade}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="3" style="text-align: right;">총학점 :</td>
							<td class="totalcredits"></td>
						</tr>
					</table>

				</div>
				<!--페이지 네비게이션-->

			</c:when>

			<c:otherwise>
				<!-- 데이터가 없을경우  -->
				<div class="student_list">
					<table>
						<tr>
							<th>수강코드</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>교수명</th>
						</tr>
						<tr>
							<td colspan="4">수강 가능한 과목이 없습니다.</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<script>
							let totalcredits = 0;
// 							document.querySelectorAll(".totalcredit").forEach(element => {
// 							    let creditValue = parseInt(element.innerText);
							    
// 							    if (!isNaN(creditValue)) {
// 							        totalcredits += creditValue;
// 							    } else {
// 							        console.warn(`Invalid number: ${element.innerText}`);
// 							    }
// 							});
							document.querySelectorAll(".totalcredit").forEach(element=>{
								if (totalcredits == 0){
									totalcredits = parseInt(element.innerText);
								} else {
									totalcredits += parseInt(element.innerText);
								}
							});
							console.log(totalcredits);
							document.getElementsByClassName("totalcredits")[0].innerText = totalcredits;
						</script>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>