function task1(word) {
    let result = '';
    for (let i = 0; i < word.length; i++) {
        let char = word[i];
        if (char.toLowerCase() == 'а' || char.toLowerCase() == 'о') {
            continue;
        }
        result += char;
    }
    console.log(result);
}
function task2(num) {
    for (let i = 1; i <= num; i++) {
        if (i % 3 === 0) {
            console.log(i);
        }
    }
}
function task3(num) {
    let result = '';
    for (let i = 1; i <= num; i++) {
        result += i;
        console.log(result);
    }
}
function task4(num) {
    let sum = 0;
    let factorial = 1;

    for (let i = 1; i <= num; i++) {
        factorial *= i;
        sum += factorial;
    }

    console.log(sum);
}

function task5(word) {
    let reversedWord = '';
    for (let i = word.length - 1; i >= 0; i--) {
        reversedWord += word[i];
    }
    if (word === reversedWord) { console.log('YES'); }
    else { console.log('NO'); }
}
task1(prompt("Введите слово: "))
task2(prompt("Введите num: "))
task3(prompt("Введите num: "))
task4(prompt("Введите num: "))
task5(prompt("Введите слово: "))