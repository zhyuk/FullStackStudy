<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
	</script>
<style>
td, h1 {
	text-align: center;
}

.mylist td {
	cursor: pointer;
}


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
	width: 60px;
	height: 40px;
	font-whight: bold;
	cursor: pointer;
}

button:hover{
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
	cursor: pointer
}

tr, td, th {
	height: 50px;
}

.student_list {
	margin: 0 auto;
}

.registerCancle {
	text-align: right;
	margin: 0;
}

.CancleBtn {
	width: 70px;
}

.subjectCheckbox{
	width: 20px;
	height: 20px;
}


@media screen and (max-width: 425px)   {
	/* 테이블의 특정 열 숨기기 */
	th, td{
	 	font-size: 12px;
	 }
	 
	.student_list table th:nth-child(2),
	.student_list table th:nth-child(3),
	.student_list table th:nth-child(5),
	.student_list table th:nth-child(11) {
		display: none; !important
	}
	
	.student_list table td:nth-child(2),
	.student_list table td:nth-child(3),
	.student_list table td:nth-child(5),
	.student_list table td:nth-child(11){ 
		display: none; !important
	}
	
	.totalcredits{
		font-size: 12px;
	}
	
	.registerList{
		width: 105%;
	}
	
	 .inner{
	 	margin-top: 90px !important;
	 }
	 
	 .student_list{
	 	margin: 0 0 0 32px;
	 }
	
}
</style>
</head>
<body>
	<script>
function Checkbox(event) {
  const checkbox = event.currentTarget.querySelector('.subjectCheckbox');
  checkbox.checked = !checkbox.checked;
  // 클릭한 요소가 체크박스가 아닐 때만 상태를 변경
  if (event.target !== checkbox) {
    checkbox.click();
  }
}
</script>
	<jsp:include page="../header.jsp"></jsp:include>
	<h1>나의 수강신청 목록</h1>
	<br>
	<c:choose>
		<c:when test="${ not empty myCourseList}">
			<div class="student_list">
				<form action="coursedelete.cl" method="get" class="registerList" onsubmit="return confirm('정말 취소 하시겠습니까?');">
					<div class="registerCancle">
						<button class="CancleBtn" type="submit">수강취소</button>
					</div>
					<br>
					<table>
						<tr>
							<th>체크항목</th>
							<th>수강코드</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>학기</th>
							<th>학점</th>
							<th>시작시간</th>
							<th>종료시간</th>
							<th>강의날짜</th>
							<th>교수명</th>
							<th>강의실</th>
						</tr>
						<c:forEach var="myCourseList" items="${myCourseList}">
							<tr class="mylist"
								onmouseover="this.style='background-color:#c6c3c3;'"
								onmouseout="this.style='background:none'"
								onclick="this.querySelector('.subjectCheckbox').checked = !this.querySelector('.subjectCheckbox').checked; ">

								<td><label onclick="Checkbox(event)"> <input name="courseId" type="checkbox" class="subjectCheckbox"
										value="${myCourseList.courseId}">
								</label></td>

								<td>${myCourseList.courseId}</td>
								<td>${myCourseList.subjectId}</td>
								<td>${myCourseList.subjectName}</td>
								<td>${myCourseList.subjectSemester}</td>
								<td class="totalcredit">${myCourseList.subjectCredit}</td>
								<td>${myCourseList.subjectStartTime}</td>
								<td>${myCourseList.subjectEndTime}</td>
								<td>${myCourseList.subjectDay}</td>
								<td>${myCourseList.professorName}</td>
								<td>${myCourseList.subjectRoom}</td>
							</tr>
						</c:forEach>
						</table>
						<br>
							<div style="text-align: right; font-size: 20px;">총학점: <span class="totalcredits" style="font-size: 20px;"></span>&nbsp;&nbsp;&nbsp;</div>
				</form>
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
						<th>학기</th>
						<th>시작시간</th>
						<th>종료시간</th>
						<th>강의날짜</th>
						<th>교수명</th>
						<th>강의실</th>
					</tr>
					<tr>
						<td colspan="9">수강 신청 목록이 없습니다.</td>
					</tr>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
	<script>
							let totalcredits = 0;
							document.querySelectorAll(".totalcredit").forEach(element=>{
								if (totalcredits == 0){
									totalcredits = parseInt(element.innerText);
								} else {
									totalcredits += parseInt(element.innerText);
								}
							});
							document.getElementsByClassName("totalcredits")[0].innerText = totalcredits;
							
					
						</script>



	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>