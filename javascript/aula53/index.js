//Closures
const variavelFora = "Sou uma variavel de fora da funcao";

function retornaFuncao(nome) { // as variáveis dentro de uma closure são acessíveis apenas dentro da função
  const sobrenome = "Meurer";
  return function () {
    return nome + " " + sobrenome + " " + variavelFora;
  };
}

const funcao = retornaFuncao("José");
const funcao2 = retornaFuncao("Miguel");

console.dir(funcao);
console.dir(funcao2);

console.log(funcao());
console.log(funcao2());

const f = function () {
  console.log(variavel);
};

const variavel = "Sou uma variavel"; //Posso declarar a variavel após a funcao, mas antes de chama-la

f();
console.dir(f);
