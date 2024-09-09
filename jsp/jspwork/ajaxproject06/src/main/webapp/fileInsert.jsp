<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = () => {
		document.getElementById("btn").onclick = function() {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					console.log("response: " + xhttp.responseText);
					document.getElementById("fileInsertDiv").innerHTML = xhttp.responseText;
				};
			};
			xhttp.open("GET", "fileInsert", true);
			xhttp.send();
		};
	};
</script>
</head>

<body>
	<button type="button" id="btn">클릭</button>
	<br>
	<div id="fileInsertDiv"></div>
</body>
</html>