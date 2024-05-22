/** Operadores Aritméticos
 *  + Adição / Contatenação 
 *  - Subtração
 *  / Divisão 
 *  * Multiplicação
 *  ** Potenciação
 *  % Resto da divisão
 *  ** tem mais precedencia que * e / 
 *  ++ Incremento
 *  -- Decremento
 */


const num1 = 19;
const num2 = "56.2qnd783";

//parseInt e parseFloat analisa a string até encontrar um caractere que nao seja um numero valido

let result = num1 + num2;

console.log(result);

//parseInt(valor, base numerica)
result = num1 + parseInt(num2);
console.log(result);

//parseFloat(valor)
result = num1 + parseFloat(num2);
console.log(result);

result = num1 + Number(num2);
console.log(result);