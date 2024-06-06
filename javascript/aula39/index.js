// While e do while

function random(min, max) {
  min = min || 1;
  max = max || 100;

  return Math.round(Math.random() * (max - min) + min);
}

const numeroRequerido = 3;

// let rand = random();

// while(rand !== numeroRequerido) {
//     rand = random();
//     console.log(rand);
// }

// console.log('Fim do while...');

let rand;
do {
  rand = random();
  console.log(rand);
} while (rand !== numeroRequerido);

console.log("Numero final:", rand);
console.log("Fim do do-while....");
