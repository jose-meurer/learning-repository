// IIFE => Immediately invoked function expression

function helloWorld() {
  console.log("Hello World!");
}
helloWorld(); // Ainda estou poluindo o espoco global com um funcao

(function (nome) {
  const sobrenome = "Meurer";

  console.log(`Meu nome é ${nome} ${sobrenome}`);
})("José"); // Como é uma funcao anonima auto-invocavel, não estou poluindo escopo global
