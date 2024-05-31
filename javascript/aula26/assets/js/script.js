(function () {
  const form = document.getElementById("form-imc");
  const button = document.getElementById("form-button");
  const resultElement = document.querySelector(".result-imc");

  button.addEventListener("click", e => {
    e.preventDefault();

    const peso = parseFloat(document.querySelector("#form-peso").value);
    const altura = parseFloat(document.querySelector("#form-altura").value);

    resultElement.classList.remove("background-green", "background-red");

    if (valoresValidos(peso, altura)) {
      const imc = calcularIMC(peso, altura);
      resultElement.classList.add("background-green");
      resultElement.textContent = `IMC = ${resultadoIMC(imc)}.`;
    } else {
      resultElement.classList.add("background-red");
      resultElement.textContent = "Valores invalidos.";
    }
  });

  function calcularIMC(peso, alturaCM) {
    const alturaM = alturaCM / 100;
    return peso / (alturaM * alturaM);
  }

  function resultadoIMC(imc) {
    if (imc < 18.5) {
      return "Abaixo do peso";
    } else if (imc >= 18.5 && imc < 25) {
      return "Peso normal";
    } else if (imc >= 25 && imc < 30) {
      return "Sobrepeso";
    } else if (imc >= 30 && imc < 35) {
      return "Obesidade grau 1";
    } else if (imc >= 35 && imc < 40) {
      return "Obesidade grau 2";
    } else if (imc >= 40) {
      return "Obesidade grau 3";
    }
  }

  function valoresValidos(peso, altura) {
    if (isNaN(peso) || isNaN(altura)) {
      return false;
    }
    return true;
  }
})();
