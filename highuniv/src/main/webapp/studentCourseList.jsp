<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생 강의 조회 페이지</title>
    <style>
        /* 강의 정보 페이지 전체 스타일 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }

        /* 강의 컨테이너 */
        .lecture-container {
            display: flex;
            justify-content: space-between;
            margin: 20px 0;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            position: relative;
        }

        /* 강의 이미지 섹션 (왼쪽) */
        .lecture-image {
            flex: 1;
            background-color: #d8d8d8; /* 이미지가 없는 경우의 배경색 */
            display: flex;
            justify-content: center;
            align-items: center;
            color: #666;
            font-size: 18px;
        }

        /* 강의 상세 정보 섹션 (중앙) */
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

        /* 교수 정보 섹션 (오른쪽) */
        .professor-info {
            flex: 1;
            background-color: #ececec;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            text-align: center;
        }

        .professor-info p {
            margin: 0;
            font-size: 18px;
        }

        /* 반응형 디자인을 위한 미디어 쿼리 */
        @media (max-width: 768px) {
            .lecture-container {
                flex-direction: column;
            }

            .lecture-image, .lecture-details, .professor-info {
                flex: 1;
                padding: 10px;
            }
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


    <c:forEach var="subject" items="${subjectList}" varStatus="status">
    
        <!-- 강의 정보 카드 -->
        <div class="lecture-container">
            <div class="lecture-image">
                <!-- 이미지 표시 -->
<%--                <img src="<%=request.getContextPath() %>/image/${subject.IMAGE_NAME}"alt="강의 이미지" style="max-width: 100%; max-height: 100%;"> --%>
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
            </div>
        </div>
         
    </c:forEach>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


    
