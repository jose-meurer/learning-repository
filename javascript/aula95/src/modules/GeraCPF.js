import ValidaCPF from "./validaCPF";

export default class GeraCPF {
  rand(min = 1, max = 999999999) {
    return String(Math.floor(Math.random() * (max - min) + min));
  }

  zeroEsquerdaNoveDigitos(numero) {
    return String(numero).padStart(9, "0");
  }

  geraNovoCpf() {
    let cpfSemDigito = this.rand();
    cpfSemDigito = this.zeroEsquerdaNoveDigitos(cpfSemDigito);

    const digito1 = ValidaCPF.geraDigito(cpfSemDigito);
    const digito2 = ValidaCPF.geraDigito(cpfSemDigito + digito1);
    const novoCpf = cpfSemDigito + digito1 + digito2;

    if (this.sequencia(novoCpf)) this.geraNovoCpf();

    return this.formatado(novoCpf);
  }

  sequencia(cpf) {
    return cpf.at(0).repeat(cpf.length) === cpf;
  }

  formatado(cpf) {
    return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
    // return (
    //     cpf.slice(0, 3) + "." +
    //     cpf.slice(3, 6) + "." +
    //     cpf.slice(6, 9) + "-" +
    //     cpf.slice(9, 11))
  }
}
