let phones = [
    '590.423.4568',
    '650.124.7234',
    '650.507.9879',
    '011.44.1343.529268',
    '011.44.1344.478968',
    '011.44.1644.429267',
    '11.44.1343.52',
    '11.44.1643.52'
];

let maskedPhones = phones.map(phone => {
    let lastDotIndex = phone.lastIndexOf('.');
    return phone.substring(0, lastDotIndex + 2) + '****';
});

console.log(maskedPhones);

let cards = [
    '4000 0012 0056 9499',
    '4000 0013 5456 7379',
    '4000 0014 1456 9869',
    '4000 0015 3466 7859',
    '4000 0016 3556 6899',
    '4000 0017 4456 4699'
];

let maskedCards = cards.map(card => {
    let digits = card.replace(/\s/g, '');
    return digits.substring(0, 4) + '*****' + digits.substring(digits.length - 4);
});

console.log(maskedCards);

let prices = [
    'Цена товара - 1200$',
    'Стоимость - 500$',
    'Цена не определена',
    '9999',
    'Ценовая категория - больше 300$',
    'Цена за услугу 500 EUR',
    '150$',
];

function getInfo(prices) {
    let startsWithPrice = prices.filter(item => item.startsWith('Цена')).length;
    let endsWithDollar = prices.filter(item => item.endsWith('$')).length;
    return [startsWithPrice, endsWithDollar];
}

console.log(getInfo(prices));

function kingSayd(string) {
    if (string.startsWith('Король сказал:')) {
        console.log(string);
    } else {
        console.log(`Король сказал: ${string}`);
    }
}

kingSayd("сегодня хорошая погода");

function isFridayToday() {
    let today = new Date();
    let day = today.getDay();
    let daysUntilFriday = (5 - day + 7) % 7;

    if (daysUntilFriday === 0) {
        console.log("Сегодня пятница!");
    } else if (daysUntilFriday === 6) {
        console.log("Пятница была вчера");
    } else if (daysUntilFriday === 1) {
        console.log("Завтра пятница!");
    } else {
        let daysWord = daysUntilFriday === 1 ? 'день' :
            (daysUntilFriday >= 2 && daysUntilFriday <= 4) ? 'дня' : 'дней';
        console.log(`Пятница будет через ${daysUntilFriday} ${daysWord}`);
    }
}

isFridayToday();