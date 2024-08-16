
const display = document.getElementById("display");
let numArr = []; // 숫자 담아둘 배열 생성
let opeArr = []; // 연산자를 담아둘 배열 생성
let isDisplayNull = true; // 디스플레이창 제어
let isSecondNum = false; // 연산자 이후 두번째 숫자 제어
let hasEnd = false; // 소수점 제어

function number(num) {
    console.log("방금 누른 값은 : " + num);

    if (num == '.' && isDisplayNull == true) { // 입력값이 .이고 디스플레이창에 아무것도 안적혀있을 때
        display.value = ''; // 해당 입력값은 저장하지 않음.
    } else {
        // 연산자 이후 두번째 숫자
        if (numArr.length >= 1 && isSecondNum == false) {
            display.value = ''; // 입력창 초기화
            isSecondNum = true;
        }
        isDisplayNull = false;

        // 입력값이 .이고 hasEnd가 true일 때 (이미 소수점을 입력한 경우)
        if (hasEnd == true && num == '.') {
            display.value = display.value; // 다시 소수점을 입력할 수 없음
        } else {
            // 입력값이 0이고 디스플레이창도 0일 때(이미 0을 1번 입력한 경우)
            if (num == '0' && display.value == num) {
                // console.log(display.value);
                display.value = display.value; // 그 이후의 0을 추가하지 않음.
            } else {
                display.value += num;
            }
        }
    }

    // 입력값이 .이고 hasEnd가 false일 때(소수점을 입력하지 않은 경우)
    if (num == '.' && hasEnd == false) {
        hasEnd = true; // hasEnd를 true로 변경 (소수점 입력했음을 확인할 수 있도록)
        if (display.value == '') display.value = '0.';
        // console.log("소수점 등장");
        // console.log(hasEnd);
    }


};

function operator(ope) {
    // if (!isNaN(Number(arr[(arr.length - 1)]))) {
    if (display.value != '') { // 숫자 입력하지 않고 연산자만 눌렀을 때는 연산자 저장하지 않음
        numArr.push(display.value);
        console.log(numArr);

        switch (ope) {
            case '*': opeArr.push('*'); break;
            case '+': opeArr.push('+'); break;
            case '-': opeArr.push('-'); break;
            case '/': opeArr.push('/'); break;
        }
        // console.log("배열 : " + !isNaN(Number(arr[(i - 1)])));
        console.log(opeArr);
    } else if (ope == '-') { // 음수 설정
        number('-'); // 음수로 만들기 위해 
    }
    isSecondNum = false;
    // }
}

// 초기화
function ac() {
    display.value = ''; // 디스플레이창 초기화
    numArr = [];
    opeArr = [];
    isDisplayNull = true;
    hasEnd = false;
}

function enter() {
    if (numArr != []) { // 숫자입력없이 enter 누르면 값 저장 X
        numArr.push(display.value);
        console.log('연산자: ' + opeArr);
        console.log('숫자: ' + numArr);
        console.log('숫자배열 길이: ' + numArr.length);

        let result = ''; // 계산 결과
        for (let i = 0; i < numArr.length; i++) {
            if (result == '') result = Number(numArr[i]); // 초기 1회만 numArr[0]의 값 저장
            else result += Number(numArr[i]); // 이후에는 결합되도록

            switch (opeArr[i]) { // opeArr[0]의 값의 종류
                case '+': result = result + Number(numArr[i]); opeArr.pop(); break;
                case '-': result = result - Number(numArr[i]); opeArr.pop(); break;
                case '*': result = result * Number(numArr[i]); opeArr.pop(); break;
                case '/': result = result / Number(numArr[i]); opeArr.pop(); break;
            }
        }
        console.log(result);
        display.value = result;
    }

    // if (numArr.length >= 1) {
    //     let num1 = Number(arr[0]);
    //     let operator = arr[1];
    //     let num2 = Number(arr[2]);

    //     switch (operator) {
    //         case '+': result = num1 + num2; break;
    //         case '-': result = num1 - num2; break;
    //         case '*': result = num1 * num2; break;
    //         case '/': result = num1 / num2; break;
    //     }
    //     arr = [];
    //     console.log(result);
    //     console.log(arr);
    //     display.value = result;



    //     let num = [];
    //     num.push(display.value);
    //     console.log('arr: ' + arr);
    //     console.log('num : ' + num);
    //     let ope = [];

    //     switch (operator) {
    //         case '+': ope.push("+"); break;
    //         case '-': ope.push("-"); break;
    //         case '*': ope.push("*"); break;
    //         case '/': ope.push("/"); break;
    //     }
}
