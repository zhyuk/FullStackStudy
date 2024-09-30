<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="vo.NoticeBean"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    ArrayList<NoticeBean> noticeList = (ArrayList<NoticeBean>) request.getAttribute("noticeList");
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>


<link rel="stylesheet" type="text/css" href="../css/notice_list.css">

<style type="text/css">

#searchForm {
    text-align: center; /* 검색 폼 전체를 중앙 정렬 */
    margin-bottom: 20px; /* 아래 여백 추가 */
}


.inputId {
    width: 200px; /* 입력 창 너비 */
}


.notice-checkbox {
   display: none;
}

div.notice-buttons {
    text-align: center;
}

input[type="button"],
input[type="submit"] {
    display: inline-block;
    margin: 0 10px; /* 두 버튼 사이에 10px 간격 */
}



#searchForm select, 
#searchForm input[type="text"], 
#searchForm input[type="submit"] {
    display: inline-block; /* 요소들을 한 줄에 배치 */
   height: 40px;
   margin: 5px; /* 각 요소들 사이의 간격 */
   padding: 8px;
   font-size: 16px;

}

#searchForm input[type="submit"] {
   border-radius: 5px;
   width: 85px;
   background-color: #0B4DA2; /* 파란색 배경 */
   color: white; /* 글자색 흰색 */
   font-weight: bold; /* 글자 두껍게 */
   border: none;
   
}


#searchForm input[type="submit"]:hover {
   background-color: #0056b3; /* 마우스 오버 시 어두운 파란색 */
}


#commandList {
    text-align: right; /* 오른쪽 정렬 */
    margin-top: 40px; /* 위쪽 여백 */
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


input {
height: 45px; 
border: 1px solid black;
}

button {
 border-radius: 10px;
 width: 60px;
 height: 45px;
}
tr, td { height : 50px;}


button.inputId, button.submitBtn {
    cursor: pointer;
}

#pageList {
margin-top : 30px;
}



</style>
</head>

<body>

   <jsp:include page="../header.jsp"></jsp:include>

   <div class="container">
      <h1 style="margin-bottom: 15px;">공지사항</h1>
      
      

      <form action="setNoticeAsPublic.nt" method="post">
         <div id="noticeList" class="notice_list">
            <table>
               <tr id="tr_top">
                  <th class="notice-checkbox">선택</th>
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
                        <%= noticeList.get(i).getNotice_title().length() <= 40 ? noticeList.get(i).getNotice_title() : noticeList.get(i).getNotice_title().substring(0, 41) + "..." %>
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
                  <td style="text-align: left;">
                  	<a href="<%= request.getContextPath() %>/professor/noticeDetail.nt?notice_id=<%= noticeList.get(i).getNotice_id() %>&page=<%= nowPage %>">
                        <%= noticeList.get(i).getNotice_title().length() <= 40 ? noticeList.get(i).getNotice_title() : noticeList.get(i).getNotice_title().substring(0, 41) + "..." %>
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

         <!-- 명령어 목록 -->
         <c:if test="${sessionScope.role == 'professor'}">
            <section id="commandList" class="clear">
               <a href="<%= request.getContextPath() %>/professor/noticeWriteForm.nt">등록</a>
            </section>
         </c:if>
		</form>
  	 </div>
   <br>
   
   <!-- 페이지 네비게이션 -->
   <section id="pageList">
       <div style="text-align: center;">
            <% if (nowPage <= 1) { %>
            [이전]&nbsp;
            <% } else { %>
            <a href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= nowPage - 1 %>">[이전]</a>&nbsp;
            <% } %>

            <% for (int a = startPage; a <= endPage; a++) {
                if (a == nowPage) { %>
            <span style="color:red; font-weight: bold;">[<%= a %>]</span>
            <% } else { %>
            <a href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= a %>">[<%= a %>]</a>&nbsp;
            <% } %>
            <% } %>

            <% if (nowPage >= maxPage) { %>
            [다음]
            <% } else { %>
            <a href="<%= request.getContextPath() %>/professor/noticeList.nt?page=<%= nowPage + 1 %>">[다음]</a>
            <% } %>
       </div>
   </section>
   <br>
   
   <section id="searchForm">
		    <form action="noticeSearch.nt" method="get"id="searchFoam" name="search-form">
		       <select name="type" class="type-box">
		            <option value="notice_title">제목</option>
		            <option value="notice_content">내용</option>
		            <option value="notice_writer">작성자</option>
		            <option value="notice_title,notice_content">제목 + 내용</option>
		        </select>
		        <input class="inputId" type="text" name="keyword" placeholder="검색어 입력">
		        <input class="submitBtn" type="submit" value="검색">
		    </form>
		</section>
   
   <jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>