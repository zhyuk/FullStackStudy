<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		Context ctx = new InitialContext();
		DataSource ds = (javax.sql.DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();
		out.print("conn: " + conn);
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>