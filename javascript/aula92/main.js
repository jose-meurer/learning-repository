const nome = "Luiz";
const idade = 18;
const obj = { nome, idade };
const novoObj = { ...obj };
console.log(novoObj);

// comandos para estudar
// npm init -y
// npm install --save-dev @babel/cli @babel/preset-env @babel/core
// npx babel main.js -o bundle.js --presets=@babel/env
