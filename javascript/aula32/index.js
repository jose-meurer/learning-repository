//Atribuição via desestruturação

//                  1     2     3     4     5     6     7     8     9
// ...rest ...spread
const numeros = [1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000];
const [primeiroNumero, segundoNumero, terceiroNumero, ...resto] = numeros;
const [, , , quarto, , sexto, , , nono] = numeros;

console.log(primeiroNumero, segundoNumero, terceiroNumero);
console.log(resto);

console.log(quarto, sexto, nono);

const arrNumeros = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

//Quero pegar o numero 7
const [,,[sete]] = arrNumeros; //Pouco legivel
console.log(sete);

const [arr1, arr2, arr3] = arrNumeros;
console.log(arr3[0]);
console.log(arrNumeros[2][0]);