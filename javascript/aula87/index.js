// Promise methods

function rand(min = 1, max = 3) {
  min *= 1000;
  max *= 1000;

  return Math.floor(Math.random() * (max - min) + min);
}

function esperaAI(msg, time) {
  return new Promise((resolve, reject) => {
    if (typeof msg !== "string") {
      reject("BAD VALUE");
      return;
    }

    setTimeout(() => {
      resolve(msg);
    }, time);
  });
}

function baixaPagina() {
  const emCache = false;
  const apiOnline = false;

  if (emCache) {
    return Promise.resolve("Página em cache");
  }

  if(!apiOnline) {
    return Promise.reject("API não está respondendo");
  }

  return esperaAI("Baixei a página", rand(1, 5));
}

baixaPagina()
  .then(dadosPagina => console.log(dadosPagina))
  .catch(e => console.log("ERRO: " + e));

const promises = [
  esperaAI("PROMISE 1 ", rand(1, 5)),
  esperaAI("PROMISE 3 ", rand(1, 5)),
  esperaAI("PROMISE 3 ", rand(1, 5)),
  //   esperaAI(4, rand(1, 5)),
];

Promise.all(promises) // Espera todas as promises serem resolvidas e retorna todas
  .then(resolve => console.log("ALL: " + resolve))
  .catch(reason => console.log("ERROR: " + reason));

Promise.race(promises) // Retorna apenas a primeira promise a ser resolvida
  .then(resolve => console.log("RACE: " + resolve))
  .catch(reason => console.log("ERROR: " + reason));
