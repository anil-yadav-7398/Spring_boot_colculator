let display = document.getElementById("display");
function appendValue(value) {
    display.value += value;
}

function clearDisplay() {
    display.value = "";
}
function backspace() {
    display.value = display.value.slice(0, -1);
}
function calculate() {
    try {
        let expression = display.value
            .replace(/x/g, '*')// Replace 'x' with '*'
            .replace(/÷/g, '/'); // Replace '÷' with '/'
        display.value = eval(expression);

    } catch (error) {
        display.value = "Error";
    }
}
function percent() {
    if (display.value !== "") {
        display.value = parseFloat(display.value) / 100;
    }
}
function square() {
    if (display.value !== "") {
        let n = parseFloat(display.value);
        display.value = n * n;
    }
}
function squareRoot() {
    if (display.value !== "") {
        display.value = Math.sqrt(parseFloat(display.value));
    }
}
function reciprocal() {
    if (display.value !== "") {
        let n = parseFloat(display.value);
        if (n !== 0) {
            display.value = 1 / n;
        } else {
            display.value = "Error";
        }
    }
}
function plusMinus() {
    if (display.value !== "") {
        let n = parseFloat(display.value);
        display.value = -n;
    }
}
function clearEntry() {
    display.value = "";
}