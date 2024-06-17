// Retorne a soma do dobro de todos os pares
const numeros = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27];

const numerosParesDobro = numeros
  .filter(valor => valor % 2 === 0)                        // Filtra pares
  .map(valor => valor * 2)                                // Dobra os valores
  .reduce((acumulador, valor) => (acumulador += valor)); // Soma tudo

console.log(numerosParesDobro);
