$(document).ready(function(){ 
	$( window ).resize(function() {
		var windowWidth = $( window ).width();
		if(windowWidth >= 978) {
			$("#subNavMenu").hide();
		}
	});
	
	$("#clMenu").click(function(){
		$("#subNavMenu").toggle();
	});
	
	$("#conWrite").click(function(){
		location.href = "insertBoard.jsp";
	});
	
	$("#conDel").click(function(){
		let con_test = confirm("정말로 삭제하시겠습니까?");
		if(con_test == true){
			let v = document.fm.seq.value;
			location.href = "deleteBoard.do?seq="+v;
		}
		else if(con_test == false){
		  	return false;
		}
	});
	
	$("#conList").click(function(){
		location.href = "getBoardList.do";
	});
});

function selTr(val){
	location.href = "getBoard.do?seq="+val;
}

function selUser(val){
	location.href = "selUser.do?id="+val;
}

function delUser(val, url, msg){
	if(val == 'admin'){
		alert(msg);
	}else{
		if(confirm("정말로 삭제하시겠습니까?")) location.href=url+"?id="+val;
		else return;
	}
}

function chk(){
	if($("#id").val() == 'admin' && $("#role").val() =='User'){
		alert('관리자는 역할을 변경하실 수 없습니다.');
		return false;
	}else{
		return true;
	}
}
