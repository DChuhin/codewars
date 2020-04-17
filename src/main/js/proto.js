function Person() {
  this.name = 'person';
  this.parentMethod = () => 'parentMethod';
}

// первым делом вызываем родительский конструктор с текущим объектом в качестве контекста
function Subclass() {
  Person.call(this);
  this.name = 'subclass';
  this.subclassMethod = () => 'subclassMethod';
}

// прототипу функции назначаем инстанс нашего персон класса чтоыб обозначить наследование в цепочке прототипов
Subclass.prototype = Object.create(Person.prototype);

var parent = new Person();
var child = new Subclass();

console.log(parent.name);
console.log(parent.parentMethod());
console.log(child.name);
console.log(child.parentMethod());
console.log(child.subclassMethod());

function GrandSon() {
  this.grandSonProp = 'grandSon';
}

GrandSon.prototype = Object.create(Subclass.prototype);
var grandChild = new GrandSon();
console.log(grandChild.hasOwnProperty('parentMethod'));