const pessoas = [
  { id: 3, nome: "João" },
  { id: 2, nome: "Helena" },
  { id: 1, nome: "Maria" },
];

// Jeito 1
const novas = pessoas.map(pessoa => {
  const { id } = pessoa;
  return {
    [id]: pessoa,
  };
});

// Jeito 2, porem nao preserva a ordem que os elementos foram inseridos
const novasPessoas = {};
for (const pessoa of pessoas) {
    const {id} = pessoa
  novasPessoas[id] = { ...pessoa };
}

//Jeito 3 Map
const novasMap = new Map();
for (const pessoa of pessoas) {
  novasMap.set(pessoa.id, { ...pessoa });
}

console.log(novasMap);
console.log(novasMap.get(2));
