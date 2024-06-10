// returno de funcao

function criaMultiplicador(multiplicador) {
  return n => {
    return n * multiplicador;
  };
}

const duplica = criaMultiplicador(2);
const triplica = criaMultiplicador(3);
const quadriplica = criaMultiplicador(4);

console.log(duplica(5));
console.log(triplica(10));
console.log(quadriplica(20));

function criaPessoa(nome) {
  return function sobrenome(sobrenome) {
    return nome + " " + sobrenome;
  };
}

const pessoa = criaPessoa("José");
console.log(pessoa("meurer"));
