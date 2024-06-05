//For in => lê os indices do array ou chaves do obj

const frutas = ['Pera', 'Maça', 'Uva', 'Morango'];

for(const indice in frutas) {
    console.log(indice, frutas[indice]);
}

const pessoa = {
    nome: 'José',
    sobrenome: 'Meurer',
    idade: 26
}

for(const chave in pessoa) {
    console.log(chave, pessoa[chave]);
}