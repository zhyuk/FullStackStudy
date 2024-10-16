<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try{
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test";
			String password = "1111";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결이 성공되었습니다.");
			String inputId = request.getParameter("id");
			String inputPw = request.getParameter("password");
			
			// 정적쿼리문
			String sql = "delete from member where id = '" + inputId + "'and password = '" + inputPw + "'";
			// 동적쿼리문
			String ps_sql = "delete from member where id = ? and password = ?";
			
			st = conn.createStatement();
			int cnt = st.executeUpdate(sql);
			if(cnt > 0) out.print("정상처리되었습니다.");
			else out.print("처리하는데 실패하였습니다.");
			
			// 동적쿼리 처리
			ps = conn.prepareStatement(ps_sql);
			ps.setString(1, inputId);
			ps.setString(2, inputPw);
			int ps_cnt = ps.executeUpdate();
			if(ps_cnt > 0) out.print("정상처리되었습니다.");
			else out.print("처리하는데 실패하였습니다.");
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(st != null) ps.close();
			if(conn != null) conn.close();
		}
	%>
</body>
</html>