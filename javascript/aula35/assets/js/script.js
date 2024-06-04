//Exercício
(function () {
  const container = document.querySelector(".container");
  const div = criaElemento("div");

  const elementos = [
    { tag: "p", texto: "Frase do p" },
    { tag: "div", texto: "Frase da div" },
    { tag: "footer", texto: "Frase do footer" },
    { tag: "section", texto: "Frase da section" },
  ];

  for (let i = 0; i < elementos.length; i++) {
    const { tag, texto } = elementos[i];

    const elemento = criaElemento(tag);
    const textoElemento = criaTexto(texto);
    elemento.appendChild(textoElemento);
    // elemento.innerText = texto;
    div.appendChild(elemento);
  }

  container.appendChild(div);

  function criaElemento(tag) {
    return document.createElement(tag);
  }

  function criaTexto(texto) {
    return document.createTextNode(texto);
  }
})();
