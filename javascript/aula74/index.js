// Prototypes

// Construtora => molde (classe)
function Pessoa(nome, sobrenome) {
  this.nome = nome;
  this.sobrenome = sobrenome;
//   this.nomeCompleto = () => this.nome + " " + this.sobrenome;
}

Pessoa.prototype.nomeCompleto = function () {
  return `${this.nome} ${this.sobrenome}`;
};

// Instancias
const pessoa2 = new Pessoa("Maria", "Brown");
const pessoa1 = new Pessoa("José", "Meurer");

console.log(pessoa1, pessoa1.nomeCompleto());
console.log(pessoa2, pessoa2.nomeCompleto());
