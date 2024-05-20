console.log("Jose Meurer"); //Aspas simples
console.log("Jose Meurer"); //Aspas duplas
console.log(`Jose Meurer`); //Crase com template

console.log(15, 16.32, "Jose Meurer");

//exercicio
let nome = "Jose Meurer";
// const dataAtual = new Date();
// const horaAtual = dataAtual.getHours();

const horas = () => {
    const dataAtual = new Date();
    return dataAtual.getHours();
}
console.log(`Meu nome é ${nome}. Estou revisando JavaScript às ${horas()}h.`);