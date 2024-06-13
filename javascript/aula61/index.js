//Funcoes geradoras
function* geradora1() {
  //Nao esquecer do *
  //Codigo
  yield "Valor 1"; //yield é parecido com return, mas seria mais como uma "pausa"

  //Codigo
  yield "Valor 2";

  //Codigo
  yield "Valor 3";
}

const gera1 = geradora1();
console.log(gera1.next().value);
console.log(gera1.next());
console.log(gera1.next());
console.log(gera1.next());

function* gerador2() {
  yield 0;
  yield 1;
  yield 2;
}

function* gerador3() {
  yield* gerador2();
  yield 3;
  yield 4;
  yield 5;
  yield 6;
}

const gera3 = gerador3();

for (let valor of gera3) {
  console.log(valor);
}

function* gerador4() {
  yield function () {
    console.log("Vim do yield 1");
  };

  yield () => console.log("Vim do yield 2");
}

const gera4 = gerador4();

const f1 = gera4.next().value;
const f2 = gera4.next().value;
f1();
f2();

gerador4().next().value();

function* fibonacci() {
  let a = 1;
  let b = 1;
  while (true) {
    let curr = b;
    b = a;
    a = a + curr;
    const reset = yield curr; //Ao chamar a funcao novamente, posso passar um argumento
    console.log(reset);
    if (reset === true) a = b = 1;
  }
}

const sequence = fibonacci();
console.log(sequence.next().value); // 1 Executa até o primeiro yield
console.log(sequence.next("Argumento 1").value); // 1 Posso passar argumentos para o ultimo yield chamado
console.log(sequence.next().value); // 2
console.log(sequence.next().value); // 3
console.log(sequence.next().value); // 5
console.log(sequence.next(true).value); // 1
console.log(sequence.next().value); // 1
console.log(sequence.next().value); // 2
console.log(sequence.next().value); // 3
