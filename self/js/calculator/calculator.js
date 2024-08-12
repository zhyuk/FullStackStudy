
const display = document.getElementById("display");
let arr = [];
let isDisplayNull = true;
let isSecondNum = false;

function number(num) {
    console.log("방금 누른 값은 : " + num);

    if (num == 0 && isDisplayNull == true) {
        display.value = '';
    } else {
        if (arr.length >= 1 && isSecondNum == false) {
            display.value = '';
            isSecondNum = true;
        }
        isDisplayNull = false;
        display.value += num;
    }
};

function operator(ope) {
    if (display.value != '') {
        arr.push(display.value);
        console.log(arr);

        switch (ope) {
            case '*': arr.push('*'); break;
            case '+': arr.push('+'); break;
            case '-': arr.push('-'); break;
            case '/': arr.push('/'); break;
        }
        console.log(arr);
    }

    isSecondNum = false;


}

function ac() {
    display.value = '';
    arr = [];
    isDisplayNull = true;
}

function enter() {
    arr.push(display.value);
    console.log(arr);

    let num1 = parseInt(arr[0]);
    let operator = arr[1];
    let num2 = parseInt(arr[2]);

    switch (operator) {
        case '+': result = num1 + num2; break;
        case '-': result = num1 - num2; break;
        case '*': result = num1 * num2; break;
        case '/': result = num1 / num2; break;
    }
    arr = [];
    console.log(result);
    console.log(arr);
    display.value = result;
}
