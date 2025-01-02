let numero1 = 423.65789689;
let numero2 = 2.5;

//Concatenação
console.log(numero1.toString() + numero2);
//Representação em binário
console.log(numero1.toString(2));
//Arredondar
console.log(numero1.toFixed(2));

numero1 = 10;

//Verifica se é um número inteiro
console.log(Number.isInteger(numero1));
//Verifica se é um número
console.log(typeof numero1 == "number");
//Verifica se é um NaN
console.log(Number.isNaN(numero1));
//Verifica se é um NaN depois de tentar converter para number
console.log(Number.isNaN(Number(numero1)));

numero1 = "32as3123";
//Converter para tipo number, mas apenas se nao tiver letras
console.log(Number(numero1));
//Converte para numero inteiro até achar . ou letra
console.log(Number.parseInt(numero1));

numero1 = "1001101";
//Converter binário para decimal ou outra base de números
console.log(Number.parseInt(numero1, 2));
//Converter decimal para uma string de valor binário ou outra base de números
console.log(Number(77).toString(2));

// Padrão de precisão de numeros do js IEEE 754-2008

numero1 = 0.7;
numero2 = 0.1;

console.log(numero1 + numero2); // 0.79999999999

let temp = numero1 + numero2;
temp += numero2;
temp += numero2;

//Caso precise apenas imprimir o valor no html para o usuario
console.log(temp.toFixed(2));
console.log("Integer:", Number.isInteger(temp.toFixed(2)));

console.log(temp); // 0.999999999
console.log("Integer:", Number.isInteger(temp));

//Exemplo 1 de resolver a imprecisão
temp = Number(temp.toFixed(2));
console.log(temp);
console.log("Integer:", Number.isInteger(temp));

//Exemplo 2 de resolver o problema da imprecisão
temp = (numero1 * 100 + numero2 * 100) / 100;
temp = (temp * 100 + numero2 * 100) / 100;
temp = (temp * 100 + numero2 * 100) / 100;

console.log(temp); // 1
console.log("Integer:", Number.isInteger(temp));
