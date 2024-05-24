//const numero = Number(window.prompt("Digite seu numero:"));
const numero = 55.1787555;
const numeroH1 = window.document.getElementById("numero-h1");
const textoDiv = document.getElementById("texto");

numeroH1.innerHTML = numero;
textoDiv.innerHTML = `<p>Raiz quadrada: ${numero ** 0.5}</p>`;
textoDiv.innerHTML += `<p>Seu numero mais ele mesmo é: ${numero + numero}</p>`;
textoDiv.innerHTML += `<p>${numero} é inteiro: ${Number.isInteger(numero)}</p>`;
textoDiv.innerHTML += `<p>É NaN: ${Number.isNaN(numero)}</p>`; //Number.isNaN() é diferente de .isNaN()
textoDiv.innerHTML += `<p>Arredondado para baixo: ${Math.floor(numero)}</p>`;
textoDiv.innerHTML += `<p>Arredonda para cima: ${Math.ceil(numero)}</p>`;
textoDiv.innerHTML += `<p>Com duas casas decimais: ${numero.toFixed(2)}</p>`;