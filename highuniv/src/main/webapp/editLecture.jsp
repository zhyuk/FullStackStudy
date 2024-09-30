<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="vo.Subject" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1>강의 수정</h1>

<form action="${pageContext.request.contextPath}/EditLectureServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="subjectId" value="${subject.SUBJECT_ID}">

    <div class="form-group">
        <label for="subjectName">강의명</label>
        <input type="text" id="subjectName" name="subjectName" value="${subject.SUBJECT_NAME}" required>
    </div>

    <div class="form-group">
        <label for="subjectContent">강의 내용</label>
        <textarea id="subjectContent" name="subjectContent" rows="5" required>${subject.SUBJECT_CONTENT}</textarea>
    </div>

    <div class="form-group">
        <label for="subjectDay">강의 요일</label>
        <input type="text" id="subjectDay" name="subjectDay" value="${subject.SUBJECT_DAY}" required>
    </div>

    <div class="form-group">
                <label for="subjectStartTime">시작 시간</label>
                <input type="text" id="subjectStartTime" name="subjectStartTime" required>
            </div>

     <div class="form-group">
                <label for="subjectEndTime">종료 시간</label>
                <input type="text" id="subjectEndTime" name="subjectEndTime" required>
            </div>

    <div class="form-group">
        <label for="subjectCredit">학점</label>
        <input type="number" id="subjectCredit" name="subjectCredit" value="${subject.SUBJECT_CREDIT}" required>
    </div>
    
    <!-- 이미지 업로드 필드 추가 -->
    <div class="form-group">
        <label for="imageName">강의 이미지</label>
        <input type="file" id="imageName" name="imageName" accept="image/*">
        <!-- 기존 이미지가 있는 경우 보여주기 -->
        <c:if test="${not empty subject.IMAGE_NAME}">
            <img src="${pageContext.request.contextPath}/uploads/${subject.IMAGE_NAME}" alt="강의 이미지" style="max-width: 200px; margin-top: 10px;">
        </c:if>
    </div>

    <button type="submit" class="btn">수정 완료</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>