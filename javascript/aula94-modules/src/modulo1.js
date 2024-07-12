const nome = "José";
const sobrenome = "Meurer";
const idade = 26;

export function soma(n1, n2) {
  return n1 + n2;
}

export default class Pessoa {
  constructor(nome, sobrenome, idade) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
  }
}

export { nome, sobrenome, idade};
