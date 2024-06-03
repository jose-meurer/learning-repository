const tresHoras = 60 * 60 * 3 * 1000;
const umDia = 60 * 60 * 24 * 1000;

let data = new Date(0); //01/01/1970 00h00 Timestamp unix ou época unix
console.log(data.toString());

data = new Date(); //Data atual
console.log(data.toString());

data = new Date(0 + tresHoras);
console.log(data.toString());

data = new Date(0 + tresHoras - umDia);
console.log(data.toString());

data = new Date(2020, 5, 19, 15, 43, 11, 743); //ano, mes, dia, hora, minuto, segundo, ms
console.log(data.toString());

data = new Date("2024-05-19T14:32:54.832Z"); //ISO 8601
console.log(data);

console.log("Dia", data.getDate());
console.log("Mês", data.getMonth());
console.log("Ano", data.getFullYear());
console.log("Hora", data.getHours());
console.log("Minutos", data.getMinutes());
console.log("Segundos", data.getSeconds());
console.log("ms", data.getMilliseconds());
console.log("Dia da Semana", data.getDay());
console.log(Date.now());

function zeroAEsquerda(num) {
  return num >= 10 ? num : `0${num}`;
}

function formataData(data) {
  const dia = zeroAEsquerda(data.getDate());
  const mes = zeroAEsquerda(data.getMonth());
  const ano = zeroAEsquerda(data.getFullYear());
  const hora = zeroAEsquerda(data.getHours());
  const min = zeroAEsquerda(data.getMinutes());
  const sec = zeroAEsquerda(data.getSeconds());

  return `${dia}/${mes}/${ano} ${hora}:${min}:${sec}`;
}

data = new Date();
const dataBrasil = formataData(data);
console.log(dataBrasil);
