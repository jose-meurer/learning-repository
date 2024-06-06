// setInterval => executa o codigo em loop
// setTimeout =>  execut uma vez e sai

function mostraHora() {
  return Intl.DateTimeFormat("pt-BR", {
    hour12: false,
    timeStyle: 'medium'
  }).format(new Date());
}

console.log(mostraHora());
const timer = setInterval(() => console.log(mostraHora()), 1000);

setTimeout(() => clearInterval(timer), 11000);

setTimeout(() => console.log('Se passou 10 segundos...'), 11000);
