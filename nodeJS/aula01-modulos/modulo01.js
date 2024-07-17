const nome = "José";
const sobrenome = "Meurer";

class Pessoa {
  constructor(nome, sobrenome, idade) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
  }

  falaOi() {
    return `${nome} está falando oi.`
  }
}

//Formas de exportar
module.exports.nome = nome;
exports.sobrenome = sobrenome;
this.idade = 26;

module.exports.Pessoa = Pessoa;


// Dessa forma não posso mais adicionar mais exports depois
// module.exports = {
//     name: "Jose",
//     sobrenome: "Meurer",
//     idade: 26
// }