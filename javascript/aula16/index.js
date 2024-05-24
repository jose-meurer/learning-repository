const alunos = ['José', 'Maria', 'Miguel'];

console.log(alunos)
console.log(alunos[0]); //José
console.log(alunos[1]); //Maria

alunos[1] = 'Luiza';
alunos[3] = 'Nicole';
console.log(alunos);
console.log(alunos.length);

alunos[alunos.length] = 'Cleber';
alunos[alunos.length] = 'Lucas';
alunos[alunos.length] = 'Joaquim';
console.log(alunos);

alunos.push('Valentina'); //Adiciona ao fim
console.log(alunos);

alunos.unshift('Fábio'); //Adiciona ao começo
console.log(alunos);

let alunoRemovido = alunos.pop(); //Remove o ultimo elemento
console.log(alunos, alunoRemovido);

alunoRemovido = alunos.shift(); //Remove o primeiro elemento
console.log(alunos, alunoRemovido);

delete alunos[2]; //Remove um elemento, sem alterar o indice dos outros, <1 empty item>
console.log(alunos);

console.log(alunos.slice(-4, -1)); //Semelhante ao string.slice()

console.log(typeof alunos);
console.log(alunos instanceof Array); //Semelhante ao Java

// Os primitivos todos são imutáveis, array e obj sao mutaveis, pois podemos alterar o valor interno, sem alterar a variavel