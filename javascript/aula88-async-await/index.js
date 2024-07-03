// async - await

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
      resolve(msg.toLocaleUpperCase() + " => Passei na promise");
      return;
    }, time);
  });
}

//Inves de usar then e catch

// esperaAi('Fase 1', rand())
//   .then(valor => {
//     console.log(valor);
//     return esperaAi('Fase 2', rand());
//   })
//   .then(fase => {
//     console.log(fase);
//     return esperaAi('Fase 3', rand());
//   })
//   .then(fase => {
//     console.log(fase);
//     return fase;
//   })
//   .then(fase => {
//     console.log('Terminamos na fase:', fase);
//   })
//   .catch(e => console.log(e));

//Podemos usar async e await para deixar o codigo mais legivel
async function executa() {
  try {
    const fase1 = await esperaAI("Fase 1", rand());
    console.log(fase1);

    const fase2 = await esperaAI("Fase 2", rand());
    console.log(fase2);

    const fase3 = await esperaAI(3, rand());
    console.log(fase3);
    
  } catch (e) {
    console.error("ERRO: " + e);
  }
}
// executa();

const teste = esperaAI("Exemplo de promise pedente", 1000);
console.log(teste);

setTimeout(() => {
    console.log("Mostra o objeto promise:", teste);
    teste.then(x => console.log("Mostra o resolve da promise:", x));
}, 1100);

