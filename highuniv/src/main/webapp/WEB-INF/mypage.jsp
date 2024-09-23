<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="vo.StudentVO, dao.StudentDAO, java.sql.Connection"%>
<%
// 세션에서 사용자 ID 가져오기
String userId = (String) session.getAttribute("student_id");

// 만약 로그인이 되어 있지 않으면 로그인 페이지로 리다이렉트
if (userId == null) {
	response.sendRedirect("login.jsp");
	return;
}

// 데이터베이스 연결 가져오기
Connection con = null;
try {
	con = util.JdbcUtil.getConnection(); // 데이터베이스 연결 유틸리티 클래스 사용

	// StudentDAO 인스턴스 생성 및 연결 설정
	StudentDAO studentDAO = StudentDAO.getInstance();
	studentDAO.setConnection(con);

	// 데이터베이스에서 사용자 정보 가져오기
	StudentVO student = studentDAO.selectStudent(userId);

	if (student == null) {
		out.println("사용자 정보를 불러올 수 없습니다.");
		return;
	}
%>

<!-- HTML 폼 시작 -->
<!DOCTYPE html>
<html>

<head>
<style>
body {
	background-color: #EAEAED;
	font-family: "Pretendard Variable", Arial, sans-serif;
}

h1 {
	text-align: center;
	font-size: 24px;
	margin-bottom: 30px;
	font-weight: bold;
}

form {
	width: 70%;
	max-width: 900px;
	margin: 0 auto;
	padding: 20px;
	background-color: #f9f9f9;
	border: 1px solid #ccc;
	border-radius: 10px;
}

/* Flex를 사용하여 레이블과 필드를 수평으로 정렬 */
form .form-group {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 15px;
}

form label {
	width: 150px;
	font-size: 14px;
	color: #333;
	text-align: right;
	margin-right: 10px;
}

form input[type="text"], 
form input[type="email"], 
form input[type="password"] {
	flex: 1;
	padding: 8px;
	font-size: 14px;
	border: 1px solid #ccc;
	border-radius: 4px;
	background-color: #fff;
}

form .imagesize {
	width: 132px;
	height: 170px;
	border: 1px solid #ccc;
	display: inline-block;
	background-color: #f0f0f0;
	margin-right: 20px;
	object-fit: cover;
}

form .btn {
	width: 120px;
	padding: 10px 0;
	background-color: #0B4DA2;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	text-align: center;
	margin: 0 5px;
}

form .btn:hover {
	background-color: #2a73d6;
}

form .btn-group {
	text-align: center;
	margin-top: 20px;
	display: flex;
	justify-content: center;
}

/* 주소 필드에만 적용되는 스타일 */
form .address-group {
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 10px;
	margin-bottom: 15px;
}

/* 반응형 디자인 */
@media screen and (max-width: 768px) {
	form {
		width: 90%;
	}

	form .form-group {
		flex-direction: column;
		align-items: flex-start;
	}

	form label {
		text-align: left;
		margin-bottom: 5px;
	}

	form input[type="text"], 
	form input[type="email"] {
		width: 100%;
	}

	form .btn-group {
		flex-direction: column;
	}

	form .btn {
		width: 100%;
		margin-bottom: 10px;
	}

	form .address-group {
		grid-template-columns: 1fr; /* 작은 화면에서는 한 줄씩 표시 */
	}
}

</style>
<meta charset="UTF-8">
<title>마이페이지</title>

</head>

<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<h1>마이페이지</h1>
	<form action="StudentModify" method="post" id="studentForm"
		name="studentForm" onsubmit="return modify();">
		<!-- 수정 가능한 필드 -->
		<div class="form-group">
			<span class="imagesize"> <%=student.getStudent_image() !=null ? "<img src='" + student.getStudent_image()
								+ "' alt='사진'>" : "사진 없음" %>
			</span>
		</div>
		<div class="form-group">
			<label for="STUDENT_EMAIL">이메일:</label> <input type="email"
				id="STUDENT_EMAIL" name="STUDENT_EMAIL"
				value="<%=student.getStudent_email()%>" required> <span
				id="emailErrorMessage" style="display: none; color: red;">유효한
				이메일 주소를 입력해주세요.</span> <span id="emailValidMessage"
				style="display: none; color: green;">유효한 이메일 주소입니다.</span> <br>
			<br>
		</div>
		<div class="form-group">
			<label for="STUDENT_PH">전화번호:</label> <input type="text"
				id="STUDENT_PH" name="STUDENT_PH"
				value="<%=student.getStudent_ph()%>" required> <span
				id="phoneErrorMessage" style="display: none; color: red;">유효한
				전화번호를 입력해주세요.</span> <span id="phoneValidMessage"
				style="display: none; color: green;">유효한 전화번호입니다.</span> <br> <br>
		</div>
		<div>
			<label for="address">주소:</label> <span> <%=student.getStudent_address()%>
			</span>
			<div class="address-group">
				<input type="text" id="sample6_postcode" name="zipcode"
					placeholder="우편번호"> <input type="button"
					onclick="sample6_execDaumPostcode()" value="우편번호 찾기"> <input
					type="text" id="sample6_address" name="addr1" placeholder="주소">
				<input type="text" id="sample6_detailAddress" name="addr2"
					placeholder="상세주소"> <input type="text"
					id="sample6_extraAddress" name="comment" placeholder="참고항목">
			</div>
		</div>

		<!-- 조회만 가능한 필드 -->
		<div class="form-group">
			<label>학번:</label> <span><%=student.getStudent_id()%></span>
		</div>
		<div class="form-group">
			<label>이름:</label> <span><%=student.getStudent_name()%></span>
		</div>
		<div class="form-group">
			<label>생년월일:</label> <span><%=student.getStudent_birth()%></span>
		</div>
		<div class="form-group">
			<label>입학날짜:</label> <span><%=student.getStudent_intoday()%></span>
		</div>
		<div class="form-group">
			<label>학년:</label> <span><%=student.getStudent_year()%> 학년</span>
		</div>
		<div class="form-group">
			<label>전공:</label> <span><%=student.getStudent_major()%></span>
		</div>
		<div class="form-group">
			<label>성별:</label> <span><%=student.getStudent_gender().equals("M") ? "남성" : "여성"%></span>
		</div>
		<div class="form-group">
			<label>상태:</label> <span><%=student.getStudent_status()%></span>
		</div>
		<div class="form-group">
			<label>사용가능:</label> <span> <%=student.getStudent_use()%>
			</span>

		</div>
		<div class="btn-group">
			<button type="submit" class="btn">정보 수정</button>
			<button type="button" class="btn" onclick="window.history.back();">취소</button>
		</div>

	</form>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		// 이메일 유효성 검사 함수
		function validateEmail(email) {
			const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			return emailRegex.test(email);
		}

		// 전화번호 유효성 검사 함수
		function validatePhoneNumber(phoneNumber) {
			const phoneRegex = /^01[0-9]-?\d{3,4}-?\d{4}$/;
			return phoneRegex.test(phoneNumber);
		}

		// 이메일 입력 필드 블러 이벤트 핸들러
		function handleEmailBlur() {
			const email = document.getElementById("STUDENT_EMAIL").value.trim();
			const errorMessage = document.getElementById("emailErrorMessage");
			const validMessage = document.getElementById("emailValidMessage");

			if (email && !validateEmail(email)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else if (email) {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			} else {
				// 이메일이 비어있는 경우 메시지 숨기기
				errorMessage.style.display = "none";
				validMessage.style.display = "none";
			}
		}

		// 전화번호 입력 필드 블러 이벤트 핸들러
		function handlePhoneNumberBlur() {
			const phoneNumber = document.getElementById("STUDENT_PH").value
					.trim();
			const errorMessage = document.getElementById("phoneErrorMessage");
			const validMessage = document.getElementById("phoneValidMessage");

			if (phoneNumber && !validatePhoneNumber(phoneNumber)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else if (phoneNumber) {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			} else {
				// 전화번호가 비어있는 경우 메시지 숨기기
				errorMessage.style.display = "none";
				validMessage.style.display = "none";
			}
		}

		document.addEventListener("DOMContentLoaded", function() {
			// 블러 이벤트 리스너 추가
			document.getElementById("STUDENT_EMAIL").addEventListener("blur",
					handleEmailBlur);
			document.getElementById("STUDENT_PH").addEventListener("blur",
					handlePhoneNumberBlur);

			// 폼 제출 이벤트 리스너 제거 또는 주석 처리
			// 폼의 onsubmit에서 modify() 함수를 호출하므로 중복될 필요 없음
		});

		function modify() {
			var email = document.getElementById('STUDENT_EMAIL').value.trim();
			var phone = document.getElementById('STUDENT_PH').value.trim();
			var postcode = document.getElementById('sample6_postcode').value
					.trim();
			var address = document.getElementById('sample6_address').value
					.trim();
			var detailAddress = document
					.getElementById('sample6_detailAddress').value.trim();
			var extraAddress = document.getElementById('sample6_extraAddress').value
					.trim();
			var isValid = false; // 유효한 필드가 있는지 여부
			var errorMessages = []; // 오류 메시지 배열
			// 이메일 유효성 검사
			if (email) { // 이메일이 입력된 경우
				if (!validateEmail(email)) {
					errorMessages.push('유효한 이메일 주소를 입력해주세요.');
				} else {
					isValid = true;
				}
			}

			// 전화번호 유효성 검사
			if (phone) { // 전화번호가 입력된 경우
				if (!validatePhoneNumber(phone)) {
					errorMessages
							.push('유효한 전화번호를 입력해주세요. (예: 010-1234-5678 또는 01012345678)');
				} else {
					isValid = true;
				}
			}

			// 주소 유효성 검사
			if (postcode || address || detailAddress || extraAddress) {
				isValid = true;
				// 필요하다면 주소에 대한 추가 유효성 검사 로직을 추가할 수 있습니다.
			}

			// 오류 메시지가 있는 경우
			if (errorMessages.length > 0) {
				alert(errorMessages.join('\n'));
				return false; // 폼 제출 중단
			}

			// 유효한 필드가 하나도 없는 경우
			if (!isValid) {
				alert('변경할 정보를 입력해 주세요.');
				return false; // 폼 제출 중단
			}

			// 유효한 필드가 있고, 오류가 없으면 폼 제출 진행
			return true;
		}

		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById("sample6_address").value = data.roadAddress
									|| data.jibunAddress;
							document.getElementById("sample6_extraAddress").value = data.bname
									|| '';
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();
			return true;
		}
	</script>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>

<%
} catch (Exception e) {
e.printStackTrace();
} finally {
// 데이터베이스 연결 해제
if (con != null)
	try {
		con.close();
	} catch (Exception ignore) {
	}
}
%>