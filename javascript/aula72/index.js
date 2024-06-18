// defineProperty -> Getter e Setter
function Produto(nome, preco, estoque) {
  this.nome = nome;
  this.preco = preco;

  let _estoque = estoque;

  Object.defineProperty(this, "estoque", {
    enumerable: true,
    configurable: true,
    get: () => _estoque,
    set: valor => {
      if (typeof valor !== "number") {
        throw new TypeError("O tipo do valor precisa ser number");
      }

      _estoque = valor;
    },
  });
}

const p1 = new Produto("Mouse", "200", 6);
console.log(p1);
// p1.estoque = "José";
p1.estoque = 77;
console.log(p1.estoque);
