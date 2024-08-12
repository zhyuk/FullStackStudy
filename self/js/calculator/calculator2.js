const display = document.getElementById("display");
let arr = [];
var input;

// function clickBtn(num) {
//     // console.log(typeof num);
//     arr.push(num);
//     console.log(arr);
//     console.log(isNaN(Number(num))); // 숫자값 : false, 숫자가 아닌 값 : true

// }

// function clickBtn(num) {
//     console.log("방금 입력한 값은 : " + num);
//     if (arr.length != 0) {
//         input = arr[i] + num;
//         i++;
//         console.log(input);
//     }
//     arr.push(num);
//     console.log("배열 : " + arr);
//     console.log("배열의 길이 : " + arr.length);

//     display.value = input;
// }

function number(num) {
    console.log("방금 입력한 값은 : " + num);
    var input;

    if (input == undefined) input = num;


    if (!isNaN(Number(num))) { // num이 숫자값일 때
        arr.push(num);
        // console.log("배열 : " + arr);
        if (input == undefined) input = num;
        else if (input != undefined) input += num;
        console.log(input);
        display.value += num;
    }

    // if (isNaN(Number(num))) { // num이 숫자값이 아닐 때
    //     let output = input + num;
    //     console.log(output);
    // }
}

function ac() {
    display.value = '';
    arr = [];
    input = '';
    // console.log(arr.length);
    console.log(arr);
}



function operator(ope) {
    let operator = ope;
    console.log("방금 누른 연산자 : " + operator);
}

function enter() {
}