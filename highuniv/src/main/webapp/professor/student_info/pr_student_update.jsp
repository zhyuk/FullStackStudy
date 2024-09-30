<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.StudentVO"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8"><title>학생 업데이트</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="../../css/pr_student_into.css">
</head>
<body>
	<jsp:include page="../../header.jsp"></jsp:include>
	<h1>학생수정</h1>
	<div class="container">
		<form id="studentForm" action="studentupdate.pr" method="post" enctype="multipart/form-data">
			<input type="hidden" name="currentUrl" value="${currentUrl}" >
			<div id="image_container" style="border:none;"><img src="../../image/studentimg/${student.student_image}" onerror="this.src='../../image/studentimg/default.png'" style="width: 150px; height:180px;"></div><br>
			<label for="student_id">학번</label> <input type="text" name="student_id" id="student_id" value="${student.student_id}" readonly ><br>
			<div id="idErrorMessage" class="error-message">유효한 학번을 입력해주세요. ex)20250001(숫자 8자리)</div>
			<label for="student_pw">비밀번호</label> <input type="password" name="student_pw" id="student_pw" value="${student.student_pw}">
			<div id="passwordErrorMessage" class="error-message">비밀번호를 입력해주세요.</div>
			<div>
				<label for="student_name">이름</label> <input type="text" name="student_name" id="student_name" value="${student.student_name}">
				<div id="nameErrorMessage" class="error-message">한글 또는 영문 이름만 입력할 수 있습니다.</div>
				<div>
					<label for="student_major">전공</label> <select name="student_major" id="student_major">
						<option value="">전공을 선택하세요</option>
						<option value="미디어학과" ${student.student_major == '미디어학과' ? 'selected' : ''}>미디어학과</option>
   					 	<option value="기계공학과" ${student.student_major == '기계공학과' ? 'selected' : ''}>기계공학과</option>
					    <option value="전기공학과" ${student.student_major == '전기공학과' ? 'selected' : ''}>전기공학과</option>
					    <option value="경영학과" ${student.student_major == '경영학과' ? 'selected' : ''}>경영학과</option>
					    <option value="간호학과" ${student.student_major == '간호학과' ? 'selected' : ''}>간호학과</option>
					</select>
					<div id="majorErrorMessage" class="error-message">전공을 선택해주세요.
					</div>
				</div>
			</div>
			<div>
				<label for="student_ph">핸드폰번호</label> <input type="text" name="student_ph" id="student_ph" value="${student.student_ph}"><br>
				<div id="phoneErrorMessage" class="error-message">유효한 전화번호를 입력해주세요. (예: 010-1234-5678 또는 01012345678)</div>
				
				<label for="student_email">이메일</label> <input type="text" name="student_email" id="student_email" value="${student.student_email}"><br>
				<div id="emailErrorMessage" class="error-message">유효한 이메일 주소를 입력해주세요.</div>
			</div>
	
			<div>
				<label for="student_birth">생년월일</label> <input type="date" id="student_birth" name="student_birth" value="${student.student_birth}">
				<div id="birthErrorMessage" class="error-message">유효한 생년월일을 입력하세요.</div>
			</div>
	
			<div>
				<label for="student_intoday">입학날짜</label> <input type="date" id="student_intoday" name="student_intoday" value="${student.student_intoday}">
			</div>
			
			<div>
				<label for="student_gender">성별</label> 
				<select name="student_gender" id="student_gender" onblur="handleGenderBlur()">
					<option value="M" ${student.student_gender == '1' ? 'selected' : ''} >남자</option>
					<option value="F" ${student.student_gender == '1' ? 'selected' : ''} >여자</option>
				</select>
				<div id="genderErrorMessage" class="error-message">성별을 선택하세요.</div>
			</div>
			<div>
				<label for="student_year">학년</label> <select name="student_year" id="student_year" onblur="handleYearBlur()">
					<option value="1" ${student.student_year == '1' ? 'selected' : ''}>1학년</option>
				    <option value="2" ${student.student_year == '2' ? 'selected' : ''}>2학년</option>
				    <option value="3" ${student.student_year == '3' ? 'selected' : ''}>3학년</option>
				    <option value="4" ${student.student_year == '4' ? 'selected' : ''}>4학년</option>
				</select>
				<div id="yearErrorMessage" class="error-message">학년을 선택하세요.</div>
			</div>
				<label for="student_address">주소</label><input type="button"onclick="sample6_execDaumPostcode()" value="주소 찾기" id="zipcode_btn"><br>
				<label></label><input type="text" id="student_address" name="student_address" value="${student.student_address}">
				<input type="text" id="sample6_postcode" name="zipcode" style="display: none;"> 
				<input type="text" id="sample6_address" name="addr1" placeholder="주소"  style="display: none;">
				<input type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소"  style="display: none;"> 
				<input type="text" id="sample6_extraAddress" name="comment" placeholder="참고항목" style="display: none;" > 
				
				<div>
					<label for="student_status">상태</label> 
					<select name="student_status" id="student_status">
						<option value="재학" ${student.student_status == '재학' ? 'selected' : ''}>재학</option>
					    <option value="휴학" ${student.student_status == '휴학' ? 'selected' : ''}>휴학</option>
					    <option value="졸업" ${student.student_status == '졸업' ? 'selected' : ''}>졸업</option>
					    <option value="자퇴" ${student.student_status == '자퇴' ? 'selected' : ''}>자퇴</option>
					</select>
					<div id="statusErrorMessage" class="error-message" style="display: none;">상태를 선택하세요.</div>
				</div>
			
				<label for="student_image">이미지 </label>
				<input type="file" name="student_image" id="student_image" accept=".jpg, .jpeg, .png, .gif"><br>
				<input type="hidden" name="existing_image" value="${student.student_image}"> 
					<div class="btn-group">
					<input type="button" value="전송" class="btn" onclick="validateAndSubmit()">
					<input type="button" value="취소" class="btn" onclick="window.history.back();" value="취소">
				</div>
		</form>
	</div>
	
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../../js/pr_student_into.js"></script>
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>