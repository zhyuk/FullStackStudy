//아이디 중복검사
$(document).ready(function () {
	$('#id_chk').click(function (event) {
		const student_id = $('#student_id').val();
		event.preventDefault();
		$.ajax({
			url: "studentinto.pr",
			type: "get",
			data: { student_id: student_id},
			success: function (data) {
				alert(data.meg);
			},
			error: function () {
				alert('중복검사 실패');
			}
		});

	});
});


// 전송 버튼을 눌렀을 때 유효성 검사를 확인한 후 폼을 제출하는 함수
function validateAndSubmit() {
	// 개별 유효성 검사 함수 호출
	handleIdBlur();
	handlePasswordBlur();
	handleNameBlur();
	handleMajorBlur();
	handlePhoneNumberBlur();
	handleEmailBlur();
	handleBirthDateBlur();
	handleYearBlur();
	handleStatusBlur();
	handleGenderBlur();

	// 모든 에러 메시지가 display: block인 경우 경고 메시지를 표시, 아니면 폼 제출
	if (document.querySelectorAll('.error-message[style*="display: block"]').length === 0) {
		// 폼이 유효한 경우 제출
		document.getElementById("studentForm").submit();
	} else {
		alert("모든 필드를 올바르게 입력해주세요.");
	}
}
	/*상태 유효성 */

	function validateStatus() {
		const statusElement = document.getElementById("student_status");
		const status = statusElement.value;
		return status !== "";
	}

	function handleStatusBlur() {
		const errorMessage = document.getElementById("statusErrorMessage");

		if (!validateStatus()) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	/* 생년월일 유효성	 */

	function validateBirthDate() {
		const birthElement = document.getElementById("student_birth");
		const birthDate = new Date(birthElement.value);
		const today = new Date();

		if (!birthElement.value || birthDate >= today) {
			return false;
		}
		return true;
	}

	function handleBirthDateBlur() {
		const errorMessage = document.getElementById("birthErrorMessage");

		if (!validateBirthDate()) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	/* 학년 유효성 */
	function validateYear(year) {
		return year !== "";
	}

	function handleYearBlur() {
		const yearElement = document.getElementById("student_year");
		const year = yearElement.value;
		const errorMessage = document.getElementById("yearErrorMessage");

		if (!validateYear(year)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}
	
	/* 성별 유효성 */
	function validateGender() {
		const genderElement = document.getElementById("student_gender");
		const gender = genderElement.value;
		return gender !== "";
	}

	function handleGenderBlur() {
		const errorMessage = document.getElementById("genderErrorMessage");

		if (!validateGender()) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}
	

	/* 전공 유효성 */
	function validateMajor(major) {
		return major !== "";
	}
	function handleMajorBlur() {
		const majorElement = document.getElementById("student_major");
		const major = majorElement.value;
		const errorMessage = document.getElementById("majorErrorMessage");

		if (!validateMajor(major)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	/* 이메일 유효성 */

	function validateEmail(email) {
		const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		return emailRegex.test(email);
	}

	function handleEmailBlur() {
		const emailElement = document.getElementById("student_email");
		const email = emailElement.value.trim();
		const errorMessage = document.getElementById("emailErrorMessage");

		if (!validateEmail(email)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	/* 비밀번호 유효성 */
	function handlePasswordBlur() {
		const passwordElement = document.getElementById("student_pw");
		const password = passwordElement.value.trim(); // 공백 제거한 비밀번호 값
		const errorMessage = document.getElementById("passwordErrorMessage");
	
		// 빈값일 때 에러메세지 표시
		if (password === "") {
			errorMessage.style.display = "block"; // 에러 메시지 보이기
		} else {
			errorMessage.style.display = "none"; // 에러 메시지 숨기기
		}
	}

	/* 이름 유효성 */
	function validateName(name) {
		const nameRegex = /^[가-힣a-zA-Z]+$/;
		return nameRegex.test(name);
	}
	function handleNameBlur() {
		const nameElement = document.getElementById("student_name");
		const name = nameElement.value.trim();
		const errorMessage = document.getElementById("nameErrorMessage");

		if (!validateName(name)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	/* 학번 유효성 검사 */
	function validateId(id) {
		const idRegex = /^\d{8}$/;
		return idRegex.test(id);
	}
	function handleIdBlur() {
		const idElement = document.getElementById("student_id");
		const id = idElement.value.trim();
		const errorMessage = document.getElementById("idErrorMessage");
		if (!validateId(id)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}
	/* 핸드폰번호 유효성 검사 */
	function validatePhoneNumber(phoneNumber) {
		const phoneRegex = /^01[0-9]-?\d{3,4}-?\d{4}$/;
		return phoneRegex.test(phoneNumber);
	}
	function handlePhoneNumberBlur() {
		console.log("Blur event triggered"); // 디버깅을 위해 추가
		const phoneElement = document.getElementById("student_ph");
		const phoneNumber = phoneElement.value.trim();
		const errorMessage = document.getElementById("phoneErrorMessage");
		if (!validatePhoneNumber(phoneNumber)) {
			errorMessage.style.display = "block";
		} else {
			errorMessage.style.display = "none";
		}
	}

	// 이미지 리사이즈 및 미리보기
	function resizeImage(file, callback) {
		const reader = new FileReader();
		
		reader.onload = function(event) {
			const img = new Image();
			img.src = event.target.result;
	
			img.onload = function() {
				const canvas = document.createElement('canvas');
				const ctx = canvas.getContext('2d');
	
				// 원하는 크기로 설정
				const width = 150;
				const height = 180;
	
				canvas.width = width;
				canvas.height = height;
	
				// 이미지 크기 조정 및 그리기
				ctx.drawImage(img, 0, 0, width, height);
	
				// 이미지 미리보기
				const resizedImageUrl = canvas.toDataURL('image/jpeg'); // 또는 'image/png'
				callback(resizedImageUrl);
			};
		};
		
		reader.readAsDataURL(file);
	}
	
	document.getElementById('student_image').addEventListener('change', function(event) {
		var fileInput = event.target;
		var file = fileInput.files[0];
		
		if (file) {
			resizeImage(file, function(resizedImageUrl) {
				var imageContainer = document.querySelector("div#image_container");
				imageContainer.innerHTML = ""; // 기존 이미지 제거
				var img = document.createElement("img");
				img.src = resizedImageUrl;
				img.style.maxWidth = '150px'; // 원하는 크기로 스타일 지정
				img.style.maxHeight = '180px';
				imageContainer.appendChild(img);
				
				// 이미지가 추가되면 보더 제거
				imageContainer.style.border = "none";
			});
		}else {
			// 이미지가 없으면 보더 추가
			imageContainer.style.border = "1px solid #ccc";
		}
	});
	
	//이미지 파일만 가능
	document.getElementById('student_image').addEventListener('change',function(event) {
		var fileInput = event.target;
		var files = fileInput.files;
		var allowedExtensions = [ 'jpg', 'jpeg', 'png','gif' ];
		if (files.length > 1) {
			alert('한 개의 파일만 선택할 수 있습니다.');
			fileInput.value = "";
			document.querySelector("div#image_container").innerHTML = "";
			return;
		}
		if (files.length === 1) {
			var file = files[0];
			var fileType = file.type;
			var fileExtension = fileType.split('/')[1];
			if (!allowedExtensions.includes(fileExtension)) {
				alert('허용된 이미지 파일 형식은 .jpg, .jpeg, .png, .gif입니다.');
				fileInput.value = "";
				document.querySelector("div#image_container").innerHTML = "";
			} else {
				setThumbnail(event);
			}
		}
	});
	
	// 이벤트 리스너 설정
	document.getElementById("student_ph").addEventListener("blur", handlePhoneNumberBlur);
	document.getElementById("student_id").addEventListener("blur", handleIdBlur);
	document.getElementById("student_name").addEventListener("blur", handleNameBlur);
	document.getElementById("student_pw").addEventListener("blur", handlePasswordBlur);
	document.getElementById("student_email").addEventListener("blur",handleEmailBlur);
	document.getElementById("student_major").addEventListener("blur", handleMajorBlur);
	document.getElementById("student_year").addEventListener("blur", handleYearBlur);
	document.getElementById("student_birth").addEventListener("blur", handleBirthDateBlur);
	document.getElementById("student_status").addEventListener("blur", handleStatusBlur);
	document.getElementById("student_gender").addEventListener("blur", handleGenderBlur);

	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName
										: data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress").focus();
						
						var zipcode = document.getElementById('sample6_postcode').value;
						var addr1 = document.getElementById('sample6_address').value;
						var addr2 = document.getElementById('sample6_detailAddress').value;

						// student_address에 합친 주소값 넣기
						document.getElementById('student_address').value = '('+zipcode + ') ' + addr1 + ' ' + addr2;
						
					}
				}).open();
	}