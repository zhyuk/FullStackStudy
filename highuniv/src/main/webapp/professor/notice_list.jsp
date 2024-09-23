<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.NoticeBean"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    ArrayList<NoticeBean> noticeList = (ArrayList<NoticeBean>)request.getAttribute("noticeList");
    PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");

    if (pageInfo == null) {
        pageInfo = new PageInfo();
    }
    int listCount = pageInfo.getListCount();
    int nowPage = pageInfo.getPage();
    int maxPage = pageInfo.getMaxPage();
    int startPage = pageInfo.getStartPage();
    int endPage = pageInfo.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>공지사항</title>
<script>
        // 공지 취소 폼을 보여주거나 숨기는 함수
        function toggleNoticeCancelForm() {
            var form = document.getElementById("noticeCancelForm");
            var button = document.getElementById("toggleNoticeCancelButton");

            if (form.style.display === "none" || form.style.display === "") {
                form.style.display = "block"; // 폼을 보여줌
                button.value = "취소 목록 숨기기"; // 버튼 텍스트 변경
            } else {
                form.style.display = "none"; // 폼을 숨김
                button.value = "공지 취소"; // 버튼 텍스트 변경
            }
        }
</script>




<link rel="stylesheet" type="text/css" href="../css/notice_list.css">
<style type="text/css">
.notice-checkbox {
   display: none;
}
</style>
</head>

<body>

   <jsp:include page="../header.jsp"></jsp:include>

   <div class="container">
      <h1>공지사항</h1>
      <div class="notice_search_form">
         <form action="noticelist.nt" method="get">
            <input type="text" name="noticeSearch" placeholder="검색어를 입력해주세요"
               value="${param.noticeSearch}" autocomplete="on">
            <button type="submit">검색</button>
         </form>
      </div>

      <form action="setNoticeAsPublic.nt" method="post">
         <div class="notice_list">
            <table>
               <tr id="tr_top">
                  <th class="notice-checkbox">선택</th>
                  <!-- Checkboxes initially hidden -->
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>등록일</th>
                  <th style="white-space: nowrap;">조회수</th>
               </tr>

               <% if (noticeList != null && listCount > 0) { %>

               <!-- 공지사항 출력 -->
               <% for (int i = 0; i < noticeList.size(); i++) { %>
               <% if ("Y".equals(noticeList.get(i).getIs_notice())) { %>
               <tr>
                  <td style="color: red; font-weight: bold; white-space: nowrap;">[공지]&nbsp;</td>
                  <td style="text-align: left;"><a
                     href="<%= request.getContextPath() %>/professor/noticeDetail.nt?notice_id=<%= noticeList.get(i).getNotice_id() %>&page=<%= nowPage %>">
                        <%= noticeList.get(i).getNotice_title().length() <= 10 ? noticeList.get(i).getNotice_title() : noticeList.get(i).getNotice_title().substring(0, 11) + "..." %>
                  </a></td>
                  <td><%= noticeList.get(i).getNotice_writer() %></td>
                  <td><%= noticeList.get(i).getNotice_date() %></td>
                  <td><%= noticeList.get(i).getNotice_view() %></td>
               </tr>
               <% } %>
               <% } %>



               <!-- 일반 게시글 출력 -->
               <% for (int i = 0; i < noticeList.size(); i++) {
                            if (!"Y".equals(noticeList.get(i).getIs_notice())) { %>
               <tr>
                  <td class="notice-checkbox"><input type="checkbox"
                     name="notice_ids" value="<%= noticeList.get(i).getNotice_id() %>"></td>
                  <td><%= noticeList.get(i).getNotice_id() %></td>
                  <td style="text-align: left;"><a
                     href="<%= request.getContextPath() %>/professor/noticeDetail.nt?notice_id=<%= noticeList.get(i).getNotice_id() %>&page=<%= nowPage %>">
                        <%= noticeList.get(i).getNotice_title() %>
                  </a></td>
                  <td><%= noticeList.get(i).getNotice_writer() %></td>
                  <td><%= noticeList.get(i).getNotice_date() %></td>
                  <td><%= noticeList.get(i).getNotice_view() %></td>
               </tr>
               <% } } %>

               <% } else { %>
               <tr>
                  <td colspan="6" id="emptyArea">등록된 글이 없습니다.</td>
               </tr>
               <% } %>
            </table>
         </div>



         <!-- 페이지 네비게이션 -->
         <section id="pageList">
            <% if (nowPage <= 1) { %>
            [이전]&nbsp;
            <% } else { %>
            <a
               href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= nowPage - 1 %>">[이전]</a>&nbsp;
            <% } %>

            <% for (int a = startPage; a <= endPage; a++) {
                if (a == nowPage) { %>
            [<%= a %>]
            <% } else { %>
            <a
               href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= a %>">[<%= a %>]
            </a>&nbsp;
            <% } %>
            <% } %>

            <% if (nowPage >= maxPage) { %>
            [다음]
            <% } else { %>
            <a
               href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= nowPage + 1 %>">[다음]</a>
            <% } %>
         </section>
         <br>

         <!-- 명령어 목록 -->
         <c:if test="${sessionScope.role == 'professor'}">
            <section id="commandList" class="clear">
               <a
                  href="<%= request.getContextPath() %>/professor/noticeWriteForm.nt">
                  [등록] </a>
               <%--             <a href="<%= request.getContextPath() %>/professor/noticeDeleteForm.nt"> [삭제] </a> --%>
            </section>
         </c:if>
         <br>
         <!-- 공지 등록 버튼 -->
         <c:if test="${sessionScope.role == 'professor'}">
            <div style="text-align: center;">
               <input type="button" id="registerNoticeButton" value="공지 등록"
                  onclick="toggleCheckboxes()"> <input type="submit"
                  id="submitNoticeButton" value="공지 선택 완료" style="display: none;">
            </div>
         </c:if>
      </form>

      <br>
      <!-- 공지 취소 버튼 -->
      <c:if test="${sessionScope.role == 'professor'}">
         <div style="text-align: center;">
            <input type="button" id="toggleNoticeCancelButton" value="공지 취소"
               onclick="toggleNoticeCancelForm()">
         </div>
      </c:if>
      <br>

      <!-- 공지 취소 폼 (초기에 숨김 처리) -->
      <div id="noticeCancelForm" style="display: none;">
         <form action="setNoticeAsPrivate.nt" method="post">
            <div class="notice_list">
               <table>
                  <tr>
                     <th colspan="6">공지 취소</th>
                  </tr>
                  <!-- 공지 체크박스 추가 -->
                  <% for (int i = 0; i < noticeList.size(); i++) { 
                        if ("Y".equals(noticeList.get(i).getIs_notice())) { %>
                  <tr>
                     <td><input type="checkbox" name="notice_ids"
                        value="<%= noticeList.get(i).getNotice_id() %>"></td>
                     <td>[공지 취소 가능]</td>
                     <td style="text-align: left;"><%= noticeList.get(i).getNotice_title() %></td>
                     <td><%= noticeList.get(i).getNotice_writer() %></td>
                     <td><%= noticeList.get(i).getNotice_date() %></td>
                     <td><%= noticeList.get(i).getNotice_view() %></td>
                  </tr>
                  <% } } %>
               </table>
            </div>
            <br>
            <!-- 공지 취소 버튼 -->
            <div style="text-align: center;">
               <input type="submit" value="공지 취소">
            </div>
         </form>
      </div>




      <!-- 스크립트: 체크박스 토글 -->
      <script>
            function toggleCheckboxes() {
                var checkboxes = document.getElementsByClassName("notice-checkbox");
                var registerButton = document.getElementById("registerNoticeButton");
                var submitButton = document.getElementById("submitNoticeButton");

                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].style.display === "none" || checkboxes[i].style.display === "") {
                        checkboxes[i].style.display = "table-cell";
                    } else {
                        checkboxes[i].style.display = "none";
                    }
                }

                if (registerButton.value === "공지 등록") {
                    registerButton.value = "돌아가기";
                    submitButton.style.display = "inline-block";
                } else {
                    registerButton.value = "공지 등록";
                    submitButton.style.display = "none";
                }
            }
        </script>
   </div>
   <jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>