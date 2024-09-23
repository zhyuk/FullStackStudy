<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 작성</title>
<link rel="stylesheet" type="text/css" href="../css/notice_list.css">
<style type="text/css">
	/* 이미지 미리보기 스타일 */
	#imagePreview {
	    width: 100%;
	    max-height: 300px;
	    margin-top: 10px;
	    display: none;
	}
</style>

<script type="text/javascript">
function previewImage(input) {
    const file = input.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const preview = document.getElementById("imagePreview");
            preview.src = e.target.result;
            preview.style.display = "block";
        }
        reader.readAsDataURL(file);
    }
}
</script>

</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<!-- <section id="writeForm"> -->
	<div class="container">
		<h2>공지사항 글 작성</h2>
		<form action="noticeWritePro.nt" method="post" enctype="multipart/form-data" name="noticeform">
			<table>
				<tr>
					<td class="td_left"><label for="NOTICE_TITLE">제 목</label></td>
					<td class="td_right"><input name="NOTICE_TITLE" type="text" id="NOTICE_TITLE" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_WRITER">작성자</label></td>
					<td class="td_right"><input type="text" name="NOTICE_WRITER" id="NOTICE_WRITER" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="NOTICE_CONTENT">내 용</label></td>
					<td><textarea id="NOTICE_CONTENT" name="NOTICE_CONTENT" cols="40" rows="15" required></textarea></td>
				</tr>
				<!-- 파일 첨부 -->
		        <tr>
		            <td class="td_left"><label for="NOTICE_FILE"> 파일 첨부 </label></td>
		            <td class="td_right"><input name="NOTICE_FILE[]" type="file" id="NOTICE_FILE" multiple></td>
		        </tr>
		
		        <!-- 이미지 첨부 -->
		        <tr>
		            <td class="td_left"><label for="NOTICE_IMG"> 이미지 첨부 </label></td>
		            <td class="td_right"><input name="NOTICE_IMG[]" type="file" id="NOTICE_IMG" multiple></td>
		        </tr>

			</table>
			
			
			<br>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" >
			</section>
		</form>
<!-- 	</section> -->
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>