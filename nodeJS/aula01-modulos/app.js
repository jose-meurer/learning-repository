// Formas de importar o modulo
const modulo1 = require("./modulo01");
const Pessoa = modulo1.Pessoa;
const {nome, sobrenome}  = require("./modulo01");

console.log(modulo1);
const pessoa = new Pessoa(nome, sobrenome, modulo1.idade);
console.log(pessoa);
console.log(pessoa.falaOi());


// Modulos nativos do nodejs nao precisa do caminho relativo
//Exemplo:
const path = require("path");
// console.log(path);

// https://nodejs.org/docs/latest/api/