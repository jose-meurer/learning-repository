import geradorSenha from "./geradores";

const senhaGerada = document.querySelector(".senha-gerada");
const quantidadeCaracteres = document.querySelector(".quantidade-caracteres");
const chkMaiuscula = document.querySelector(".chk-maiuscula");
const chkMinuscula = document.querySelector(".chk-minuscula");
const chkNumero = document.querySelector(".chk-numero");
const chkSimbolo = document.querySelector(".chk-simbolo");
const btnGerarSenha = document.querySelector(".btn-gerar-senha");

export default () => {
  btnGerarSenha.addEventListener("click", () => {
    senhaGerada.innerText = novaSenha();
  });
};

function novaSenha() {
  const senha = geradorSenha(
    quantidadeCaracteres.value,
    chkMaiuscula.checked,
    chkMinuscula.checked,
    chkNumero.checked,
    chkSimbolo.checked
  );

  return senha || "Nenhum caracter foi selecionado";
}
