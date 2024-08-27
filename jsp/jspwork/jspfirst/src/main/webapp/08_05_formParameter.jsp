<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Map"%>

<%
// request의 데이터 영역에 저장된 데이터(post 방식)의 인코딩만 설정할 때 사용함.
// get 방식은 인코딩 안됨. get 방식은 방식에 따라 웹페이지의 인코딩이나 브라우저의 인코딩으로 적용됨
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 객체의 파라미터를 가져오는 메소드 종류</title>
</head>
<body>
	<h1>request 객체의 파라미터를 가져오는 메소드 종류</h1>
	<b>request.getParameter("파라미터의 name명과 대소문자 반드시 일치") : </b> 한 개의 인자값만을 가져오는 경우 사용한다.<br><br>
	
<!-- 	request.getParameter("name") -> request 객체에 접근해서 Parameter 객체 접근해서 그 내부에 있는 address 속성의 속성값 가져온다는 의미 -->
	name 파라미터 = <%= request.getParameter("name") %><br>
	address 파라미터 = <%= request.getParameter("address") %><br>
	<br><hr><br>
	
	<b>request.getParameterValues() : </b> 여러 개의 인자값을 가져오는 경우 사용한다. 배열 객체를 이용하여 받을 수 있다.<br><br>
	<%
	// request.getParameterValues("pet"); --> request 객체에 접근해서 배열로 되어있는 속성 pet의 속성값을 가져온다. 값이 없을 경우 null 반환
	String[] values = request.getParameterValues("pet");
	out.print("values: " + values + "<br>");
	if(values != null){
		for(int i = 0; i < values.length; i++) {
			out.println(values[i]);
		}
		
// 		for(String i : values) {
// 			out.println(i);
// 		}
	}
	%>
	<hr><br>
	<b>request.getParameterNames() : </b> 인자값에 매칭되어 있는 name 속성값을 가져온다. 동일한 속성명은 1개만 가져온다.<br><br>
	
	<%
	int i = 0;
	Enumeration<String> paramEnum = request.getParameterNames(); // "name" "address" "pet"
	while(paramEnum.hasMoreElements()){ // hasMoreElements() :  다음 요소가 있는지 탐색만. 있으면 true, 없으면 false 반환 
		i++;
		String name = paramEnum.nextElement(); // 다음 요소를 가져와 name 변수에 저장.
		out.print("폼 요소의 name속성명 [" + i + "번] : " + name + "<br>" ); // 출력
	}
	%>
</body>
</html>