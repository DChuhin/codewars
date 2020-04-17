const fib = [1,2,3,5,8,13];

// на момент выполнения setTimeout i=6
for (var i = 0; i < fib.length; i++) {
    setTimeout(function() {
        console.log(fib[i]);
    }, 1500);
}

// замкнем через доп функцию
for (var i = 0; i < fib.length; i++) {
    (function (j) {
        setTimeout(function () {
            console.log(fib[j]);
        }, 1500);
    })(i)
}

// также если юзать let (т.к. скоуп у let огрвничен)
for (let i = 0; i < fib.length; i++) {
    setTimeout(function() {
        console.log(fib[i]);
    }, 1500);
}

// классика closure, инкапсуляция
function closureProvider(name, surname) {
    const privateObject = { name, surname, count: 0 }
    return {
        getName: function () {
            return `${privateObject.name} ${privateObject.surname}`
        },
        getCount: function () {
            return privateObject.count;
        },
        addCount: function () {
            privateObject.count++;
        }
    }
}

const obj = closureProvider('Daniil', 'Chukhin');
obj.addCount();
obj.addCount();
console.log(obj.getName());
console.log(obj.getCount());