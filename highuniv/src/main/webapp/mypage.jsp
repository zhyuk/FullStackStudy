<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="vo.StudentVO, dao.StudentDAO, java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // 세션에서 사용자 ID 가져오기
    String userId = (String) session.getAttribute("id");
    
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
        // student 객체를 request 속성에 저장하여 EL에서 접근 가능하도록 함
        request.setAttribute("student", student);
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<!-- 뷰포트 메타 태그 추가 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
/* 전체 바디 스타일 */
body {
    background-color: #f5f5f5;
    font-family: 'Pretendard Variable', Arial, sans-serif;
    color: #333;
}

/* 페이지 제목 */
h1 {
    text-align: center;
    font-size: 26px;
    margin-bottom: 30px;
    font-weight: 700;
    color: #1a1a1a;
}

/* 폼 스타일 */
form {
    width: 80%;
    max-width: 850px;
    margin: 30px auto;
    padding: 20px;
    background-color: #ffffff;
    border: 1px solid #e0e0e0;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    text-align: left;
}

/* 이미지와 연락처 정보를 나란히 배치하는 그룹 */
.image-and-contact {
    display: flex;
    gap: 30px;
    align-items: flex-start;
}

/* 이미지 박스 스타일 */
.imagesize {
    width: 140px;
    height: 180px;
    border: 2px solid #e0e0e0;
    display: inline-block;
    background-color: #f0f0f0;
    border-radius: 8px;
    object-fit: cover;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    overflow: hidden;
}

.imagesize img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

/* 연락처 정보 그룹 */
.contact-info {
    display: flex;
    flex-direction: column;
    gap: 15px;
    flex: 1;
}

/* 연락처 항목 */
.contact-item {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    gap: 20px;
}

/* 레이블 스타일 */
.contact-item label {
    width: 100px;
    font-size: 16px;
    font-weight: 300;
    color: #444;
    flex-shrink: 0;
}

/* 연락처 값 및 입력 필드 */
.contact-item .contact-value,
.contact-item input[type="email"],
.contact-item input[type="text"],
.contact-item textarea {
    flex: 1;
    padding: 10px;
    font-size: 16px;
}

/* 이메일과 전화번호의 입력 필드 스타일 */
.contact-item input[type="email"],
.contact-item input[type="text"] {
    border: 0.1px solid #000;
    border-radius: 6px;
    background-color: #fff;
    box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.05);
    transition: border-color 0.3s ease-in-out;
}

.contact-item input[type="email"]:focus,
.contact-item input[type="text"]:focus {
    border: 3px solid #000;
    outline: none;
}

/* textarea 스타일 추가 */
.contact-item textarea {
    flex: 1;
    padding: 10px;
    font-size: 14px;
    border: 1px solid #ddd;
    border-radius: 6px;
    background-color: #fff;
    box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.05);
    transition: border-color 0.3s ease-in-out;
    resize: none;
    overflow-y: hidden;
    min-height: 40px;
}

.contact-item textarea:focus {
    border-color: #66afe9;
    outline: none;
}

/* 주소 필드 스타일 */
.address-field {
    display: flex;
    gap: 10px;
    flex: 1;
}

.address-field textarea {
    flex: 1;
}

.address-field input[type="button"] {
    padding: 10px 20px;
    background-color: #ddd;
    border: 1px solid #ccc;
    font-size: 14px;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s ease-in-out;
}

.address-field input[type="button"]:hover {
    background-color: #bbb;
}

/* 숨겨진 주소 입력 필드 */
#address-fields {
    display: none;
    margin-top: 10px;
}

#address-fields .address-group input[type="text"] {
    width: 100%;
    padding: 10px;
    font-size: 14px;
    border: 1px solid #ddd;
    border-radius: 6px;
    background-color: #fff;
    margin-bottom: 10px;
}

/* 버튼 그룹 */
form .btn-group {
    text-align: center;
    margin-top: 30px;
    display: flex;
    justify-content: center;
    gap: 15px;
}

/* 버튼 스타일 */
form .btn {
    width: 140px;
    padding: 12px 0;
    background-color: #0B4DA2;
    color: white;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    cursor: pointer;
    text-align: center;
    transition: background-color 0.3s ease-in-out;
}

form .btn:hover {
    background-color: #2a73d6;
}

/* 반응형 디자인 */
@media (max-width: 768px) {
    form {
        width: 95%;
        padding: 10px;
    }

    .image-and-contact {
        flex-direction: column;
        align-items: center;
    }

    .imagesize {
        width: 120px;
        height: 160px;
    }

    .contact-item {
        flex-direction: column;
        align-items: flex-start;
    }

    .contact-item label {
        width: 100%;
        text-align: left;
    }

    .contact-item input[type="email"],
    .contact-item input[type="text"],
    .contact-item textarea,
    .contact-item .contact-value {
        width: 100%;
    }

    .btn-group {
        flex-direction: column;
        gap: 10px;
    }

    .btn {
        width: 100%;
    }
}


@media (min-width: 390px) and (max-width: 844px) {
    .contact-item {
        flex-direction: row; /* 컬럼과 값을 나란히 배치 */
        align-items: center;
    }

    .contact-item label {
        width: 100px; /* 레이블 너비 고정 */
        text-align: right; /* 레이블을 오른쪽 정렬 */
        padding-right: 10px;
    }

    .contact-item input[type="email"],
    .contact-item input[type="text"],
    .contact-item textarea,
    .contact-item .contact-value {
        width: calc(100% - 120px); /* 레이블을 제외한 나머지 공간 차지 */
    }

    /* 버튼 그룹 나란히 정렬 */
    .btn-group {
        flex-direction: row;
        justify-content: space-between;
        width: 100%; /* 버튼 그룹을 화면 너비에 맞춤 */
    }

    /* 버튼 너비를 동일하게 설정 */
    .btn-group .btn {
        width: 48%; /* 각 버튼이 화면의 절반을 차지하도록 설정 */
    }
}


</style>
</head>

<body>
    <%@ include file="header.jsp" %>

    <h1>마이페이지</h1>
    <form action="StudentModify" method="post" id="studentForm" name="studentForm" onsubmit="return modify();">
        <div class="form-group image-and-contact">
            <span class="imagesize">
                <c:choose>
                    <c:when test="${not empty student.student_image}">
                        <img src="./image/studentimg/${student.student_image}" alt="사진">
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/image/default.png" alt="기본 사진">
                    </c:otherwise>
                </c:choose>
            </span>
            <div class="contact-info">
                <!-- 학번 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">학번</label>
                    <span class="contact-value">${student.student_id}</span>
                </div>
                <!-- 이름 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">이름</label>
                    <span class="contact-value">${student.student_name}</span>
                </div>
                <!-- 이메일 -->
                <div class="contact-item">
                    <label style="font-weight:bold;" for="STUDENT_EMAIL">이메일</label>
                    <input type="email" id="STUDENT_EMAIL" name="STUDENT_EMAIL" value="${student.student_email}">
                    <span id="emailErrorMessage" style="display: none; color: red;">유효한 이메일 주소를 입력해주세요.</span>
                    <span id="emailValidMessage" style="display: none; color: green;">유효한 이메일 주소입니다.</span>
                </div>
                <!-- 전화번호 -->
                <div class="contact-item">
                    <label style="font-weight:bold;" for="STUDENT_PH">전화번호</label>
                    <input type="text" id="STUDENT_PH" name="STUDENT_PH" value="${student.student_ph}">
                    <span id="phoneErrorMessage" style="display: none; color: red;">유효한 전화번호를 입력해주세요.</span>
                    <span id="phoneValidMessage" style="display: none; color: green;">유효한 전화번호입니다.</span>
                </div>
                <!-- 주소 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">주소</label>
                    <div class="address-field">
                        <!-- textarea로 변경 -->
                        <textarea id="STUDENT_ADDRESS" name="STUDENT_ADDRESS" rows="2">${student.student_address}</textarea>
                        <input type="button" id="zipcode_btn" onclick="showAddressFields(); sample6_execDaumPostcode();" value="주소 수정">
                    </div>
                </div>
                <!-- 숨겨진 주소 입력 필드들 -->
                <div id="address-fields">
                    <div class="address-group">
                        <input type="text" id="sample6_postcode" name="zipcode" placeholder="우편번호">
                        <input type="text" id="sample6_address" name="addr1" placeholder="주소">
                        <input type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
                        <input type="text" id="sample6_extraAddress" name="comment" placeholder="참고항목">
                    </div>
                </div>
                <!-- 생년월일 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">생년월일</label>
                    <span class="contact-value">${student.student_birth}</span>
                </div>
                <!-- 입학날짜 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">입학날짜</label>
                    <span class="contact-value">${student.student_intoday}</span>
                </div>
                <!-- 학년 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">학년</label>
                    <span class="contact-value">${student.student_year} 학년</span>
                </div>
                <!-- 전공 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">전공</label>
                    <span class="contact-value">${student.student_major}</span>
                </div>
                <!-- 성별 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">성별</label>
                    <span class="contact-value">
                        <c:choose>
                            <c:when test="${student.student_gender == 'M'}">남성</c:when>
                            <c:otherwise>여성</c:otherwise>
                        </c:choose>
                    </span>
                </div>
                <!-- 상태 -->
                <div class="contact-item">
                    <label style="font-weight:bold;">상태</label>
                    <span class="contact-value">${student.student_status}</span>
                </div>
            </div>
        </div>

        <!-- 버튼 그룹 -->
        <div class="btn-group">
            <button  type="submit" class="btn">정보 수정</button>
            <button type="button" class="btn" onclick="window.location.href='main'">취소</button>
        </div>
    </form>

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
            const phoneNumber = document.getElementById("STUDENT_PH").value.trim();
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

        function autoResizeTextarea(element) {
            element.style.height = 'auto';
            element.style.height = element.scrollHeight + 'px';
        }

        document.addEventListener("DOMContentLoaded", function() {
            // 블러 이벤트 리스너 추가
            document.getElementById("STUDENT_EMAIL").addEventListener("blur", handleEmailBlur);
            document.getElementById("STUDENT_PH").addEventListener("blur", handlePhoneNumberBlur);

            // 주소 textarea 자동 높이 조절
            var addressTextarea = document.getElementById("STUDENT_ADDRESS");
            autoResizeTextarea(addressTextarea); // 페이지 로드 시 높이 조절

            // 내용 변경 시 높이 조절
            addressTextarea.addEventListener('input', function() {
                autoResizeTextarea(addressTextarea);
            });
        });

        function modify() {
            var email = document.getElementById('STUDENT_EMAIL').value.trim();
            var phone = document.getElementById('STUDENT_PH').value.trim();
            var postcode = document.getElementById('sample6_postcode').value.trim();
            var address = document.getElementById('sample6_address').value.trim();
            var detailAddress = document.getElementById('sample6_detailAddress').value.trim();
            var extraAddress = document.getElementById('sample6_extraAddress').value.trim();
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
                    errorMessages.push('유효한 전화번호를 입력해주세요. (예: 010-1234-5678 또는 01012345678)');
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

        function showAddressFields() {
            document.getElementById('address-fields').style.display = 'block';
        }

        function hideAddressFieldsIfEmpty() {
            var postcode = document.getElementById('sample6_postcode').value.trim();
            var address = document.getElementById('sample6_address').value.trim();
            var detailAddress = document.getElementById('sample6_detailAddress').value.trim();
            var extraAddress = document.getElementById('sample6_extraAddress').value.trim();

            // 모든 주소 필드가 비어있을 경우에만 주소 입력 필드를 숨김
            if (!postcode && !address && !detailAddress && !extraAddress) {
                document.getElementById('address-fields').style.display = 'none';
            }
        }

        function sample6_execDaumPostcode() {
            var element_layer = document.getElementById('zipcode_btn'); // 주소 수정 버튼의 ID
            var rect = element_layer.getBoundingClientRect(); // 버튼의 위치 정보 가져오기

            new daum.Postcode({
                oncomplete: function(data) {
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = data.roadAddress || data.jibunAddress;
                    document.getElementById("sample6_extraAddress").value = data.bname || '';

                    // 전체 주소 조합
                    var fullAddress = data.roadAddress || data.jibunAddress;
                    if (data.bname) {
                        fullAddress += ' ' + data.bname;
                    }
                    if (data.buildingName) {
                        fullAddress += ' ' + data.buildingName;
                    }

                    // STUDENT_ADDRESS textarea에 전체 주소 설정
                    var addressTextarea = document.getElementById("STUDENT_ADDRESS");
                    addressTextarea.value = fullAddress;

                    // 높이 조절
                    autoResizeTextarea(addressTextarea);

                    // 상세주소 입력 필드로 포커스 이동
                    document.getElementById("sample6_detailAddress").focus();
                },
                onclose: function(state) {
                    if (state === 'FORCE_CLOSE') {
                        hideAddressFieldsIfEmpty();
                    }
                },
                left: rect.left + window.scrollX,
                top: rect.top + window.scrollY + element_layer.offsetHeight
            }).open();
        }
    </script>
    <%@ include file="footer.jsp" %>
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
