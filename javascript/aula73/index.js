/*
Object.entries
Object.getOwnPropertyDescriptor
Object.assign => Copia um objeto, semelhante ao join do array (destino, any)
... => spread

Object.values => retorna os valores
Object.keys => retorna as chaves
Object.freeze => congela o objeto
Object.defineProperty => define uma propriedade
Object.defineProperties => define varias propriedades
*/

const produto = {
  nome: "Caneca",
  preco: 20,
  material: "Plastico",
};

console.log("entries: ", Object.entries(produto));

Object.defineProperty(produto, "material", {
  enumerable: true,
  writable: true,
  value: "Porcelana",
  configurable: false,
});
console.log("getOwnPropertyDescriptor: ", Object.getOwnPropertyDescriptor(produto, "material"));

const p2 = { ...produto };
console.log("...spread: ", p2);

const p3 = Object.assign({}, produto, {
  dataFabricacao: Intl.DateTimeFormat("pt-br", {
    dateStyle: "short",
  }).format(new Date()),
});
console.log("assing: ", p3);
