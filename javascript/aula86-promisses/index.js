function rand(min = 1, max = 3) {
  min *= 1000;
  max *= 1000;

  return Math.floor(Math.random() * (max - min) + min);
}

function esperaAI(msg, time) {
  return new Promise((resolve, reject) => {
    if (typeof msg !== "string") {
       reject("BAD VALUE");
       console.log("....")
       return;
    }

    setTimeout(() => {
      resolve(msg);
    }, time);
  });
}

esperaAI("Estabelecendo conexão com o Banco de Dados", rand())
  .then(response => {
    console.log(response);
    return esperaAI("Buscando dados...", rand());
  })
  .then(response => {
    console.log(response);
    return esperaAI("Filtrando dados...", rand());
  })
  .then(response => {
    console.log(response);
    return esperaAI(3123123, rand());
  })
  .then(response => {
    console.log(response);
  })
  .catch(err => {
    console.log("Erro: " + err);
  });

console.log("Promisses são assíncronas, então esse texto será exibido antes de tudo.");
