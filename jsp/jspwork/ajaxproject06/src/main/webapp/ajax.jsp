<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
    <style>
        table,
        th,
        td {
            border: 1px solid #000;
        }
    </style>
    <script>
        $(() => {
            $(".button").onclick = () => {
                $.ajax({
                    url: "ajaxCon",
                    type: "get",
                    // async : falase,
                    success: (data) => {
                        $("#divBox").empty();

                        let str = "<table>";
                        str += "<tr><th>아이디</th><th>이름</th><th>주소</th><th>성별</th></tr>";

                        $.each(data, (i, v) => {
                            str += "<tr><td>" + v.id + "</td><td>" + v.name + "</td><td>" + v.address + "</td><td>" + v.gender + "</td></tr>";
                        });
                        str += "</table>";

                        $("#divBox").append(str);
                        alert("완성");
                    },
                    error: () => {
                        alert('error');
                    }
                });

                console.log('추가');
                let str = "<p>데이터 추가하기</p>";
                $("#ConBox").html(str);
            };
        });
    </script>
</head>

<body>
    <button type="button">확인</button><br><br>
    <div id="divBox"></div>
    <br><br>
    <div id="ConBox"></div>
</body>
</html>