// Padrao JS IEEE 754-2008
let num1 = 0.7;
let num2 = 0.1;

console.log(num1 + num2); //Imprecisao do JS 0.79999999999999

let result = (num1 * 100 + num2 * 100) / 100; //Uma forma de resolver
console.log(result);

result = num1 + num2;
result = parseFloat(result.toFixed(2)); //Maneira mais legivel de resolver
console.log(result);

result = num1;
result += num2;
result += num2;
result += num2;
console.log(result, Number.isInteger(result));

result = parseFloat(result.toFixed(2));
console.log(result, Number.isInteger(result));

result = 5 * "qh2";
console.log(result, Number.isNaN(result));

result = 16;
console.log(result, result.toString(2))//(base do numero);

result = 313.9732;
console.log(result, result.toFixed(5), result.toPrecision(5)); //Retorna uma string
console.log(typeof result.toFixed(2));

let n = new Number(732.312);
console.log(typeof n, typeof n.valueOf()); //Transforma obj em primitivo

console.log(Number.isSafeInteger(10), Number.isSafeInteger(31231312312332211)); //Inteiros seguros são todos números inteiros de -(2 53 - 1) a +(2 53 - 1).
console.log(2**53 -1);
console.log(Number.MAX_SAFE_INTEGER);

let temp = 0.0;
for(let i = 0; i< 11; i++) {
    console.log(temp);
    temp += 0.1;
}

//Estudar mais sobre IEEE 754-2008