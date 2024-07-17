const rand = (min, max) => Math.floor(Math.random() * (max - min + 1) + min);

const geraMaiuscula = () => String.fromCharCode(rand(65, 90));
const geraMinuscula = () => String.fromCharCode(rand(97, 122));
const geraNumero = () => String.fromCharCode(rand(48, 57));
const geraSimbolo = () => {
  const simbolos = "<>,./?:;\"'[]{}|~`!@#$%^&*()-_=+";
  return simbolos[rand(0, simbolos.length - 1)];
};

export default (quantidade, maiuscula, minuscula, numero, simbolo) => {
  const senhaArray = [];
  quantidade = Number(quantidade);

  for (let i = 0; i < quantidade; i++) {
    if (maiuscula) senhaArray.push(geraMaiuscula());
    if (minuscula) senhaArray.push(geraMinuscula());
    if (numero) senhaArray.push(geraNumero());
    if (simbolo) senhaArray.push(geraSimbolo());
  }

  const randArray = () => Math.round(Math.random()) - 0.5;
  let senha = senhaArray.sort(randArray);

  return senha.slice(0, quantidade).join("");
};
