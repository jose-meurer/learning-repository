// Modifica o array original

const nomes = ["Maria", "João", "Eduardo", "Júlia", "Davi", "Valentina", "Carlos"];

//splice(indice inicial, quantidade de indices para remover, rest de itens para adicionar)

const arr1 = Array.from(nomes);
const nomesRemovidos = arr1.splice(1, 3, "José", "Nicolas");
console.log("Nomes: ", arr1, "Removidos: ", nomesRemovidos); //Retorna uma array dos elementos removidos

//Simular pop()
const arr2 = Array.from(nomes);
let retorno = arr2.splice(-1, 1);
console.log("Pop(): ", arr2, retorno);

//Simular shift()
const arr3 = Array.from(nomes);
retorno = arr3.splice(0, 1);
console.log("Shift(): ", arr3, retorno);

//Simular push()
const arr4 = Array.from(nomes);
retorno = arr4.splice(arr4.length, 0, "Tarcisio");
console.log("Push(): ", arr4, retorno);

//Simular Unshift()
const arr5 = Array.from(nomes);
arr5.splice(0, 0, "Antonio");
console.log("Unshift(); ", arr5, retorno);
