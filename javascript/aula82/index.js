//Heranca em Classes
class DispositivoEletronico {
  constructor(nome) {
    this.nome = nome;
    this.ligado = false;
  }

  ligar() {
    if (this.ligado) {
      console.log(this.nome + " já está ligado.");
      return;
    }

    this.ligado = true;
  }

  desligar() {
    if (!this.ligado) {
      console.log(this.nome + " já está desligado.");
      return;
    }

    this.ligado = false;
  }
}

// Filha 1
class Celular extends DispositivoEletronico {
  constructor(nome, modelo, cor, temWifi) {
    super(nome);
    this.modelo = modelo;
    this.cor = cor;
    this.temWifi = temWifi;
    this.wifi = false;
  }

  ligarWifi() {
    if (!this.ligado) {
      console.log("Você precisa ligar o dispositivo primeiro");
      return;
    }

    if (!this.temWifi) {
      console.log("Seu aparelho não possui wi-fi.");
      return;
    }

    if (this.wifi) {
      console.log(this.nome + " já está com o wi-fi ligado.");
      return;
    }

    this.wifi = true;
  }

  desligarWifi() {
    if (!this.ligado) {
      console.log("Você precisa ligar o dispositivo primeiro");
      return;
    }

    if (!this.temWifi) {
      console.log("Seu aparelho não possui wi-fi.");
      return;
    }

    if (this.wifi) {
      console.log(this.nome + " já está com o wi-fi desligado.");
      return;
    }

    this.wifi = false;
  }
}

const celular1 = new Celular("Samsung", "S20", "Cinza", true);
console.log(celular1);
celular1.ligarWifi();
celular1.ligar();
celular1.ligarWifi();
console.log(celular1);

const celular2 = new Celular("Apple", "Iphone X", "Preto", false);
console.log(celular2);
celular2.desligarWifi();
celular2.ligar();
celular2.desligarWifi();
console.log(celular2);

// Filha2 ...
