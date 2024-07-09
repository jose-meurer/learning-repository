//axios

// Com xhr
// async function carregaDados() {
//   const request = obj => {
//     return new Promise((resolve, reject) => {
//       const xhr = new XMLHttpRequest();
//       xhr.open(obj.method, obj.url, true);
//       xhr.send();

//       xhr.addEventListener("load", e => {
//         if (xhr.status >= 200 && xhr.status < 300) {
//           resolve(xhr.responseText);
//         } else {
//           reject(xhr.statusText);
//         }
//       });
//     });
//   };

//   const objConfig = {
//     url: "pessoas.json",
//     method: "GET",
//   };

//   const json = await request(objConfig);
//   carregaElementosNaPagina(JSON.parse(json));
// }
// carregaDados();

// Com fetch API
//  fetch('pessoas.json')
//     .then(response => response.json())
//     .then(json => carregaElementosNaPagina(json));

// Com axios
async function carregaDados(path) {
  const resposta = await axios.get(path);
  carregaElementosNaPagina(resposta.data);
}
carregaDados("pessoas.json");

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

function criaTD() {
  return document.createElement("td");
}
