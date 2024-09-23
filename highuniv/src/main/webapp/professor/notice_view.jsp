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
    <title>공지사항</title>
    <link rel="stylesheet" type="text/css" href="../css/notice_list.css">

<style>
#post-date, #post-writer, #post-file { 
    text-align: right;
} 
#post-content, #post-title {
    text-align: left;
}   
#post-title {
    font-weight:bold;
}
</style>
</head>
<body>

    <jsp:include page="../header.jsp"></jsp:include>
    
    <div class="container">
        <h1>공지사항</h1><br>

        <div id="content">
          <div id="post-title">
              <%= notice.getNotice_title() %>
          </div>
          <div id="post-date">
              <%= notice.getNotice_date() %>
          </div>
          <div id="post-writer">
              <%= notice.getNotice_writer() %>
          </div>
      
          <!-- 파일 첨부 (우측 상단) -->
          <div id="post-file" style="text-align:right;">
              <% 
                  if (notice.getNotice_file() != null && !notice.getNotice_file().isEmpty()) {
                      String[] files = notice.getNotice_file().split(",");
                      for (String file : files) {
              %>
                          첨부파일: <a href="filedown.nt?fname=<%= file.trim() %>"><%= file.trim() %></a><br>
              <%
                      }
                  }
              %>
          </div><br>
          
          
             <!-- 본문 내용 출력 (HTML 태그 포함) -->
            <div id="post-content">
                <%= content %> <!-- 변환된 content 변수를 출력 -->
            </div>
            
            <br>
            <div id="nav">
                <a href="noticeModifyForm.nt?notice_id=<%=notice.getNotice_id() %>&page=${page}"> [수정] </a>
                <a href="<%= request.getContextPath() %>/professor/noticeList.nt" class="button">목록</a>
                <a href="noticeDeleteForm.nt?notice_id=<%=notice.getNotice_id() %>&page=${page}"> [삭제] </a>
            </div>
        </div>

    </div>
     
</body>
</html>
