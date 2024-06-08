// Declaração de função (Function hoisting)
helloWorld();

function helloWorld() {
  console.log("Hello World!!!");
}

// Funções são tratadas como First-class objects (Objetos de primeira classe)
function f(funcao) {
  //Recebendo uma funcao como argumento
  console.log('Executando função que recebi como argumento: ')
  funcao();
}

f(helloWorld);

// Function expression
const souUmDado = function () {
  console.log("Sou um dado.");
};

souUmDado();

//Arrow function
const funcaoArrow = () => {
  console.log("Sou uma arrow function");
};

funcaoArrow();

//Funções dentro de objetos
const obj = {
  nome: "José",
  falar() {
    console.log(this.nome + " está falando oi!");
  },
};

obj.falar();
