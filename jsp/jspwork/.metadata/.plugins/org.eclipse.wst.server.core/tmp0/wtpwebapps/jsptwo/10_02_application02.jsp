<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 사용하여 자원 읽기</title>
</head>
<body>
	<%-- 자바의 path 경로 내 "/" : 이 앞에 컨텍스트까지 존재합니다. 라는 의미임.
		즉, /message/notice.txt -> http://localhost:8090/jsptwo/message/notice.txt
		만약 webapp 폴더 안에 test 폴더 안에 message 폴더가 존재한다면 /message/notice.txt는 오류임.
		==> /test/message/notice.txt로 기술해야한다.
	--%>
	<% String resourcePath = "/message/notice.txt"; %>
	자원의 실제 경로(절대 경로): <%= application.getRealPath(resourcePath) %> <%-- 절대경로를 가져오는 방법 --%>
	
	<br><hr><br>
	<%= resourcePath %>의 내용
	<br><hr><br>
	
	<%
		// char 자료형의 기본값은 공백 1칸임
		char[] buff = new char[128];
		int len = -1;
		
		try {
			// Stream 방식(바인드 변수로 읽음) 을 Reader 방식(문자형으로 읽음)으로 바꿔 읽어옴
			/* application.getResourceAsStream(resourcePath) : url에 있는 자원을 InputStream으로 읽어옴. 
			=> InputStreamReader(application.getResourceAsStream(resourcePath), "UTF-8") : Reader 방식으로 변경해서 가져옴. 값 손상 방지로 UTF-8 선언 */
			InputStreamReader br = new InputStreamReader(application.getResourceAsStream(resourcePath), "UTF-8");
			while((len = br.read(buff)) != -1){ //br.read(buff) : 데이터가 있는 만큼만 칸에 넣고 남은 칸은 제거함.
				out.print(new String(buff, 0, len));
			}
			out.print("<br>");
		} catch(IOException ex){
			out.println("익셉션 발생: " + ex.getMessage());
		}
	%>
</body>
</html>