import GeraCPF from "./modules/GeraCPF";

import "./assets/css/style.css";

(() => {
  const gera = new GeraCPF();
  const cpfGerado = document.querySelector(".cpf-gerado");
  cpfGerado.textContent = gera.geraNovoCpf();

  const btnGerarCpf = document.querySelector(".btn-gera-cpf");
  btnGerarCpf.addEventListener("click", () => (cpfGerado.textContent = gera.geraNovoCpf()));
})();
