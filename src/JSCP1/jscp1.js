function task1(){
    let price = 10000
    let range = "day"

    var dict = {"day": "день",
        "mounth": "месяц",
        "year": "год"}

    console.log(`${price} в ${dict[range]}`)
}


function task2() {
    var temp = 25
    var weather = "clear"
    var activity = "hiking"

    if (temp >= 25 && weather == "clear") {
        console.log("golf")
        return
    }

    if (10 <= temp <= 24 || weather == "cloudy") {
        console.log("bowling")
        return
    }

    console.log(activity)
    return
}

function task3() {
    var a = 2
    var b = 0
    var sing = "/"
    if(b==0 && sing=="/") {
        return "делить на 0 нельзя!! инфа о тебе уже у зарали, беги :) <3"
    }
    return eval(a + sing + b)
}

function task4() {
    var word = "tiptaptop"
    var result= 0
    var val = Math.sqrt(word.length)
    if (Number.isInteger(val)) {
        result = 1
    }
    return result
}
task1()
task2()
console.log(task3())
console.log(task4())