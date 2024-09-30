<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의 추가 페이지</title>
    <style>
        /* 강의 추가 페이지 스타일 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            margin-top: 0;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .form-group textarea {
            resize: vertical;
        }

        .btn-submit {
            display: block;
            width: 100%;
            padding: 10px;
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
    <div class="form-container">
        <h2>강의 추가</h2>
        <!-- Change enctype to multipart/form-data -->
        <form action="AddSubjectServlet" method="POST" enctype="multipart/form-data">
        	<div class="form-group">
                <label for="subjectId">과목 ID</label>
                <input type="text" id="subjectId" name="subjectId" required>
            </div>
        
            <div class="form-group">
                <label for="subjectId">과목 ID</label>
                <input type="text" id="subjectId" name="subjectId" required>
            </div>
            <div class="form-group">
                <label for="subjectName">과목명</label>
                <input type="text" id="subjectName" name="subjectName" required>
            </div>
            <div class="form-group">
                <label for="subjectSemester">학기</label>
                <input type="text" id="subjectSemester" name="subjectSemester" required>
            </div>
            <div class="form-group">
                <label for="subjectCredit">학점</label>
                <input type="number" id="subjectCredit" name="subjectCredit" required>
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
                <label for="subjectDay">요일</label>
                <input type="text" id="subjectDay" name="subjectDay" required>
            </div>
            <div class="form-group">
                <label for="professorId">교수 ID</label>
                <input type="text" id="professorId" name="professorId" required>
            </div>
            <div class="form-group">
                <label for="subjectRoom">강의실</label>
                <input type="text" id="subjectRoom" name="subjectRoom" required>
            </div>
            <div class="form-group">
                <label for="subjectContent">과목 설명</label>
                <textarea id="subjectContent" name="subjectContent" rows="4"></textarea>
            </div>
           
            <div class="form-group">
                <label for="lectureImage">강의 이미지</label>
                <input type="file" id="lectureImage" name="lectureImage" accept="image/*">
            </div>
            <button type="submit" class="btn-submit">추가</button>
        </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
