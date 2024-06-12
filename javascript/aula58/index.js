// Construtor function => objeto
function Pessoa(nome, sobrenome) {
  // Atributos ou metodos privados
  const ID = 32131;
  const metodoInterno = () => {
    return nome + ": Sou um metodo interno";
  };

  // Atributos ou metodos publicos
  this.nome = nome;
  this.sobrenome = sobrenome;

  this.metodo = function () {
    console.log(`${this.nome}: sou um metodo.`);
  };
}

const pessoa1 = new Pessoa("José", "Meurer");
const pessoa2 = new Pessoa("Miguel", "Brown");

pessoa1.metodo();
