// Espoco léxico
const nome = "José";

function falaNome() {
  console.log(nome);
}

function usaFalaNome() {
  const nome = "Miguel"; //Usa o espoco de onde foi declarada
  falaNome();
}

usaFalaNome(); //José
