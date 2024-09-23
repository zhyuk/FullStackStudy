<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 리스트</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/student_list.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.student_delete_btn').click(function(){
                var student_id = $(this).val();
                var currentPage = new URLSearchParams(window.location.search).get('page') || 1;
                var isConfirmed = confirm(student_id + "를 삭제하시겠습니까?");
                if (isConfirmed) {
                    $.ajax({
                        url: "studentdelete.pr",
                        type: "post",
                        data: {student_id: student_id, currentPage: currentPage},
                        success: function(data){
                            alert('삭제 성공');
                            window.location.href = "studentlist.pr?page=" + data.map.currentPage;
                        },
                        error: function(){
                            alert('삭제 실패');
                        }
                    });
                }
            });

            $('.student_update_btn').click(function(){
                var student_id = $(this).val();
                var currentUrl = window.location.href;
                window.location.href = "studentupdate.pr?student_id=" + encodeURIComponent(student_id) + "&currentUrl=" + encodeURIComponent(currentUrl);
            });
        });
    </script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
    <div class="container">
        <h1>학생정보</h1>
        <div class="student_search_form">
            <form action="studentlist.pr" method="get">
                <input type="text" name="studentSearch" placeholder="검색할 이름을 입력하세요" value="${param.studentSearch}" autocomplete="off">
                <button type="submit">검색</button>
            </form>
        </div>

        <c:choose>
            <c:when test="${ not empty studentList}">
                <div class="student_list">
                    <table>
                        <tr>
                            <th>학번</th>
                            <th>전공</th>
                            <th>이름</th>
                            <th>성별</th>
                            <th>상태</th>
                            <th>전화번호</th>
                            <th>이메일</th>
                            <th colspan="2"></th>
                        </tr>
                        <c:forEach var="student" items="${studentList}">
                            <tr>
                                <td>${student.student_id}</td>
                                <td>${student.student_major}</td>
                                <td>${student.student_name}</td>
                                <td>${student.student_gender}</td>
                                <td>${student.student_status}</td>
                                <td>${student.student_ph}</td>
                                <td>${student.student_email}</td>
                                <td><button type="button" class="student_update_btn" value="${student.student_id}">수정</button></td>
                                <td><button type="button" class="student_delete_btn" value="${student.student_id}">삭제</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <!--페이지 네비게이션-->
		        <div>
		            <c:choose>
		                <c:when test="${pageInfo.page <= 1}">[이전]</c:when>
		                <c:otherwise>
		                    <a href="studentlist.pr?page=${pageInfo.page-1}">[이전]</a>
		                </c:otherwise>
		            </c:choose>
		            <c:forEach var="a" begin="${pageInfo.startPage}" end="${pageInfo.endPage}" step="1">
		                <c:choose>
		                    <c:when test="${a == pageInfo.page}"><span style="color:red;font-weight:bolder;">[${a}]</span></c:when>
		                    <c:otherwise><a href="studentlist.pr?page=${a}">[${a}]</a></c:otherwise>
		                </c:choose>
		            </c:forEach>
		            <c:choose>
		                <c:when test="${pageInfo.page == pageInfo.maxPage}">[다음]</c:when>
		                <c:otherwise><a href="studentlist.pr?page=${pageInfo.page+1}">[다음]</a></c:otherwise>
		            </c:choose>
		        </div>
            </c:when>
            <c:otherwise> <!-- 데이터가 없을경우  -->
                <div class="student_list">
                    <table>
                    	<tr>
                            <th>학번</th>
                            <th>전공</th>
                            <th>이름</th>
                            <th>성별</th>
                            <th>상태</th>
                            <th>전화번호</th>
                            <th>이메일</th>
                            <th colspan="2"></th>
                        </tr>
                        <tr>
                            <td colspan="9">등록된 학생이 없습니다.</td>
                        </tr>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
