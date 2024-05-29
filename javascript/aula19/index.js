/**
 * Primitivos (imutáveis) - string, number, boolean, undefined, null, (bigint, symbol)
 * 
 * Referência (mutável) - array, object, function - Passados por referência
 */


//Exemplo com array

const a = [1,2,3];
const b = a; //Aponta para o mesmo lugar na memoria que A
const c = [...a]; //Usando o spread, faz uma copia dos dados

console.log(a, b);
console.log(c);

a.push(4, 5);
console.log(a, b);
console.log(c);

b.push(3,2,1);
console.log(a, b);
console.log(c);

//Exemplo com obj

const pessoa1 = {
    nome: 'José',
    sobrenome: 'Meurer'
}

const pessoa2 = pessoa1;

console.log(pessoa1, pessoa2);

pessoa1.nome = 'João';
console.log(pessoa1, pessoa2);