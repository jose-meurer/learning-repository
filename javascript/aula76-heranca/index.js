// Produto => Camiseta / Produto => Caneca

// Produto generico
function Produto(nome, preco) {
  this.nome = nome;
  this.preco = preco;
}

Produto.prototype.aumento = function (valor) {
  this.preco += valor;
};

Produto.prototype.desconto = function (valor) {
  this.preco -= valor;
};

// Produto mais especifico
function Camiseta(nome, preco, tamanho) {
  Produto.call(this, nome, preco); //Ao usar o .call() para passar o this, nome e preco é criado no this atual, inves do new
  this.tamanho = tamanho;
}
Camiseta.prototype = Object.create(Produto.prototype);
Camiseta.prototype.constructor = Camiseta;

// Exemplo de outro produto de delegacao(herança)
function Caneca(nome, preco, cor, estoque) {
  Produto.call(this, nome, preco);
  this.cor = cor;

  Object.defineProperty(this, "estoque", {
    enumerable: true,
    configurable: false,
    get: () => estoque,
    set: valor => {
      typeof valor === "number" && (estoque = valor);
    },
  });
}
Caneca.prototype = Object.create(Produto.prototype);
Caneca.prototype.constructor = Caneca;
// Caneca.prototype = new Produto(); //Executa todo o codigo do Produto, inves de fazer uma atribuicao

// Caneca.prototype = Produto.prototype; // valor referencia, acabo alterando o prototype de Produto junto

console.log(Object.create(Produto.prototype));

Caneca.prototype.desconto = function (porcentagem) {
  this.preco -= this.preco * (porcentagem / 100);
};

const caneca = new Caneca("Caneca", 26, "verde", 6);
console.log(caneca);

caneca.aumento(20);
console.log(caneca);
