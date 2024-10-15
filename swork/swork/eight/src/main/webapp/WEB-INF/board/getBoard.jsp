<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<%
	String sts = "";
	if(session.getAttribute("userId") == null){
		 sts = "disabled";
	}
%>
<body>
<div class="jumbotron"><h1>상세 보기</h1></div>
<%@ include file="../../menu.jsp" %>  

<div class="container-fluid">

  <form name="fm" action="updateBoard.do" method="post">
  	<input type="hidden" name="seq" value="${board.seq}">
  	
<!-- 1. ---------------------------------------------- -->
    <div class="input-group mb-3">
<div class="input-group-prepend"><span class="input-group-text">제목</span></div>
<input type="text" class="form-control innm" name="title" value="${board.title}" <%=sts %>>
    </div>
    
<!-- 2. ---------------------------------------------- -->    
    <div class="input-group mb-3">
<div class="input-group-prepend"><span class="input-group-text">작성자</span></div>
<input type="text" class="form-control innm" name="writer" value="${board.writer}" <%=sts %> readonly>
    </div>
    
<!-- 3. ---------------------------------------------- -->        
    <div class="input-group mb-3">
<div class="input-group-prepend"><span class="input-group-text">내용</span></div>
<textarea class="form-control innm" rows="10" id="comment" name="content" <%=sts %>>${board.content}</textarea>
    </div>
    
<!-- 4. ---------------------------------------------- -->
    <div class="input-group mb-3">
<div class="input-group-prepend"><span class="input-group-text">등록일</span></div>
<input type="text" class="form-control innm" name="regdate" value="${board.regdate}" readonly <%=sts %>>      
    </div>
    
<!-- 5. ---------------------------------------------- -->
    <div class="input-group mb-3">
<div class="input-group-prepend"><span class="input-group-text">조회수</span></div>
<input type="text" class="form-control innm" name="cnt" value="${board.cnt}" readonly <%=sts %>>      
    </div>
    
<!-- footer ---------------------------------------------- -->    
    <div id="footer">
	  	<button type="submit" class="btn btn-primary" <%=sts %>>글수정</button>
	  	<button id="conWrite" type="button" class="btn btn-primary" <%=sts %>>글쓰기</button>
	  	<button id="conDel" type="button" class="btn btn-primary" <%=sts %>>글삭제</button>
	  	<button id="conList" type="button" class="btn btn-primary">글목록</button>
	</div>
  </form>
</div>

</body>
</html>


