// Polimorfismo

// Super classe
function Conta(agencia, conta, saldo) {
  this.agencia = agencia;
  this.conta = conta;
  this.saldo = saldo;
}

Conta.prototype.sacar = function (valor) {
  if (valor > this.saldo) {
    return `Saldo insuficiente: ${this.saldo}`;
  }

  this.saldo -= valor;
  return this.verSaldo();
};

Conta.prototype.depositar = function (valor) {
  this.saldo += valor;
  return this.verSaldo();
};

Conta.prototype.verSaldo = function () {
  return `Agencia/Conta: ${this.agencia}/${this.conta} |
Saldo: R$${this.saldo.toFixed(2)}`;
};

// Conta Poupança
function ContaPopanca(agencia, conta, saldo) {
  Conta.call(this, agencia, conta, saldo);
}
ContaPopanca.prototype = Object.create(Conta.prototype);
ContaPopanca.prototype.constructor = ContaPopanca;

// Conta Corrente
function ContaCorrente(agencia, conta, saldo, limite) {
  Conta.call(this, agencia, conta, saldo);
  this.limite = limite;
}
ContaCorrente.prototype = Object.create(Conta.prototype);
ContaCorrente.prototype.constructor = ContaCorrente;

ContaCorrente.prototype.sacar = function (valor) {
  if (valor > this.saldo + this.limite) {
    return `Saldo insuficiente: ${this.saldo}`;
  }

  this.saldo -= valor;
  return this.verSaldo();
};

const contaP = new ContaPopanca("001", "54829", 100.0);
console.log(contaP.verSaldo());
console.log(contaP.depositar(10));
console.log(contaP.sacar(105));

console.log();
const contaC = new ContaCorrente("001", "42134", 100.0, 50.0);
console.log(contaC.verSaldo());
console.log(contaC.sacar(140.0));
console.log(contaC.sacar(15.0));
