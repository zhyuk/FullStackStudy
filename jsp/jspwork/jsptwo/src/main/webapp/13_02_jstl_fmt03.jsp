<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internationalization (i18n - 국제화)</title>
</head>
<body>
	<!--  fmt : jstl의 fmt 사용했기 때문에 사용. -->
	<p>숫자 : <fmt:formatNumber value="3200100"/></p>
	<p>기본값(천단위구분) : <fmt:formatNumber value="3200100" type="number"/></p>
	<!--  groupingUsed="false" : 천단위 구분을 해제. 기본값이 true임 -->
	<p>기본값(천단위안함) : <fmt:formatNumber value="3200100" type="number" groupingUsed="false"/></p><hr>
	
	<!-- type="currency" : 통화기호까지 기본으로 포함. 기본값은 해당 국가를 인식해서 해당 통화기호를 붙여줌. 화폐단위는 센트의 개념도 있어 소수점이 붙음 -->
	<p>기본값(천단위구분, 통화기호 기본 포함) : <fmt:formatNumber value="3200100" type="currency"/></p>
	<p>기본값(천단위구분, 통화기호 설정) : <fmt:formatNumber value="3200100" type="currency" currencySymbol="&#8361;"/></p>
	<p>기본값(천단위구분, 통화기호 설정) : <fmt:formatNumber value="3200100" type="currency" currencySymbol="$"/></p><hr>
	
	<!-- percent : 백분률 표기법. %로 나타내줌 -->
	<p>기본값(비율로 표현) : <fmt:formatNumber value="0.45" type="percent"/></p><hr>
	
	
	<!-- minIntegerDigits="10" : 최소 10자리 표현, minFractionDigits="2" : 소수점 자리 2자리 표현 -->
	<p>정수 최소 10자리 표현, 소수점 2자리 표현 : <fmt:formatNumber value="3200100" minIntegerDigits="10" minFractionDigits="2"/></p>
	<!-- 버그 있음 : 소수점 자리 2자리로 설정했으나 소수점 3자리 출력됨. 따라서 패턴으로 처리하는 것을 권장 -->
	<p>[버그]정수 최소 10자리 표현, 소수점 2자리 표현 : <fmt:formatNumber value="3200100.456" minIntegerDigits="10" minFractionDigits="2"/></p>
	<!-- pattern=",###.000" : 내가 원하는 패턴으로 지정. 기본값으로 groupingUsed 속성이 false 처리됨.
		# : 해당 자리에 표현할 값이 없으면 표현 X, 0 : 해당 자리에 표현할 값이 없으면 0으로 표현 -->
	<p>소수점 3자리 표현. 빈 곳은 0으로 표시 : <fmt:formatNumber value="3200100.45" pattern=",###.000"/></p><hr>
	
	<p>천단위 구분.소수점 두 자리 수까지 표현. 세번째서 반올림 : <fmt:formatNumber value="3200155.456" pattern="#,#00.0#"/></p>
	<!--  소수점 2자리 표현으로 했으나 소수점 1자리만 출력. 마지막이 #이라 없으면 출력 X  -->
	<p>천단위 구분.소수점 두 자리 수까지 표현. 세번째서 반올림 : <fmt:formatNumber value="3200155.4" pattern="#,#00.0#"/></p>
</body>
</html>