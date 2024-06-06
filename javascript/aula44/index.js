//Tratamento de erros

function soma(x, y) {
  if (typeof x !== "number" || typeof y !== "number") {
    throw new Error("Os valores precisam ser numeros");
  }
  return x + y;
}

try {
  console.log(soma(12, 10));
  console.log(soma(12, "10"));
} catch (e) {
  console.log(e);
  console.log("Mensagem mais amigável para o usuario final");
}

console.log("#####################");

try {
  console.log("Tento ser executado");
  console.log(a);
} catch (e) {
  console.log("Sou executado se tiver erro");
} finally {
  console.log("Sempre sou executado.");
}

console.log("######################");

const retornaHora = data => {
  if (data && !(data instanceof Date)) {
    throw new TypeError("Esperando como argumento uma instância de Date");
  }

  data = data || new Date();

  return Intl.DateTimeFormat("pt-BR", {
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false,
  }).format(data);
};

try {
  const data = new Date("03-05-2002 14:56:21");
  // const hora = retornaHora(data);
  const hora = retornaHora('Abril');
  console.log(hora);
} catch (e) {
  console.log(e);
} finally {
  console.log("Tenha um bom dia.");
}
