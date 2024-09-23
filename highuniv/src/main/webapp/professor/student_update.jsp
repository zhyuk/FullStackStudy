<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.StudentVO"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>학생 업데이트</title>
</head>
<body>
	 <jsp:include page="../header.jsp"></jsp:include>
    <h1>학생 정보 수정</h1>
    <form action="/professor/studentupdate.pr" method="post" enctype="multipart/form-data" >
    	<input type="hidden" name="currentUrl" value="${currentUrl}" >
        <label for="student_id">학번</label>
        <input type="text" name="student_id" id="student_id" value="${student.student_id}" readonly ><br>
        
        <label for="student_pw">비밀번호</label>
        <input type="text" name="student_pw" id="student_pw" value="${student.student_pw}"><br>
        
        <label for="student_name">이름</label>
        <input type="text" name="student_name" id="student_name" value="${student.student_name}"><br>
        
        <label for="student_email">이메일</label>
        <input type="text" name="student_email" id="student_email" value="${student.student_email}"><br>
        
        <label for="student_ph">핸드폰번호</label>
        <input type="text" name="student_ph" id="student_ph" value="${student.student_ph}"><br>
        
        <label for="student_birth">생일</label>
        <input type="text" name="student_birth" id="student_birth" value="${student.student_birth}"><br>
        
        <label for="student_intoday">입학일</label>
        <input type="text" name="student_intoday" id="student_intoday" value="${student.student_intoday}"><br>
        
        <label for="student_year">학년</label>
        <input type="text" name="student_year" id="student_year" value="${student.student_year}"><br>
        
        <label for="student_major">전공</label>
        <input type="text" name="student_major" id="student_major" value="${student.student_major}"><br>
        
        <label for="student_address">주소</label>
        <input type="text" name="student_address" id="student_address" value="${student.student_address}"><br>
        
        <label for="student_gender">성별</label>
        <input type="text" name="student_gender" id="student_gender" value="${student.student_gender}"><br>
        
        <label for="student_staus">상태</label>
        <input type="text" name="student_status" id="student_status" value="${student.student_status}"><br>
        
        <label for="student_image">이미지</label>
        <input type="file" name="student_image" id="student_image" value="${student.student_image}"><br>
        
        <label for="student_use">사용가능상태</label>
        <input type="text" name="student_use" id="student_use" value="${student.student_use}"><br>
        
        <input type="submit" value="전송">
    </form>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>