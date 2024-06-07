(function () {
  const inputTarefa = document.querySelector(".input-tarefa");
  const btnTarefa = document.querySelector(".btn-tarefa");
  const tarefas = document.querySelector(".tarefas");

  mostraTarefasSalvas();

  btnTarefa.addEventListener("click", e => {
    if (!inputTarefa.value) return;

    criaTarefa(inputTarefa.value);
  });

  inputTarefa.addEventListener("keypress", e => {
    if (e.keyCode === 13) {
      if (!inputTarefa.value) return;

      criaTarefa(inputTarefa.value);
    }
  });

  document.addEventListener("click", e => {
    const elemento = e.target;

    if (elemento.classList.contains("apagar")) {
      elemento.parentElement.remove();
      salvarTarefas();
    }
  });

  function limpaInput() {
    inputTarefa.value = "";
    inputTarefa.focus();
  }

  function criaTarefa(textoInput) {
    const li = criaLi();
    const p = criaP();
    p.innerText = textoInput;
    li.appendChild(p);
    li.classList.add("tarefa__li");
    tarefas.appendChild(li);
    limpaInput();
    criaBotaoApagar(li);
    salvarTarefas();
  }

  function criaLi() {
    const li = document.createElement("li");
    return li;
  }

  function criaP() {
    return document.createElement("p");
  }

  function criaButton() {
    return document.createElement("button");
  }

  function criaBotaoApagar(li) {
    const botaoApagar = criaButton();
    botaoApagar.textContent = "Apagar";
    botaoApagar.setAttribute("class", "apagar");
    botaoApagar.setAttribute("title", "Apagar esta tarefa");
    li.appendChild(botaoApagar);
  }

  // Salvar no localStorage

  function salvarTarefas() {
    const liTarefas = tarefas.querySelectorAll("li");
    const listaDeTarefas = [];

    for (const tarefa of liTarefas) {
      const p = tarefa.querySelector("p");
      listaDeTarefas.push(p.textContent);
    }

    const tarefasJSON = JSON.stringify(listaDeTarefas);
    localStorage.setItem("tarefa", tarefasJSON);
  }

  function mostraTarefasSalvas() {
    const tarefas = localStorage.getItem("tarefa");

    if (!tarefas) return;

    const listaDeTarefas = JSON.parse(tarefas);

    for (const tarefa of listaDeTarefas) {
      criaTarefa(tarefa);
    }
  }
})();
