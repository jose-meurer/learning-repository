// Prototypes

// Construtora => molde (classe)
function Pessoa(nome, sobrenome) {
  this.nome = nome;
  this.sobrenome = sobrenome;
//   this.nomeCompleto = () => this.nome + " " + this.sobrenome;
}

Pessoa.prototype.nomeCompleto = function () { // Cria apenas uma funcao para todas as pessoas
  return `${this.nome} ${this.sobrenome}`;
};

// Instancias
const pessoa2 = new Pessoa("Maria", "Brown");
const pessoa1 = new Pessoa("José", "Meurer");

console.log(pessoa1, pessoa1.nomeCompleto());
console.log(pessoa2, pessoa2.nomeCompleto());

// Exemplo de tagged literal

function tag(strings, ...values) {
  console.log(strings);
  console.log(values);


  return strings.reduce((acc, str, i) => acc + str + (values[i] ? `<span>${values[i]}</span>` : ''), '');
}

const name = 'José';
const time = 'today';
const result = tag`Hello, ${name}! How are you ${time}?`

console.log('result: ' + result);
