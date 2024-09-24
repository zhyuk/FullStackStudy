<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<title>하이대학교</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.js"></script>
		<style>
			* {
				margin: 0;
				padding: 0;
				box-sizing: border-box;
				list-style: none;
			}

			.btn {
				cursor: pointer;
			}

			body {
				background: #EAEAED;
			}

			section {
				width: 600px;
				height: 100vh;
				margin: 0 auto;
				padding: 50px;
				background: #005ACD;
				color: #EAEAED;
				font-weight: 700;
				/* border: 1px solid red; */
			}

			section h1 {
				margin-bottom: 140px;
				text-align: center;
				font-size: 50px;
			}

			label {
				font-size: 24px;
			}

			input {
				width: 100%;
				height: 50px;
				padding: 0 10px;
				border-radius: 10px;
				border: none;
				font-size: 20px;
			}

			.message {
				margin: 10px 0;
				color: red;
			}

			button {
				width: 100%;
				height: 60px;
				margin-top: 50px;
				font-weight: 700;
				font-size: 30px;
				border-radius: 10px;
				border: none;
			}

			@media screen and (max-width: 425px) {
				main {
					display: flex;
				}
			}
		</style>
	</head>

	<body>
		<div id="wrap">
			<main>
				<section>
					<h1>교수 회원가입</h1>

					<form action="join" method="post">
						<label for="id">아이디(학번)</label> <input type="text" id="id" name="id">
						<p class="message"></p>
						<label for="pw">비밀번호</label> <input type="text" id="pw" name="pw">
						<p class="message"></p>
						<label for="name">이름</label> <input type="text" id="name" name="name">
						<p class="message"></p>
						<label for="email">이메일</label> <input type="text" id="email" name="email">
						<p class="message"></p>
						<label for="phone">전화번호</label> <input type="text" id="phone" name="phone">
						<p class="message"></p>

						<button type="submit" id="submitBtn">회원가입</button>
					</form>
				</section>
			</main>
		</div>

		<script>
			$(document).ready(function () {
				// 폼의 submit 버튼 클릭 시
				$("form").submit(function (event) {
					let nullChk = false;
					let elements = document.querySelectorAll("input");

					elements.forEach(function (obj) {
						console.log(obj.value);

						if (obj.value == '') {
							event.preventDefault();
							$(obj).next("p").text("* 필수 입력 요소입니다.");
							nullChk = true;
						}
					});
					if (nullChk) {
						alert("필수 입력 요소는 생략할 수 없습니다.");
					}

				});
			});

			$("input").on('blur', function () {
				if ($(this).val() == '') {
					$(this).next("p").text("* 필수 입력 요소입니다.");
				} else {
					$(this).next("p").text("");
				}
			});
		</script>
	</body>

	</html>