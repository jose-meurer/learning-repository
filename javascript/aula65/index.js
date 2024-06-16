// Filter => Irá retornar um novo array

// Retorne os numeros maiores que 10
const numeros = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27];

const retorno = numeros.filter(x => x > 10);
console.log(retorno)



// Retorne as pessoas que tem o nome com 5 letras ou mais
// Retorne as pessoas com mais de 50 anos
// Retorne as pessoas cujo nome termina com a
const pessoas = [
    {nome: 'José', idade: 62},
    {nome: 'Maria', idade: 23},
    {nome: 'Eduardo', idade: 55},
    {nome: 'Letícia', idade: 19},
    {nome: 'Rosana', idade: 32},
    {nome: 'Wallace', idade: 47},
    {nome: 'Ana', idade: 47}

];

const pessoasComRequisitos = pessoas.filter((valor) => {
    if(valor.nome.length >= 5) {
        return true;
    }

    if(valor.idade > 50) {
        return true;
    }

    if(valor.nome.slice(valor.nome.length - 1) === 'a') {
        return true;
    }

    return false;
});

console.log(pessoasComRequisitos);