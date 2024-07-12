//     Default pode usar qualquer nome /  chamando soma e renomeando para calculadora
import Pessoa, { nome, sobrenome, idade, soma as calculadora } from "./modulo1";

const p1 = new Pessoa(nome, sobrenome, idade);
console.log(calculadora(p1.idade, 5));
console.log(p1);



// import Pessoa, * as MeuModulo from "./modulo1";

// const p1 = new Pessoa(MeuModulo.nome, MeuModulo.sobrenome, MeuModulo.idade);
// console.log(MeuModulo.soma(p1.idade, 5));
// console.log(p1);
