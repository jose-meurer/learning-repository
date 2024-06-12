// Funcao recursiva
function recursiva(valor) {
  if (valor > 1000) return;
  console.log(valor);
  valor++;
  recursiva(valor);
}

recursiva(0);
