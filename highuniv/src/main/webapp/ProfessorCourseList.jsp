<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의 정보 페이지</title>
    <style>
        /* 기존 스타일 유지 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        /* 추가 및 삭제 버튼 스타일 */
        .btn {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        /* 강의 컨테이너 */
        .lecture-container {
            display: flex;
            justify-content: space-between;
            margin: 20px 0;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
/*             position: relative; /* 삭제 버튼을 위한 설정 */ */
        }
       .lecture-image {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 200px; /* 고정된 높이 설정 */
        overflow: hidden; /* Hide overflow if image size exceeds container */
    }
    .lecture-image img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지가 컨테이너를 꽉 채우도록 설정 */
    }
        .lecture-details {
            flex: 3;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .lecture-details h2 {
            margin-top: 0;
            font-size: 24px;
        }
        .lecture-details p {
            margin: 10px 0;
            color: #333;
        }
        .professor-info {
            flex: 1;
            background-color: #ececec;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            text-align: center;
            position: relative;
        }
        .professor-info p {
            margin: 0;
            font-size: 18px;
        }
        .delete-button {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        
        /* 수정 버튼 스타일 추가 */
    .edit-button {
        position: absolute;
        top: 10px;
        right: 80px; /* 삭제 버튼과 겹치지 않도록 조정 */
        background-color: #28a745; /* 녹색 배경색 */
        color: white;
        border: none;
        padding: 5px 10px;
        cursor: pointer;
        border-radius: 5px;
    }
        @media (max-width: 768px) {
            .lecture-container {
                flex-direction: column;
            }
            .lecture-image, .lecture-details, .professor-info {
                flex: 1;
                padding: 10px;
            }
            .delete-button {
                right: 10px;
            }
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
   <!-- 강의 추가 버튼 -->
<a href="${pageContext.request.contextPath}/addLecture.jsp" class="btn">강의 추가</a>

 <!--<a href="${pageContext.request.contextPath}/ProfessorLectureServlet" class="btn">강의목록</a>-->

    

    <!-- 강의 목록 출력 -->
    <c:forEach var="subject" items="${subjectList}" varStatus="status">
        <div class="lecture-container">
            <div class="lecture-image">
    <c:choose>
     
                <c:when test="${subject.IMAGE_NAME ne null && subject.IMAGE_NAME.startsWith('upload_')}">
<%--                     <img src="${pageContext.request.contextPath}/uploads/${subject.IMAGE_NAME}" alt="강의 이미지" style="max-width: 100%; max-height: 100%;"> --%>
                    <img src="${pageContext.request.contextPath}/uploads/${subject.IMAGE_NAME}" alt="강의 이미지" style="max-width: 100%; max-height: 100%;">
                </c:when>
    
   
        <c:when test="${subject.IMAGE_NAME ne null}">
            <!-- 동적으로 이미지 출력 -->
            <img src="<%=request.getContextPath() %>/uploads/${subject.IMAGE_NAME}" alt="강의 이미지" style="max-width: 100%; max-height: 100%;">
<%--             <img src="<%=request.getContextPath() %>/image/${subject.IMAGE_NAME}" alt="강의 이미지" style="max-width: 100%; max-height: 100%;"> --%>
        </c:when>
        <c:otherwise>
            <!-- 이미지가 없을 경우 기본 이미지 출력 -->
            <img src="${pageContext.request.contextPath}/IMAGE/default.jpg" alt="강의 이미지" style="max-width: 100%; max-height: 100%;">
        </c:otherwise>
    </c:choose>
</div>

            <div class="lecture-details">
                <h2> ${subject.SUBJECT_NAME}</h2>
                <p> ${subject.SUBJECT_CONTENT}</p>
                <p>강의 시간 : ${subject.SUBJECT_DAY} ${subject.SUBJECT_STARTTIME} ~ ${subject.SUBJECT_ENDTIME}</p>
                <p>학점 : ${subject.SUBJECT_CREDIT}학점</p>
            </div>
            <div class="professor-info">
                <p>교수 | ${subject.PROFESSOR_NAME}</p>
                <!-- 수정 버튼 추가 -->
        <button class="edit-button" onclick="editSubject('${subject.SUBJECT_ID}')">수정</button>
            <!-- 삭제 버튼 -->
            <button class="delete-button" onclick="deleteSubject('${subject.SUBJECT_ID}')">삭제</button>
            </div>
            
            
        </div>
    </c:forEach>
    
    <!-- 수정 기능을 위한 스크립트 추가 -->
<script>
    function editSubject(subjectId) {
        // 수정 페이지로 이동
        window.location.href = '${pageContext.request.contextPath}/EditLectureServlet?subjectId=' + subjectId;
    }
</script>


    <!-- 삭제 기능을 위한 스크립트 -->
    <script>
    function deleteSubject(subjectId) {
        if (confirm('정말로 삭제하시겠습니까?')) {
            // 삭제를 위한 폼 생성 및 제출
            var form = document.createElement('form');
            form.method = 'post';
            // 서블릿의 URL 매핑으로 변경
            form.action = '${pageContext.request.contextPath}/ProfessorLectureServlet';

            var inputAction = document.createElement('input');
            inputAction.type = 'hidden';
            inputAction.name = 'action';
            inputAction.value = 'delete';
            form.appendChild(inputAction);

            var inputId = document.createElement('input');
            inputId.type = 'hidden';
            inputId.name = 'subjectId';
            inputId.value = subjectId;
            form.appendChild(inputId);

            document.body.appendChild(form);
            form.submit();
        }
    }
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
