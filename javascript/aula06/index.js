const constante = "José";
let variavel = 26;
console.log(constante);


//Exercicios
let nome = "José";
let sobrenome = "Meurer"
let idade = 26;
let peso = 99;
let alturaCm = 199;
let imc = () => {
    return peso / (alturaCm / 100 * alturaCm / 100);
}

console.log(`${nome} ${sobrenome} tem ${idade} anos, pesa ${peso}, tem ${(alturaCm / 100).toFixed(2)} de altura e seu IMC é de ${imc().toFixed(4)}`);