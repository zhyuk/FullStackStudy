<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><title>File Upload</title></head>
<body>
	<h2>Part를 이용한 파일 업로드</h2>
	<p>별도의 라이브러리가 필요없다.(서블릿 3.0버전 이상부터 가능)</p>
	<p>톰캣의 context.xml파일에 설정 필요</p>
	
	<small style="color:red">
	Multipart 처리를 위해서는 allowCasualMultipartParsing 옵션을 꼭 추가해주어야 한다.
	</small><br>
	
	<small style="color:red">
	xml파일이나 java파일을 수정하는 경우는 꼭 톰캣 서버를 종료한 후에 수정해야 한다.
	</small>
	<pre style="border:1px solid #555">
		<br><code>
		&lt;Context allowCasualMultipartParsing="true" path="/"&gt;
			&lt;Resources cachingAllowed="true" cacheMaxSize="1048576" /&gt;
			
			... 그외의 기존 내용들 그대로 둘 것
		&lt;/Context&gt;
		
		만약, 업로드하는 파일의 총 용량이 2MB를 초과하는 경우에는 톰캣의 파일 업로드 용량을 수정해주어야 한다. 
		톰캣 서버에서 허용하는 파일의 용량은 2MB까지만 가능하므로 해당 파일 용량을 변경하려면 
		톰캣의 server.xml파일에 설정이 필요하다.
		&lt;Connector maxPostSize="-1"  기존 내용 그대로.... /&gt;
		
		**maxPostSize값은 1이상의 Byte단위의 값이 올 수 있다. 1kb로 설정하고자 하는 경우 1024로 설정
		**0미만의 값은 용량을 무제한으로 처리한다는 의미이다.
		</code>
	</pre>
	
	<form name="fileForm" method="post" enctype="multipart/form-data" action="11_03_fileupload03_process.jsp">
		<fieldset>
		<legend>파일 업로드 폼</legend>
		<p>	이 름  : <input type="text" name="name"></p>
		<p>	제 목 : <input type="text" name="subject"></p>
		<p>	파 일 : <input type="file" name="filename" multiple="multiple"></p>
		<p>	<input type="submit" value="파일 올리기"></p>
		</fieldset>
	</form>
</body>
</html>