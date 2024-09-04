<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%

	String info_id=request.getParameter("id");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
			pstmt=conn.prepareStatement("SELECT * FROM member WHERE id=?");
			pstmt.setString(1,info_id);
			rs=pstmt.executeQuery();
			
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
</style>
</head>
<body>
<%
		if(rs!=null && rs.next()){
%>
<table>
	<tr>
		<td>아이디 : </td>
		<td><%=rs.getString("id") %></td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><%=rs.getString("password") %></td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td><%=rs.getString("name") %></td>
	</tr>
	<tr>
		<td>생년월일 : </td><td><%=rs.getString("birth") %></td>
	</tr>
	<tr>
		<td>성별 : </td><td><%=rs.getString("gender") %></td>
	</tr>
	<tr>
		<td>이메일 주소 : </td>
		<td><%=rs.getString("mail") %></td>
	</tr>
	<tr>
		<td colspan=2><a href="member_list.jsp">리스트로 돌아가기</a></td>
	</tr>
</table>
<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>
