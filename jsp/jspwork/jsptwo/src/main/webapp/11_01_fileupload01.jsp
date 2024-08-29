<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
<script>
	function addFileFnc() {
		/* .previousSibling : 노드단위. **공백까지도 포함한 텍스트. 나의 형제요소 중 바로 위의 형 요소 => <input type="file" name="filename1"> 
		** 공백까지 포함하기 때문에 input태그와 button 태그 사이에 공백 입력하면 안됨.
		.getAttribute("name").replace("filename", "")) + 1 : <input type="file" name="filename1"> 의 name 속성을 가져와서 filename을 빈 문자열로 대체. 
			=>  <input type="file" name="1"> +1 => <input type="file" name="2">
		*/
		let fileAttr = Number(document.getElementById("addFileBtn").previousSibling.getAttribute("name").replace("filename", "")) + 1; 
		
		let filesLength = document.querySelectorAll("input[type=file]").length;
		// let btn = document.getElementById("addFileBtn").cloneNode(true); btn 객체에 addFileBtn 아이디값을 가진 태그 복제함.
		let btn = document.getElementById("addFileBtn").cloneNode(true);
		document.getElementById("addFileBtn").remove();

		let ptag = document.createElement("p");
		ptag.innerHTML = '파 일 : <input type="file" name="filename'+ (fileAttr)+ '"><button type="button" id="addFileBtn" onclick="addFileFnc()">버튼 추가</button>';
		
		document.getElementById("filesDiv").appendChild(ptag);
		// <p>파 일 : <input type="file" name="filename2" multiple></p> 생성됨

		if (filesLength == 4) document.getElementById("addFileBtn").remove();
		// <p>파 일 : <input type="file" name="filename" multiple></p>가 4개만 생성된 후 사라짐. 5개만 올릴 수 있도록 제한
	}

	let extArr = [ "jpg", "png", "gif", "jpeg", "svg", "bmp", "webp" ];	
	window.onload = function() {
		// fileForm : input[name=fileForm] => form 태그 내 입력요소의 name속성을 기술할 경우 name속성명만 기술해도 된다.
		fileForm.addEventListener('submit', function(e) {
			
			let lenTF = false, extTF = false;
			let attrStr = document.querySelector("input[type=file]").getAttribute('multiple');
			let cnt = 0;
			let imgs;
			
			// multiple 속성이 존재하는 input type='file'만 가능
			// multiple : 파일 여러 개를 업로드할 수 있게하는 속성. 
			// .files : 업로드한 파일들을 "파일배열"형식으로 가져오는 속성 => 문자열 X 파일로 배열에 담아둠.
			if(attrStr == 'multiple'){
				//mutiple속성이 존재하는 input type='file'만 가능
				imgs = document.querySelector("input[type=file]").files;
				for (let i = 0; i < imgs.length; i++) {
					let extension = imgs[i].name.substring(imgs[i].name.lastIndexOf(".") + 1);
					extArr.forEach(function(obj) {
						if (obj == extension.toLowerCase()) cnt++;
					});
				}
			}else{
				imgs = document.querySelectorAll("input[type=file]");
				for (let i = 0; i < imgs.length; i++) {
					let extension = imgs[i].files[0].name.substring(imgs[i].files[0].name.lastIndexOf(".") + 1);
					extArr.forEach(function(obj) {
						if (obj == extension.toLowerCase()) cnt++;
					});
				}
			}
			
			if (cnt != imgs.length) alert("이미지 파일만 업로드 하실 수 있습니다.");
			else extTF = true;

			let filesLength = imgs.length;
			if (filesLength > 5) alert("파일은 최대 5개까지만 업로드할 수 있습니다.");
			else  lenTF = true;
			
			if (!(lenTF && extTF)) e.preventDefault(); //기본이벤트 방지
		});
	};
</script></head><body>
	<h2>MultipartRequest를 이용한 파일 업로드</h2>
	<dl><dd>
		- cos.jar파일 필요: 
		<a href="https://mvnrepository.com/artifact/com.servlets/cos/05Nov2002">다운 받기</a>
	</dd></dl>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="11_01_fileupload01_process.jsp">
		<fieldset name="fld">
			<legend>파일 업로드 폼</legend>
			<p> 이 름 : <input type="text" name="name"> </p>
			<p> 제 목 : <input type="text" name="subject"> </p>
			<p> 
			<input type="checkbox" name="sel" value="가">가
			<input type="checkbox" name="sel" value="나">나
			<input type="checkbox" name="sel" value="다">다
			</p>
			<div id="filesDiv">
				<p> 파 일 : <input type="file" name="filename" multiple='multiple'> </p>
<!-- 				<p>	파 일 : <input type="file" name="filename1"><button type="button" id="addFileBtn" onclick="addFileFnc()">버튼 추가</button></p> -->
			</div>
			<p> <input type="submit" value="파일 올리기"> </p>
		</fieldset>
	</form>
</body>
</html>






