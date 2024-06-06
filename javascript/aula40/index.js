// continue => pula para a proxima iteração do laço
// break => sai do laço

const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

for (const n of numeros) {
  if (n === 3) {
    console.log("pulando...");
    continue;
  }

  if (n === 7) {
    console.log("saindo...");
    break;
  }

  console.log(n);
}
