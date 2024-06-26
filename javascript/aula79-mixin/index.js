// Factory function - Mixin

const falar = {
  falar() {
    console.log(`${this.nome} está falando.`);
  },
};

const comer = {
  comer() {
    console.log(`${this.nome} está comendo.`);
  },
};

const beber = {
  beber() {
    console.log(`${this.nome} está bebendo.`);
  },
};

const pessoaPrototype = Object.assign({}, falar, comer, beber);

function criaPessoa(nome, sobrenome) {
  return Object.create(pessoaPrototype, {
    nome: {
      value: nome,
      enumerable: true,
      writable: true,
    },
    sobrenome: {
      value: sobrenome,
    },
  });
}

const p1 = criaPessoa("José", "Meurer");
const p2 = criaPessoa("Maria", "Brown");
console.log(Object.getOwnPropertyDescriptors(p2));



function Funcao(nome) {
  this.nome = "__" + nome;

  return this;
}

const f1 = Funcao.bind(p2); // retorna uma funcao
console.log(f1);
console.log(f1("Luiz"));
