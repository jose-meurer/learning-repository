let varA = 'A';
let varB = 'B';
let varC = 'C';

//A = B | B = C | C = A

//Jeito antigo
let temp = varA;
varA = varB;
varB = varC;
varC = temp;

console.log(varA, varB, varC);

//Jeito mais moderno
[varA, varB, varC] = [varB, varC, varA];
console.log(varA, varB, varC);
