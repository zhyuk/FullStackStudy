<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <title>테스트</title>
    </head>
    <body>
		<%
		
			String id = (String) session.getAttribute("id");
		
			if ( id != null){ // request.getRequestURI() : sqlproject01/auth/main.jsp -> URL에서 컨택스트 뒤부터 쿼리문 전까지 
				if (request.getRequestURI().contains("/member")  && !id.equals("admin")) {
					out.println("<script>");
					out.print("location.href='"+request.getContextPath()+"/loginForm.jsp';");
					out.println("</script>");
				}
			}else{
				out.print("<script>");
				out.print("location.href='"+request.getContextPath()+"/loginForm.jsp';");
				out.print("</script>");
			}
		%>
    </body>
    </html>