// defineProperty - defineProperties => Getter e Setter

function Produto(nome, preco, estoque) {
  // this.nome = nome;
  // this.preco = preco;
  // this.estoque = estoque;

  Object.defineProperties(this, {
    nome: {
      enumerable: true,
      value: nome,
      writable: true,
      configurable: true,
    },
    preco: {
      enumerable: true,
      value: preco,
      writable: true,
      configurable: true,
    },
  });

  Object.defineProperty(this, "estoque", {
    enumerable: true, // Mostra a chave
    value: estoque, // valor
    writable: false, // pode ser reescrito
    configurable: true, // Pode ser reconfigurado ou deletado
  });
}

const p1 = new Produto("Camisa", 20, 5);
p1.estoque = 55;
console.log(p1);
