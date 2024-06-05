/**
 * For classico => Geralmente com iteráveis (array ou string)
 * For in => Retorna o índice ou chave (array, string ou objetos)
 * For of => Retorna o valor em si (iteráveis, array ou string)
 */

const nome = 'Jose Meurer';
const nomes = ['Miguel', 'José', 'Valentina'];
const pessoa = {
    nome: 'Jose',
    sobrenome: 'Meurer',
    idade: 26
}

for(let i = 0; i < nome.length; i++) {
    console.log(nome[i]);
}

console.log('===============================')

for (const indice in pessoa) { //Mais usados para obj
    console.log(indice, pessoa[indice]);
}

console.log('===============================')

for (const valor of nomes) { //Mais usado para arrays
    console.log(valor);
}