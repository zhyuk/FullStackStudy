<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ include file="header.jsp" %>
<body>
<script>

	function sendRequest() {
		$.ajax({
	        method:"GET", 
	        url : 'test.do',
	        success : function(data) {
	        	let a = data.split(" ");
	        	let t = a[1].split(":");
	        	let tm = t[0]+":"+t[1]+":"+t[2];
	        	
	        	document.getElementById("text").innerHTML = "현재 접속  시각: "+tm;
	        },
	        error:function(request,status){
	            alert("오류가 발생했습니다.");
	        }
	    });
	}
	
	window.setInterval("sendRequest()", 1000);	// 매 1초마다 Ajax 요청을 보냄.	
	
</script>
<div class="jumbotron" style="background-color: #ccc!important;text-align:center;padding-bottom:30px!important">
	<div class="container">
		<h1 class="display-3">환영합니다</h1>
		<h3>Welcome to Gesipan!</h3>
	</div>
</div>	

<%@ include file="menu.jsp" %>  
	<div class="container">
		<div class="text-center">
			<span id="text"></span><br>
		</div>
		<hr>
	</div>	
</body>
</html>