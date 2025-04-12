// Задача 1: Проверка делимости на 7
function checkElem(num) {
    console.log(num % 7 === 0);
}

document.getElementById("checkElemButton").addEventListener("click", function() {
    checkElem(13); // Пример
});

// Задача 2: Изменение массива
function changeElem(array, n) {
    return array.map(function(element) {
        return element * n;
    });
}

document.getElementById("changeElemButton").addEventListener("click", function() {
    let array = [1, 2, 3, 4];
    let result = changeElem(array, 3);
    console.log(result); // Пример
});

// Задача 3: Сумма элементов массива
function sumElems(array) {
    return array.reduce(function(sum, element) {
        let num = Number(element);
        return isNaN(num) ? sum : sum + num;
    }, 0);
}

document.getElementById("sumElemsButton").addEventListener("click", function() {
    let array = ['10', 'Строка', '5g', '15', '05'];
    let result = sumElems(array);
    console.log(result); // Пример
});

// Задача 4: Переворот массива
function reverseIndex(array) {
    let reversed = [];
    for (let i = array.length - 1; i >= 0; i--) {
        reversed.push(array[i]);
    }
    console.log(reversed);
}

document.getElementById("reverseIndexButton").addEventListener("click", function() {
    let array = [1, 2, 3, 4, 5];
    reverseIndex(array); // Пример
});

// Задача 5: Проверка с колбэком
function checkElemCallback(array, callback) {
    return array.some(callback);
}

document.getElementById("checkElemCallbackButton").addEventListener("click", function() {
    let array = [1, 2, 3, 4];
    let result = checkElemCallback(array, function(elem) {
        return elem == 3;
    });
    console.log(result); // Пример
});
