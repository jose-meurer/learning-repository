// Compatibilidade de recursos novos do JS para versoes antigas de browser
import "core-js/stable";
import "regenerator-runtime/runtime";

import "./assets/css/style.css";

function promise(valor) {
  return new Promise((resolve, reject) => {
    if (typeof valor !== "string") {
      reject(new TypeError("Valor esperado é uma string"));
      return;
    }

    setTimeout(() => {
      resolve("Valor processado com sucesso");
    }, 2000);
  });
}

async function carrega(valor) {
  const response = await promise(valor);
  console.log(response);
}

carrega("Feijão");
