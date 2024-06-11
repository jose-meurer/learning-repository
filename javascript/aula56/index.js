// Factory function
function criaPessoa(nome, sobrenome, altura, peso) {
  return {
    nome,
    sobrenome,
    altura,
    peso,

    //Getter
    get nomeCompleto() {
      return `${this.nome} ${this.sobrenome}`;
    },

    //Setter
    set nomeCompleto(valor) {
      valor = valor.split(" ");
      this.nome = valor.shift();
      this.sobrenome = valor.join("");
    },

    fala(assunto = "falando sobre alguma coisa") {
      return this.nome + " está " + assunto + ".";
    },

    //Getter
    get imc() {
      const calculoImc = this.peso / this.altura ** 2;
      return calculoImc.toFixed(2);
    },
  };
}

const pessoa1 = criaPessoa("José", "Meurer", 2.0, 100);
console.log(pessoa1.imc); // Ao usar o get, a funcao se "comporta" como uma variavel
console.log(pessoa1.nomeCompleto);
pessoa1.nomeCompleto = "João Cabral";
console.log(pessoa1.nomeCompleto);
console.log(pessoa1.fala());
