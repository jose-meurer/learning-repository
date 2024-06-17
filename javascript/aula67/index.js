// Reduce

// Some todos os numeros (reduce)
// Retorne um array com os pares (Filter)
// Retorne um array com o dobro dos valores (Map)
const numeros = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27];

const somaNumeros = numeros.reduce((acumulador, valor) => {
  return (acumulador += valor);
});
console.log(somaNumeros);

const numerosPares = numeros.reduce((acumulador, valor) => {
  if (valor % 2 === 0) return (acumulador += valor);
  return acumulador;
}, 0);
console.log(numerosPares);

const numerosDobro = numeros.reduce((acumulador, valor) => {
  acumulador.push(valor * 2);
  return acumulador;
}, []);
console.log(numerosDobro);

// Retorne a pessoa mais velha
const pessoas = [
  { nome: "José", idade: 52 },
  { nome: "Maria", idade: 23 },
  { nome: "Eduarco", idade: 55 },
  { nome: "Letícia", idade: 19 },
  { nome: "Rosana", idade: 32 },
  { nome: "Wallace", idade: 67 },
];

const pessoaMaisVelha = pessoas.reduce((acumulador, obj) => {
  if (acumulador.idade > obj.idade) return acumulador;
  return obj;
});

console.log(pessoaMaisVelha);
