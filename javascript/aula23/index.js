/**
 * Curto-circuito
 * 
 * && false && true -> false (o valor mesmo)
 * || true || false -> vai retornar o valor verdadeiro
 * 
 * FALSY 
 * *false
 * 0
 * ''
 * null
 * undefined
 * NaN
 * 
 * Todo o resto é truthy
 */

console.log(undefined || 'Joao');
console.log(null && 'Maria');

console.log(null && undefined && false); //Retorna o primeiro valor negativo
console.log(null || undefined || false); //Retorna o ultimo valor negativo

console.log('Maria' && 'Joao' && 'José'); //Retorna o ultimo valor verdadeiro
console.log('Maria' || 'Joao' || 'José'); //Retornao primeiro valor verdadeiro

const f1 = (n) => {
    n = n || 'Hello World'; //Retorna 'Hello Word' se n for FALSY
    console.log(n);
}

f1("Brazil");

f1();