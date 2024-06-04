//Atribuição via desestruturação objeto

const pessoa = { 
    nome: 'José',
    sobrenome: 'Meurer',
    idade: 26,
    endereco: {
        rua: 'João Colin',
        numero: 1832
    }
};

// const {nome, sobrenome, ...resto} = pessoa;
// const {sobrenome, ...resto} = pessoa; //nome que vem antes de sobrenome é incluido no resto
// const {nome, cpf = '1234567890'} = pessoa; //Caso nao tenha cpf, tem um valor padrao
// const {nome: apelido} = pessoa; //Pega o nome e coloca na const apelido
const {endereco:{rua, numero}} = pessoa; //Faz a desestruturacao do obj endereco
console.log(rua, numero);
// console.log(cpf);
