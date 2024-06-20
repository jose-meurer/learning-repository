// Manipulando prototypes

// new Object => Object.prototype
const objA = {
  chaveA: "A",
  // __proto__: Object.prototype
};

const objB = {
  chaveA: "B",
  // __proto__: Object.prototype
};

const objC = new Object();
objC.chaveC = "C";

Object.setPrototypeOf(objB, objA);
Object.setPrototypeOf(objC, objB);

console.log(objC.chaveA);

// console.info(Object.getPrototypeOf(objC));

console.log(objC.__proto__);
console.log(objB.__proto__);
console.log(Object.getPrototypeOf(objA));

function Produto(nome, preco) {
  this.nome = nome;
  this.preco = preco;
}

Produto.prototype.desconto = function (percentual) {
  this.preco = this.preco - this.preco * (percentual / 100);
};

Produto.prototype.aumento = function (percentual) {
  this.preco = this.preco + this.preco * (percentual / 100);
};

const p1 = new Produto("Camiseta", 50);
p1.desconto(50);
console.log(p1);

p1.aumento(100);
console.log(p1);

//Literal
const p2 = {
  nome: "Caneca",
  preco: 15,
};
Object.setPrototypeOf(p2, Produto.prototype); // Agora o prototype do meu p2 tem como referencia o Produto

p2.aumento(10);
console.log(p2);

const p3 = Object.create(Produto.prototype, {
  // Herda o prototype do "pai"(Produto)
  tamanho: {
    writable: true,
    configurable: true,
    enumerable: true,
    value: 50,
  },
  cor: {
    enumerable: true,
    writable: true,
    configurable: true,
    value: "Azul",
  },
  preco: {
    enumerable: true, // Toda configuração omitida é considerado false
    value: 20,
  },
  nome: {
    enumerable: true,
    value: "Caneca",
  },
});

console.log(p3);
console.log(Object.getOwnPropertyDescriptors(p3));

const p4 = Object.create(Produto.prototype); // Propriedades sao opcionais na criacao;
p4.preco = 99;

console.log(p4);
