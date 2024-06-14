// Concatenar arrays

const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = [7, 8, 9];
const arr4 = arr1.concat(arr2, arr3, "Luiz");
console.log(arr4);

const arr5 = [...arr1, "José", ...arr2, 3, 5, 6, ...[12, 13, 14]]; // ...Spead operator
console.log(arr5);

console.log("###############################");

const pessoa1 = {
  nome: "José",
  sobrenome: "Meurer",
  idade: 26,
};

const casa = {
  modelo: "Sobrado",
  rua: "Nicolas da Silva",
  numero: 40,
};

const pessoa3 = { ...pessoa1, ...casa }; // Exemplo de Spread operator com objetos
console.log(pessoa3);
