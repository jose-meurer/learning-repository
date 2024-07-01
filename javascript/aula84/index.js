// 705.484.450-52 070.987.720-03

/*
    7x 0x 5x 4x 8x 4x 4x 5x 0x  Numeros do cpf
    10 9  8  7  6  5  4  3  2
    70 0  40 28 48 20 16 15 0 = 237

    (11 - (237 % 11)) === 5 (Primeiro Digito) 
    Se o numero digito for maior que 9, consideramos 0

    7x 0x 5x 4x 8x 4x 4x 5x 0x 5x
    11 10 9  8  7  6  5  4  3  2
    77 0  45 32 56 24 20 20 0  10 = 284

    (11 - (284 % 11)) === 2 (Segundo Digito)
*/

class ValidaCpf {
  constructor(cpfEnviado) {
    this.cpfLimpo = cpfEnviado.toString().replace(/\D+/g, "");

    // Object.defineProperty(this, 'cpfLimpo', {
    //     writable: false,
    //     enumerable: true,
    //     configurable: false,
    //     value: cpfEnviado.replace(/\D+/g, '')
    //   });
  }

  valida() {
    if (!this.cpfLimpo) return false;
    // if(typeof this.cpfLimpo !== 'string') return false;
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
    const digito1 = ValidaCpf.geraDigito(cpfSemDigito);
    const digito2 = ValidaCpf.geraDigito(cpfSemDigito + digito1);

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

const validaCpf = new ValidaCpf("070.987.720-03");
console.log(validaCpf.valida());

const cpfSenquencia = new ValidaCpf("777.777.777-77");
console.log(cpfSenquencia.valida());

const validaCpf2 = new ValidaCpf("705.484.450-52");
console.log(validaCpf2.valida());
