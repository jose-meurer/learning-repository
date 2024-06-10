// Funcoes de callback
function random(min = 500, max = 2000) {
  return Math.round(Math.random() * (max - min) + min);
}

function f1(callback) {
  setTimeout(() => {
    console.log("f1");
    if (callback) callback();
  }, random());
}

function f2(callback) {
  setTimeout(() => {
    console.log("f2");
    if (callback) callback();
  }, random());
}

function f3(callback) {
  setTimeout(() => {
    console.log("f3");
    if (callback) callback();
  }, random());
}

// f1(() => {
//   f2(() => {
//     f3(() => {
//       console.log("Callback hell");
//     });
//   });
// });

// Uma maneira melhor, porem promises é a melhor solucao
f1(f1Callback);

function f1Callback() {
  f2(f2Callback);
}

function f2Callback() {
  f3(f3Callback);
}

function f3Callback() {
  console.log("Fim dos Callback");
}
