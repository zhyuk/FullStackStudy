<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="vo.NoticeBean"%>
<%
    NoticeBean notice = (NoticeBean)request.getAttribute("notice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 수정</title>

<style type="text/css">

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    /* 제목과 공지 설정 체크박스 */
    #NOTICE_TITLE, #NOTICE_WRITER {
        width: 100%;
        height: 50px;
        padding: 10px;
        font-size: 16pt;
        margin: 10px;
        border-radius: 5px;
        box-sizing: border-box;
    }

    #IS_NOTICE {
        margin-left: 10px;
        transform: scale(1.2);
        font-size: 16pt;
    }

    /* 내용 입력란 스타일 */
    #NOTICE_CONTENT {
        width: 100%;
        height: 400px;
        padding: 10px;
        font-size: 16pt;
        border-radius: 5px;
        margin: 10px 10px 20px 10px;
        box-sizing: border-box;
        resize: vertical;
    }

    /* 파일 첨부 스타일 */
    .filebox {
        width: 100%;
        margin: 10px;
        font-size: 16pt;
    }

    .filebox input[type="file"] {
        width: 100%;
        padding: 10px;
        font-size: 16pt;
        border-radius: 5px;
        box-sizing: border-box;
        background-color: #fff;
        border: 1px solid #ccc;
    }

    /* 등록 및 취소 버튼 */
    #commandCell {
        text-align: center;
        margin-top: 20px;
    }

    #commandCell a {
        display: inline-block;
        background-color: #0B4DA2; /* 파란색 배경 */
        color: white; /* 글자색 흰색 */
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 16pt;
        margin: 0 10px;
        text-decoration: none;
        cursor: pointer;
    }

    #commandCell a:hover {
        background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
    }

    /* 이미지 미리보기 스타일 */
    #imagePreview {
        width: 100%;
        max-height: 300px;
        margin-top: 10px;
        display: none;
    }
</style>

</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

<div class="container" style="max-width: 1200px; margin: 0 auto; padding: 20px;">
    <h2>공지사항 수정</h2>
    <form action="noticeModifyPro.nt" method="post" enctype="multipart/form-data" name="modifyform">
        <!-- 제목 및 공지 설정 -->
        <input type="hidden" name="NOTICE_ID" value="<%=notice.getNotice_id()%>">
        <input type="hidden" name="page" value="${page}">
        
        <!-- 공지 설정 체크박스 -->
        <div style="display: flex; align-items: center; justify-content: end;">
            <c:if test="${sessionScope.id == 'admin'}">
               <label for="IS_NOTICE" style="font-size: 16pt;">
                    공지<input type="checkbox" id="IS_NOTICE" name="IS_NOTICE" value="1">
                </label>
            </c:if>
        </div>
        <input name="NOTICE_TITLE" type="text" id="NOTICE_TITLE" placeholder="제목을 입력해주세요" value="${notice.notice_title}" required>
        
        
        <!-- 작성자 입력란 -->
        <input type="text" name="NOTICE_WRITER" id="NOTICE_WRITER" value="<%=notice.getNotice_writer()%>" placeholder="작성자">

        <!-- 내용 입력란 -->
        <textarea id="NOTICE_CONTENT" name="NOTICE_CONTENT" placeholder="내용을 입력해주세요" required><%=notice.getNotice_content()%></textarea>

        <!-- 파일 첨부 -->
        <div class="filebox">
            <label for="NOTICE_FILE">파일 선택</label>
            <input name="NOTICE_FILE[]" type="file" id="NOTICE_FILE" multiple>
        </div>

        <!-- 본문에 이미지 넣기 -->
        <div class="filebox">
            <label for="NOTICE_IMG">본문에 넣을 이미지 선택</label>
            <input name="NOTICE_IMG[]" type="file" id="NOTICE_IMG" multiple onchange="previewImage(this);">
        </div>

        <!-- 수정 및 취소 버튼 -->
        <div id="commandCell">
            <a href="javascript:modifyNotice()">수정</a>
            <a href="javascript:history.go(-1)">취소</a>
        </div>
    </form>
</div>

<script type="text/javascript">
function modifyNotice(){
    document.modifyform.submit();
}

function previewImage(input) {
    const file = input.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const preview = document.getElementById("imagePreview");
            preview.src = e.target.result;
            preview.style.display = "block";
        }
        reader.readAsDataURL(file);
    }
}
</script>

<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
