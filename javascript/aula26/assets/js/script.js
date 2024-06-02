(function () {
  const form = document.getElementById("form-imc");

  form.addEventListener("submit", e => {
    e.preventDefault();

    const inputPeso = e.target.querySelector("#form-peso");
    const inputAltura = e.target.querySelector("#form-altura");

    const peso = parseFloat(inputPeso.value);
    const altura = parseFloat(inputAltura.value);

    if (!peso) {
      setResultado("Peso inválido", false);
      return;
    }

    if (!altura) {
      setResultado("Altura inválida", false);
      return;
    }

    const imc = calculaIMC(peso, altura);
    const resultadoImc = resultadoIMC(imc);
    const msg = `Seu IMC é ${imc}, ${resultadoImc}.`;

    setResultado(msg, true);
  });

  function setResultado(msg, isValid) {
    const divResultado = document.querySelector("#resultado");
    divResultado.innerHTML = "";

    const p = criaP();

    p.innerHTML = msg;

    if (isValid) {
      p.classList.add("result-imc");
    } else {
      p.classList.add("result-imc", "background-red");
    }

    divResultado.appendChild(p);
  }

  function calculaIMC(peso, alturaCM) {
    let calculo = peso / (alturaCM / 100) ** 2
    return calculo.toFixed(2);
  }

  function resultadoIMC(imc) {
    if (imc < 18.5) {
      return "Abaixo do peso";
    }

    if (imc < 25) {
      return "Peso normal";
    }

    if (imc < 30) {
      return "Sobrepeso";
    }

    if (imc < 35) {
      return "Obesidade grau 1";
    }

    if (imc < 40) {
      return "Obesidade grau 2";
    }

    if (imc >= 40) {
      return "Obesidade grau 3";
    }
  }

  function criaP() {
    return document.createElement("p");
  }
})();
