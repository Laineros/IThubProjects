function task1(obj) {
    return Object.values(obj).reduce((sum, val) => sum + val, 0);
}

function task2(array) {
    return array.map(obj => Object.values(obj));
}

function task3(...args) {
    console.log(args.join(' ') + ' ');
}

function task4(obj) {
    return obj.hasOwnProperty('particle');
}

function task5(array) {
    return array.map(item =>
        typeof item === 'object' && !Array.isArray(item) ? Object.values(item) : item
    );
}

let users = [
    { id: 1, name: 'Alex', lastname: 'Wilyam', age: 20 },
    { id: 2, name: 'Steven', lastname: 'King', age: 34 },
];

function addUser(name, lastname, age) {
    let newId = users.length ? users[users.length - 1].id + 1 : 1;
    users.push({ id: newId, name, lastname, age });
}

function updateUser(id, name, lastname, age) {
    let user = users.find(u => u.id === id);
    if (user) {
        user.name = name;
        user.lastname = lastname;
        user.age = age;
    }
}

function deleteUser(id) {
    users = users.filter(u => u.id !== id);
}

function task7(products) {
    let filtered = products.filter(p => p.count > 10);
    let priceInRange = products.find(p => p.price >= 800 && p.price <= 900);
    let sortedByPrice = [...products].sort((a, b) => b.price - a.price);
    let totalCost = products.reduce((sum, p) => sum + p.price * p.count, 0);
    let marksTotal = products
        .map(p => ({ ...p, marksTotal: p.marks.reduce((a, b) => a + b, 0) }))
        .sort((a, b) => b.marksTotal - a.marksTotal);
    return {
        filtered,
        priceInRange,
        sortedByPrice,
        totalCost,
        marksTotal
    };
}

class Email {
    constructor(email) {
        this.email = email;
    }

    get isValid() {
        let forbidden = /[*#$%^]/;
        let parts = this.email.split('.');
        return !forbidden.test(this.email) && parts[1]?.length <= 3;
    }

    set setEmail([login, domain, zone]) {
        this.email = `${login}@${domain}.${zone}`;
    }
}

class Contact extends Email {
    constructor(email, phone) {
        super(email);
        this.phone = phone;
    }

    get phoneType() {
        if (!this.phone.startsWith('+')) return "Неизвестный";
        let digits = this.phone.replace('+', '');
        if (digits.length === 12) return "Мобильный";
        if (digits.length === 18) return "Городской";
        return "Неизвестный";
    }
}

class Animal {
    makeSound() {
        console.log("Some generic sound");
    }
}

class Dog extends Animal {
    makeSound() {
        console.log("Woof!");
    }
}

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    constructor(name, age, university) {
        super(name, age);
        this.university = university;
    }
}

class Vehicle {
    drive() {
        return "Moving forward";
    }
}

class Car extends Vehicle {
    drive() {
        return super.drive() + " on the road";
    }
}

class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    area() {
        return this.width * this.height;
    }
}

class Square extends Rectangle {
    constructor(side) {
        super(side, side);
    }
}

class Device {
    powerOn() {
        return "Device is on";
    }
}

class Computer extends Device {
    powerOn() {
        return super.powerOn() + ", loading OS...";
    }
}

class Laptop extends Computer {
    powerOn() {
        return super.powerOn() + ", battery is charged";
    }
}



console.log("Task 1:", task1({ price1: 100, price2: 150, price3: 200, price4: 100, price5: 150 }));

console.log("Task 2:", task2([{ id: 1, name: 'apple' }, { id: 2, name: 'melon' }]));

task3("Hello", "my", "world!");

console.log("Task 4:", task4({ id: 1, particle: 10 }), task4({ id: 2, name: 'tag' }));

console.log("Task 5:", task5([[1], { id: 40 }, [100], [300], { part: 10 }]));

addUser('Leo', 'Lev', 17);
updateUser(2, 'Steeeve', 'King', 35);
deleteUser(1);
console.log("Task 6:", users);

let products = [
    { id: 1, title: 'Меч', price: 6000, count: 15, marks: [5, 5, 5] },
    { id: 2, title: 'Арбалет', price: 25000, count: 5, marks: [3, 4, 5] },
    { id: 3, title: 'Щит', price: 3000, count: 8, marks: [4, 4, 3] },
];
console.log("Task 7:", task7(products));

let e1 = new Email("Leonchik@mail.com");
e1.setEmail = ['user', 'gmail', 'com'];
console.log("Task 8:", e1.email, e1.isValid);

let c1 = new Contact("abc@mail.com", "+123456789012");
let c2 = new Contact("abc@mail.com", "123456");
console.log("Task 9:", c1.phoneType, c2.phoneType);

new Dog().makeSound();

let student = new Student("Leo", 17, "IThub");
console.log("Task 11:", student);

let myCar = new Car();
console.log("Task 12:", myCar.drive());

let square = new Square(4);
console.log("Task 13:", square.area());

let laptop = new Laptop();
console.log("Task 14:", laptop.powerOn());