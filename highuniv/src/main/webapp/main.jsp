<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="vo.NoticeBean" %>
<%@ page import="vo.BoardBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>하이대학교 LMS</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
	    var images = $('.slide-img'); // 이미지 선택
	    var currentIndex = 0; // 현재 이미지 인덱스
	
	    // 초기에 첫 번째 이미지를 보이도록 설정
	    images.css({ opacity: 0 }).eq(currentIndex).css({ opacity: 1 });
	
	    function changeImage(index) {
	        // 현재 이미지를 부드럽게 사라지게 함
	        images.eq(currentIndex).animate({ opacity: 0 }, 1000);
	        currentIndex = index; // 인덱스 변경
	        // 다음 이미지를 부드럽게 나타나게 함
	        images.eq(currentIndex).animate({ opacity: 1 }, 1000);
	    }
	
	    // 자동 슬라이드
	    var autoSlide = setInterval(function() {
	        changeImage((currentIndex + 1) % images.length);
	    }, 5000);
	
	    // 화살표 클릭 이벤트
	    $('.left-arrow').click(function() {
	        clearInterval(autoSlide); // 자동 슬라이드 중지
	        var newIndex = (currentIndex - 1 + images.length) % images.length; // 이전 이미지 인덱스 계산
	        changeImage(newIndex);
	        autoSlide = setInterval(function() { // 자동 슬라이드 재시작
	            changeImage((currentIndex + 1) % images.length);
	        }, 5000);
	    });
	
	    $('.right-arrow').click(function() {
	        clearInterval(autoSlide); // 자동 슬라이드 중지
	        var newIndex = (currentIndex + 1) % images.length; // 다음 이미지 인덱스 계산
	        changeImage(newIndex);
	        autoSlide = setInterval(function() { // 자동 슬라이드 재시작
	            changeImage((currentIndex + 1) % images.length);
	        }, 5000);
	    });
	    
	    $('td').each(function() {
	    	if ($(this).text().trim() === '[공지]') {
	    		$(this).closest('tr').css('background-color', 'rgb(255 238 211 / 50%)'); // 원하는 색상으로 변경
	    	}
	    });
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="main_container">
		<div class="main_img">
			<div class="arrow left-arrow">&#10094;</div> <!-- 왼쪽 화살표 -->
		    <img src="./image/mainimg/메인이미지1.png" class="slide-img">
		    <img src="./image/mainimg/메인이미지2.png" class="slide-img">
		    <div class="arrow right-arrow">&#10095;</div> <!-- 오른쪽 화살표 -->
		</div>
		<div class="main_content">
			<div class="main_notice">
			<h1>공지사항</h1>
			<c:choose>
				<c:when test="${ not empty noticeList}">
					<table>
						<tr>
							<th>번호</th>
			                <th>제목</th>
			                <th>등록일</th>
						</tr>
						<c:forEach var="notice" items="${noticeList}">
							<tr>
								<c:choose>
									<c:when test="${notice.is_notice == 'Y'}">
										<td style="color: red; font-weight: bold; white-space: nowrap;">[공지]</td>
									</c:when>
									<c:otherwise>
										<td>${notice.notice_id}</td>
									</c:otherwise>
								</c:choose>
								<td><a href="<%= request.getContextPath() %>/professor/noticeDetail.nt?notice_id=${notice.notice_id}&page=1">${notice.notice_title}</a></td>
		                        <td>${notice.notice_date}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<th>번호</th>
			                <th>제목</th>
			                <th>등록일</th>
						</tr>
						<tr>
							<th colspan="3">등록된 공지사항이 없습니다.</th>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</div>
			
			<div class="main_board">
			<h1>게시판</h1>
			<c:choose>
				<c:when test="${ not empty boardList}">
					<table>
						<tr>
							<th>번호</th>
			                <th>제목</th>
			                <th>등록일</th>
						</tr>
						<c:forEach var="board" items="${boardList}">
							<tr>
								<c:choose>
									<c:when test="${board.BOARD_NUM =='0'}">
										<td style="color: red; font-weight: bold; white-space: nowrap;">[공지]</td>
									</c:when>
									<c:otherwise>
										<td>${board.BOARD_NUM}</td>
									</c:otherwise>
								</c:choose>					
		                        <td><a href="boardDetail.bo?board_no=${board.BOARD_NO}&page=1" >${board.BOARD_SUBJECT}</a></td>
		                        <td>${board.BOARD_DATE}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<th>번호</th>
			                <th>제목</th>
			                <th>등록일</th>
						</tr>
						<tr>
							<th colspan="3">등록된 게시글이 없습니다.</th>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>