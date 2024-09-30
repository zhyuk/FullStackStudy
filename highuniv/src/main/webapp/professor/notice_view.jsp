<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.NoticeBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    NoticeBean notice = (NoticeBean)request.getAttribute("notice");
	String content = notice.getNotice_content();
	content = content.replaceAll("\\n", "<br>"); // 줄바꿈을 <br>로 변환
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
<!--     <link rel="stylesheet" type="text/css" href="../css/notice_list.css"> -->

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.link {
	text-decoration: underline;
	color: #005ACD;
}

#articleForm {
	width: 100%;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	padding: 10px;
	margin: 10px;
	position: relative;
	height: 50px;
	text-align: left;
	border-top: solid 2px #000;
	border-bottom: solid 2px #000;
}

#basicInfoArea h3 {
	float: left;
}

#basicInfoArea p {
	float: right;
}

#articleNameArea {
	display: flex;
	align-items: center;
	justify-content: space-between;
	widht: 100%;
	height: 30px;
	margin: 10px;
	padding: 0 10px;
	text-align: right;
	margin-bottom: 0px;
}

#articleNameArea .btn-list {
	display: flex;
}

#articleNameArea .btn-list li {
	margin: 0 5px;
}

#articleContentArea {
	background: #EAEAED;
	padding: 10px;
	margin: 10px;
	min-height: 350px;
	height: fit-content;
	border-top: solid 2px #000;
}

#articleFileArea {
	widht: 100%;
	height: 30px;
	margin: 10px;
	padding: 0 10px;
	text-align: right;
	margin-top: 0px;
}


#commandList {
	margin: auto;
	width: 100%;
	text-align: center;
}

#imgDiv {
	position: absolute;
	top: 0;
	left: 20px;
	width: 90%;
	height: 250px;
	border: 1px solid #ccc;
	border-radius: 8px;
	overflow-y: auto;
	background-color: #fff;
	padding: 0px;
}

#commentsSection {
	margin: 10px;
	border-top: solid 2px #000;
}

#commentsSection .comment {
	margin-top: 10px;
}

#commentsSection .comment div strong {
	
}

#commentsSection .comment div span {
	float: right;
	font-size: 14px;
	color: #242424;
}

#commentsSection .comment div:nth-of-type(2) {
	margin-top: 10px;
	border-bottom: solid 1px #ccc;
}

#commentsSection .comment div p {
	display: inline-block;
	width: calc(100% - 40px);
	margin-bottom: 10px;
}

#commentsSection .comment div button {
	width: 35px;
	float: right;
	border: none;
	cursor: pointer;
}

#comment {
	border: 1px solid #ccc;
	width: 100%;
	height: 100px;
	padding: 10px;
	overflow: auto;
}

#commentwrite {
	display: flex;
	justifiy-content: center;
	width: 100%;
	padding: 10px 0;
	/* 	border: 1px solid #ccc; */
}

#commentwrite strong {
	width: 50px;
	line-height: 60px;
	text-align: center;
}

#commentwrite textarea {
	width: calc(100% - 100px);
	height: 60px;
	padding: 5px;
	border-radius: 5px 0 0 5px;
}

#commentwrite button {
	width: 50px;
	border: 1px solid #242424;
	border-radius: 0 5px 5px 0;
}

img {
	display: block;
}

#commandList a {
	display: inline-block;
	background-color: #0B4DA2; /* 파란색 배경 */
	color: white; /* 글자색 흰색 */
	padding: 10px 20px; /* 내부 여백 */
	text-decoration: none; /* 밑줄 제거 */
	border-radius: 5px; /* 둥근 테두리 */
	font-weight: bold; /* 글자 두껍게 */

}

#commandList a:hover {
	background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
}

input, textarea {
	font-size: 16px;
}
</style>

<script> 

function confirmDelete(notice_id){
if (confirm("정말로 삭제하시겠습니까?")){
		location.href = "<%=request.getContextPath() %>/professor/noticeDeletePro.nt?notice_id=" + notice_id;
	}
}


</script>


</head>
<body>

    <jsp:include page="../header.jsp"></jsp:include>
    
    
        <h2>공지사항</h2>
        <section id = "articleForm">
	        <div id="basicInfoArea">
			        <h3><%= notice.getNotice_title() %></h3>
			</div>
				<div id="articleNameArea">
			        <div><%= notice.getNotice_writer() %></div>
			        <div><%= notice.getNotice_date() %></div>
			    </div>
		    
		    
		    
		    
		    
			<!-- 파일 첨부 (우측 상단) -->
			
		    <div id="articleFileArea">
		        <% 
		            if (notice.getNotice_file() != null && !notice.getNotice_file().isEmpty()) {
		                String[] files = notice.getNotice_file().split(",");
		                for (String file : files) {
		        %>
		                    첨부파일: <a class="link" href="filedown.nt?fname=<%= file.trim() %>"><%= file.trim() %></a><br>
		        <%
		                }
		            }
		        %>
		    </div>
		    
             <!-- 본문 내용 출력 (HTML 태그 포함) -->
            <div id="articleContentArea">
                <%= content %> <!-- 변환된 content 변수를 출력 -->
            </div>
            </section>
            
            
            
            
           <section id="commandList">
				<c:if test="${sessionScope.id == 'admin' || sessionScope.id == notice.notice_writer_id}">
					<a href="noticeModifyForm.nt?notice_id=<%=notice.getNotice_id() %>&page=${page}"> 수정 </a>
				</c:if>
                <a href="<%= request.getContextPath() %>/professor/noticeList.nt" class="button">목록</a>
                <c:if test="${sessionScope.id == 'admin' || sessionScope.id == notice.notice_writer_id}">
                <a href="javascript:void(0);" onclick="confirmDelete(<%=notice.getNotice_id() %>)"> 삭제 </a>
                </c:if>
           </section>
</body>
</html>










