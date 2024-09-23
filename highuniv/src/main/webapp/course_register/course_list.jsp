<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
<link rel="stylesheet" type="text/css" href="../css/student_list.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
	
</style>
</head>
<body>
<script>

// $(document).ready(function() {
//     // 페이지 로드 시 로컬 스토리지에서 비활성화 상태 복원
//     $('input[name="subjectId"]').each(function() {
//         if (localStorage.getItem('disabled-' + $(this).val()) === 'true') {
//             $(this).prop('disabled', true);
//         }
//     });

//     $('#courseForm').submit(function(event) {
//         // 기존 숨겨진 input 제거
//         $('input[type="hidden"]', this).remove();
        
//         // 체크된 항목에 대해 숨겨진 input 추가
//         $('input[name="subjectId"]:checked', this).each(function() {
//             $('<input>').attr({
//                 type: 'hidden',
//                 name: 'subjectId',
//                 value: $(this).val()
//             }).appendTo('#courseForm');
            
//             // 비활성화된 항목을 로컬 스토리지에 저장
//             localStorage.setItem('disabled-' + $(this).val(), 'true');
//         });

//         // 체크된 항목 비활성화
//         $('input[name="subjectId"]:checked').prop('disabled', true);
//     });
// });
</script>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>강의정보</h1>
		<div class="student_search_form">
			
		</div>
		<c:choose>
			<c:when test="${ not empty courseList}">
				<div class="student_list">
				<form action="courseinto.cl" method="get" id = "courseForm" >
				<button type="submit" >신청</button>
					
					<table>
						<tr>
							<th>신청여부</th>
							<th>강의코드</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>최대인원</th>
							<th>학기</th>
							<th>학점</th>
							<th>시작시간</th>
							<th>종료시간</th>
							<th>강의날짜</th>
							<th>교수명</th>
							<th>강의실</th>
						</tr>
						<c:forEach var="courselist" items="${courseList}" varStatus="status">
							<tr>
								<td><input name="subjectId" type="checkbox" value="${courselist.subjectId}"></td>
								<td>${courselist.courseId}</td>
								<td>${courselist.subjectId}</td>
								<td>${courselist.subjectName}</td>
								<td><input style="display: none;" type="text" name="courseId" value="${courselist.courseId}">${registrationCount[status.index]}/${courselist.courseMaxPeople}</td>
								<td>${courselist.subjectSemester}</td>
								<td>${courselist.subjectCredit}</td>
								<td>${courselist.subjectStartTime}</td>
								<td>${courselist.subjectEndTime}</td>
								<td>${courselist.subjectDay}</td>
								<td>${courselist.professorId}</td>
								<td>${courselist.subjectRoom}</td>
								
							</tr>
						</c:forEach>
					</table>
				</form>
				</div>
				<br>
				<br>

<!-- 				<form action="courseinto.cl" method="get"> -->
<!-- 					<button type="submit" style="width: 120px; float: right;">내 -->
<!-- 						수강목록 보기</button> -->
<!-- 				</form> -->
				<!--페이지 네비게이션-->
			</c:when>
			<c:otherwise>
				<!-- 데이터가 없을경우  -->
				<div class="student_list">
					<table>
						<tr>
							<th>신청여부</th>
							<th>강의코드</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>최대인원</th>
							<th>학기</th>
							<th>학점</th>
							<th>시작시간</th>
							<th>종료시간</th>
							<th>강의날짜</th>
							<th>교수명</th>
							<th>강의실</th>
						</tr>
						<tr>
							<td colspan="12">수강 가능한 과목이 없습니다.</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
