//Getter e Setter

// Exemplo 1
class Pessoa {
  constructor(nome, sobrenome, idade) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
  }

  get nomeCompleto() {
    return this.nome + " " + this.sobrenome;
  }

  set nomeCompleto(novoNome) {
    novoNome = novoNome.split(" ");
    this.nome = novoNome.shift();
    this.sobrenome = novoNome.join(" ");
  }
}

const pessoa1 = new Pessoa("José", "Meurer");
console.log(pessoa1.nomeCompleto);

pessoa1.nomeCompleto = "João da Silva";
console.log(pessoa1.nome, "/", pessoa1.sobrenome);



// Exemplo 2
const _velocidade = Symbol("velocidade");
class Carro {
  constructor(modelo, velocidadeMaxima) {
    this.modelo = modelo;
    this[_velocidade] = 0; // Jeito de criar chave privada que nao pode ser sobrescrita
    this.velocidadeMaxima = velocidadeMaxima;

    console.log(this[_velocidade] === Symbol("velocidade")); //false
  }

  get velocidade() {
    return this[_velocidade];
  }

  set velocidade(novaVelocidade) {
    if (typeof novaVelocidade !== "number") return;
    if (novaVelocidade > this.velocidadeMaxima) return;

    this[_velocidade] = novaVelocidade;
  }

  acelerar() {
    if (this[_velocidade] >= this.velocidadeMaxima) return;

    this[_velocidade]++;
  }

  freiar() {
    if (this[_velocidade] <= 0) return;

    this[_velocidade]--;
  }
}

const carro = new Carro("BMW", 150);
console.log(carro);
carro.velocidade = 99;
console.log(carro);

carro.acelerar();
carro.acelerar();
carro.acelerar();
carro.acelerar();
console.log(carro);

carro.freiar();
carro.freiar();
console.log(carro);

carro._velocidade = 9999; //Não vai sobrescrever, pois a _velocidade do meu objeto é Symbol
console.log(carro);
