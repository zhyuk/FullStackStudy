
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="vo.NoticeBean" %>
<%
    int notice_id=(Integer)request.getAttribute("notice_id");
    String nowPage = (String)request.getAttribute("page");
    List<NoticeBean> noticeList = (List<NoticeBean>)request.getAttribute("noticeList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style>

    #passForm{
        width:400px;
        margin:auto;
        border : 1px solid orange;
    }
    
</style>
</head>
<body>

<section id = "passForm">
<form name="deleteForm" action="noticeDeletePro.nt?notice_id=<%=notice_id %>" method="post">
    <input type = "hidden" name = "page" value = "<%=nowPage %>">
    <table>
    <tr>
        <td>
            <label>글 비밀번호 : </label>
        </td>
        <td>
            <input name="NOTICE_PASS" type="password" id = "NOTICE_PASS">
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value = "삭제">&nbsp;&nbsp;
            <input type = "button" value = "돌아가기" onClick ="javascript:history.go(-1)">
        </td>
    </tr>
    </table>
</form>
</section>



</body>
</html>