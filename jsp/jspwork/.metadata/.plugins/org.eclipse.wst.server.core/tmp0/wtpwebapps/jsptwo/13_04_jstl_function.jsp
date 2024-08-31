<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수 사용</title>
</head>
<body>
	<% String str1 = "Functions &lt;태그&gt;를 사용합니다. "; %>
	<c:set var="str1" value="<%= str1 %>"/>
	<c:set var="str2" value="사용"/>
	
	str1 = ${str1}<br>
	str2 = ${str2}<br>
	<%-- EL 표기법의 좋은 점 : 값이 없으면 null 혹은 오류가 아닌 그냥 출력을 안함. --%>
	tokens = ${tokens} <br><hr>
	
	length(str1) = ${fn:length(str1)}<br>
	toUpperCase(str1) = "${fn:toUpperCase(str1)}" <br>
	toLowerCase(str1) = "${fn:toLowerCase(str1)}" <br>
	
	<!-- substring(변수, 시작인덱스, 마지막인덱스) : 변수를 시작인덱스부터 마지막인덱스-1까지 짤라서 가져옴.  -->
	substring(str1, 3, 6) = "${fn:substring(str1, 3, 6)}" <br>
	<!-- substringAfter(변수1, 변수2) : 변수1에 변수2의 값을 찾고 해당 값 뒤쪽 부분을 짤라서 가져옴. -->
	substringAfter(str1, str2) = "${fn:substringAfter(str1, str2)}" <br>
	<!-- substringAfter(변수1, 변수2) : 변수1에 변수2의 값을 찾고 해당 값 앞쪽 부분을 짤라서 가져옴. -->
	substringBefore(str1, str2) = "${fn:substringBefore(str1, str2)}" <br>
	
	<!--  trim() : 맨앞 맨뒤 공백 제거 -->
	trim(str1) = "${fn:trim(str1)}" <br>
	<!-- replace(요소, 대체할 값, 대체될 값) :대체할 값에 해당되는 값을 대체될 값으로 대체  -->
	replace(str1, src, dest) = "${fn:replace(str1, " ", "-")}" <br>
	indexOf(str1, str2) = "${fn:indexOf(str1, str2)}" <br>
	
	startsWith(str1, 'Fun') = "${fn:startsWith(str1, 'Fun')}" <br>
	endsWith(str1, '합니다') = "${fn:endsWith(str1, '합니다')}" <br>
	contains(str1, str2) = "${fn:contains(str1, str2)}"
	 <br>
	
	<c:set var="smStr" value="java Server Page"/>
	<c:set var="lgStr" value="JAVA"/>
	containsIgnoreCase(str1, str2) = "${fn:containsIgnoreCase(smStr, lgStr)}"<br>
	
	<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10"/>
	<c:set var="arr" value="${fn:split(tokens, ',')}"/>
	join(arr,"-") = "${fn:join(arr, "-")}" <br>
	
</body>
</html>