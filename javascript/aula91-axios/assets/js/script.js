//axios

/* fetch('pessoas.json')
    .then(response => response.json())
    .then(json => carregaElementosNaPagina(json));
*/

async function carregaDados(path) {
  const resposta = await axios(path);
  carregaElementosNaPagina(resposta.data);
}

function carregaElementosNaPagina(json) {
  const div = document.createElement("div");
  div.classList.add("resultado");

  const container = document.querySelector(".container");
  container.appendChild(div);

  const table = document.createElement("table");
  const thead = document.createElement("tr");

  let tdNome = criaTD();
  tdNome.innerText = "Nome";
  let tdEmail = criaTD();
  tdEmail.innerText = "Email";
  let tdEmpresa = criaTD();
  tdEmpresa.innerText = "Empresa";

  thead.append(tdNome, tdEmail, tdEmpresa);
  table.appendChild(thead);

  json.forEach(element => {
    const tr = document.createElement("tr");

    const tdNome = criaTD();
    tdNome.innerText = element.nome;
    const tdEmail = criaTD();
    tdEmail.innerText = element.email;
    const tdEmpresa = criaTD();
    tdEmpresa.innerText = element.empresa;

    tr.append(tdNome, tdEmail, tdEmpresa);

    table.appendChild(tr);
  });

  div.appendChild(table);
}

carregaDados("pessoas.json");


function criaTD() {
    return document.createElement("td");
}