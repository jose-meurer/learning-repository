function raizFunction(n) {
  return n ** 0.5;
}

console.log("Funcao decladarada: " + raizFunction(9));

const raizAnonima = function (n) {
  return n ** 0.5;
};

console.log("Funcao anonima: " + raizAnonima(16)); //Function Expressions

const raizArrow = (n) => {
  return n ** 0.5;
};

console.log("Arrow Function: " + raizArrow(25));

const arrowSimplificada = (n) => n ** 0.5;

console.log("Arrow simplificada: " + arrowSimplificada(36));
