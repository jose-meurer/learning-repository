export default class ValidaCPF {
  constructor(cpfEnviado) {
    this.cpfLimpo = cpfEnviado.toString().replace(/\D+/g, "");
  }

  valida() {
    if (!this.cpfLimpo) return false;
    if (this.cpfLimpo.length !== 11) return false;
    if (this.sequencia()) return false;
    this.geraNovoCpf();

    return this.novoCpf === this.cpfLimpo;
  }

  sequencia() {
    return this.cpfLimpo.at(0).repeat(this.cpfLimpo.length) === this.cpfLimpo;
  }

  geraNovoCpf() {
    const cpfSemDigito = this.cpfLimpo.slice(0, -2);
    const digito1 = ValidaCPF.geraDigito(cpfSemDigito);
    const digito2 = ValidaCPF.geraDigito(cpfSemDigito + digito1);

    this.novoCpf = cpfSemDigito.concat(digito1, digito2);
  }

  static geraDigito(cpfSemDigito) {
    const cpfArray = [...cpfSemDigito].map(valor => Number(valor));

    const total = cpfArray.reduce((acumulador, valor, index) => {
      acumulador += valor * (cpfSemDigito.length + 1 - index);
      return acumulador;
    }, 0);

    const digito = 11 - (total % 11);
    return digito <= 9 ? String(digito) : "0";
  }
}
