const verdadeira = true;

//let tem espoco de bloco { ... bloco};
//var só tem espoco de funcao function f() { ... funcao}

let n1 = "let Global";
var n2 = "var Global";

console.log("Global", n1, n2);

if (verdadeira) {
  let n1 = "let bloco";
  var n2 = "var bloco";

  console.log("Bloco 1", n1, n2);

  if (verdadeira) {
    let n1 = "let bloco2";
    var n2 = "var bloco2";

    console.log("Bloco 2", n1, n2);
  }

  console.log("Bloco 1", n1, n2);
}

console.log("Global", n1, n2);

function f() {
  let f1 = "Funcao let";
  var f2 = "Funcao var";
}

// console.log(f1, f2); //Erro

console.log(h1);

var h1 = "Hoisting var"; //Var tem hoisting
// let h2 = 'Hoisting let'; //Erro
