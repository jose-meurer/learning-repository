//  	         01234567
let umaString = "Um texto diario ou um poema"; // Usar \ para escapar o caracter "Um \" texto \""

console.log(umaString);

console.log(umaString[3]); //pega o caracter do index 3
console.log(umaString.charAt(4)); //Pega o caracter do indice 4

console.log(umaString.concat(" para lembrar,")); //Faz a mesma coisa que o +
console.log(umaString + " para lembrar de hoje.");
console.log(`${umaString} para escrever na alma.`); //Melhor pratica

console.log("Primeira ocorrencia: ", umaString.indexOf("o", 3)); //.indexOf(valor, procurar apartir de qual index);

//semelhante ao indexOf, mas procurar de tras para frente
console.log("Ultima ocorrencia: ", umaString.lastIndexOf("o", 15)); //lastIndexOf(valor, procurar ate qual index)

console.log(umaString.match(/[a-z]/g)); //Com o g, retorna um array com os todos os resultados

console.log(umaString.search(/i/)); //Parecido com indexOf, mas aceita regEx

console.log(umaString.replace(/Um/, "Outro dia")); //Substitui uma palavra/letra por outra

console.log(umaString.replaceAll("o", "??")); //replaceAll nao aceita expressoes regulares
console.log(umaString);

console.log(umaString.length);

console.log(umaString.slice(3, 12));

console.log(umaString.slice(-5)); //Tamanho da string -5, e percorre desse char até o final
console.log(umaString.slice(-5, -1));
//Mesma coisa em substring
console.log(umaString.substring(umaString.length - 5, umaString.length - 1));

console.log(umaString.split(" "));

console.log(umaString.toLowerCase);
console.log(umaString.toUpperCase);
console.log(umaString.to);

console.log(umaString);

console.log(umaString.includes("o")); //retorna um boolean
console.log(umaString.indexOf("o") > -1); //forma antiga, antes do includes

console.log(umaString.charAt(4));
console.log(umaString.charCodeAt(4)); //retorna o unicode do char
console.log(umaString.length);