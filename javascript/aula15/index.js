//Math

let num1 = 9.4983;
console.log(num1);

console.log(Math.floor(num1)); //Arredonda para baixo

console.log(Math.ceil(num1)); //Arredonda para cima

console.log(Math.round(num1)); //Arredonda para o inteiro mais proximo

const ar = [3, 4, 7, 32, 43, 123, 54365, 31231];

console.log(Math.max(...ar));
console.log(Math.min(...ar));

console.log(Math.round(Math.random() * (20 - 1) + 1)); //Numero random entre 20 e 1

console.log(Math.pow(2, 10), 2 ** 10);

console.log(9 ** 0.5, 9 ** (1 / 2), Math.sqrt(9)); //Forma de retornar a raiz quadrada

console.log(100 / 0, !!(100 / 0)); //Retorna infinity, infynity é considerado true
