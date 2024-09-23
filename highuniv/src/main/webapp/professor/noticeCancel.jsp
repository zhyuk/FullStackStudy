<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.NoticeBean"%>
<%@ page import="java.util.*"%>

<%
    ArrayList<NoticeBean> publicNotices = (ArrayList<NoticeBean>)request.getAttribute("publicNotices");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>공지 취소</title>
    <link rel="stylesheet" type="text/css" href="../css/notice_list.css">
</head>
<body>
 <jsp:include page="../header.jsp"></jsp:include>
    <h1>공지 취소 목록</h1>
    
    <form action="setNoticeAsPrivate.nt" method="post">
        <div class="notice_list">
            <table>
                <tr>
                    <th>선택</th>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>조회수</th>
                </tr>

                <!-- 전체 공지 사항 출력 -->
                <% for (int i = 0; i < publicNotices.size(); i++) { %>
                    <tr>
                        <td><input type="checkbox" name="notice_ids" value="<%= publicNotices.get(i).getNotice_id() %>"></td>
                        <td><%= publicNotices.get(i).getNotice_id() %></td>
                        <td style="text-align: left;">
                            <%= publicNotices.get(i).getNotice_title() %>
                        </td>
                        <td><%= publicNotices.get(i).getNotice_writer() %></td>
                        <td><%= publicNotices.get(i).getNotice_date() %></td>
                        <td><%= publicNotices.get(i).getNotice_view() %></td>
                    </tr>
                <% } %>
            </table>
        </div>
        
        <br>
        <!-- 공지 취소 버튼 -->
        <div style="text-align:center;">
            <input type="submit" value="공지 취소">
        </div>
    </form>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
