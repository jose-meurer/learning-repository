/**
 *    replace(),      replaceAll(),   concat(),
 *    indexOf(),      lasIndexOf(),   includes(),
 *    slice(),        substring(),    substr(),
 *    toLowerCase(),  toUpperCase(),  split(),
 *    valueOf(),      toString(),
 *    trim(),         trimEnd(),      trimStart(),
 *    padStart(),     padEnd(),
 *    startsWith(),   endsWith(),
 *    charAt(),       charCodeAt(),   length
 *
 *   Todos os metodos de string retornam uma nova string
 * */

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

//Para substituir todas as correspondências, use uma expressão regular com um /g sinalizador (correspondência global)
console.log(umaString.replace(/Um/, "Outro dia")); //Substitui uma palavra/letra por outra

console.log(umaString.replaceAll("o", "??")); //replaceAll nao aceita expressoes regulares
console.log(umaString);

console.log(umaString.length);

console.log(umaString.slice(3, 12));

console.log(umaString.slice(-5)); //Tamanho da string -5, e percorre desse char até o final
console.log(umaString.slice(-5, -1));
//Mesma coisa em substring
console.log(umaString.substring(umaString.length - 5, umaString.length - 1));
console.log(umaString.substring(16, 3)); //aceita o primeiro valor ser maior, mas ele faz a ordem normal indo do 3 até 16-1
console.log(umaString.substr(4, 12)); //(start, length)

console.log(umaString.split(" "));

console.log(umaString.toLowerCase);
console.log(umaString.toUpperCase);

console.log(umaString);

console.log(umaString.includes("o")); //retorna um boolean
console.log(umaString.indexOf("o") > -1); //forma antiga, antes do includes

console.log(umaString.charAt(4));
console.log(umaString.charCodeAt(4)); //retorna o unicode do char
console.log(umaString.length);

let str = "       Era uma vez em um reino...                ";
console.log(str);
console.log(str.trimStart(), "-----");
console.log(str.trimEnd(), "-----");
console.log(str.trim(), "-----");

const stringObj = new String("Meu objeto string");
console.log(stringObj);
console.log(stringObj.valueOf());
console.log(stringObj.toString());

const x = 16;
console.log(typeof x, x);
console.log(x + x);

const y = x.toString();
console.log(typeof y, y);
console.log(y + y);

str = "Era uma...";
console.log(str.padStart(20, "*"));
console.log(str.padEnd(20, "-"));

let tel = "91234-2345"; //9****-**34
let tel2 = "1234-2345"; //1***-**45
function mascararTelefone(numero) {
   let positionHifen = numero.indexOf("-");
   let startNumero = numero.slice(0, positionHifen);
   let endNumero = numero.substring(positionHifen);

   return `${startNumero[0].padEnd(startNumero.length, "*")}-${endNumero
      .slice(-2)
      .padStart(endNumero.length, "*")}`;
}

console.log(mascararTelefone(tel));
console.log(mascararTelefone(tel2));

str = "Um dia";
console.log(str.repeat(2));
console.log(str.repeat(4));

str = "Um dia florido para alegrar os corações.";

//Retorna um boolean
console.log(str.startsWith("dia", 3)); //(valor, apartir do index)
console.log(str.endsWith("corações", str.length - 1)); //(valor, tamanho string)