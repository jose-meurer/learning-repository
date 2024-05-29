const pessoa1 = {
  nome: "José",
  sobrenome: "Meurer",
  idade: 26,

  fala() {
    console.log(`Meu nome é ${this.nome} e estou com ${this.idade} anos.`);
  },

  incrementaIdade() {
    this.idade++;
  },
};


pessoa1.fala();
pessoa1.incrementaIdade();
pessoa1.fala();
pessoa1.incrementaIdade();
pessoa1.fala();
pessoa1.incrementaIdade();
pessoa1.fala();