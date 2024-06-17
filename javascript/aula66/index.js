// Map => retorna um novo array

// Dobre os números
const numeros = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27];

const numerosDobrados = numeros.map(valor => valor * 2);
console.log(numerosDobrados);

/* 
Para cada elemento:
Retorne apenas uma string com o nome da pessoa
Remova apenas a chave "nome" do objeto
Adicione uma chave id em cada objeto
*/
const pessoas = [
  { nome: "José", idade: 62 },
  { nome: "Maria", idade: 23 },
  { nome: "Eduarco", idade: 55 },
  { nome: "Letícia", idade: 19 },
  { nome: "Rosana", idade: 32 },
  { nome: "Wallace", idade: 47 },
];

const nomes = pessoas.map(({nome}) => nome); //Mesma coisa que pessoas.map(obj => obj.nome)

const idades = pessoas.map(obj => ({ idade: obj.idade })); //Expressao

const comIds = pessoas.map((obj, index) => ({ id: index + 1, ...obj }));

console.log(nomes);
// console.log(idades);
console.log(comIds);
console.log(pessoas);
