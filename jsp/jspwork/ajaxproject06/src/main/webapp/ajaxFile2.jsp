<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<script>
//     $(() => {
//         $("button").click(() => {
//             let idval = { "id": document.frm.id.value };
//             $.ajax({
//                 url: "loginCheck",
//                 type: "post",
//                 // data : {"id" : document.frm.id.value},
//                 data: idval,
//                 //보내는 데이터 타입
//                 contentType: "application/x-www-form-urlencoded; charset=utf-8",
//                 // contentType : "application/json; charset=utf-8",
//                 // data : JSON.stringify(idval),
//                 dataType: "json", //서버에서 클라이언트로 전송받는 자료의 데이터타입
//                 cache: false,
//                 success: (data) => {
//                     console.log("success");
//                     alert(data.map.id + '는 ' + data.map.str);
//                 },
//                 error: () => {
//                     alert('error');
//                 }
//             });
//         });
//     });

    window.onload = () => {
        document.getElementsByTagName("button")[0].onclick = () => {
            alert('클릭');
            var xhttp = new XMLHttpRequest();

            xhttp.responseType = "json"; // jQuery의 dataType: "json"와 동일한 의미
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    console.log('response: ' + xhttp.response);
                    let data = xhttp.response;
                    alert(data.map.id + "는 " + data.map.str);
                }
            };

            xhttp.open("POST", "loginCheck", true);

            // JS에서 form-data 타입으로 데이터를 전송할 경우, 해당 방법으로 기술해야함.
//             var formElement = document.getElementsByTagName("frm")[0];
//             var formdata = new FormData(formElement);
//             xhttp.send(formdata);

            // JS에서 json 타입으로 데이터를 전송할 경우
            xhttp.setRequestHeader('content-type', 'json');
            var formdata = { "id": document.frm.id.value };
            xhttp.send(JSON.stringify(formdata)); // form-data를 json 방식으로 보내는 방법.
        };
    };
</script>
</head>
<body>
    <form name="frm">
        <input type="text" name="id">
        <button type="button">아이디 중복체크</button>
    </form>
</body>
</html>