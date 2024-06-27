// Classes
class Pessoa{
    constructor(nome, sobrenome, idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    falar() { //É criado automaticamente no prototype
        return `${this.nome} está falando.`;
    }
}

const p1 = new Pessoa('José', 'Meurer', 26);
console.log(p1);
console.log(p1.falar());

// Classe é uma maneira mais limpa, sem precisar setar prototype na mão
function Pessoa2(nome, sobrenome, idade) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
}

Pessoa2.prototype.falar = function() {
    return `${this.nome} está falando.`;
}

const p2 = new Pessoa2('Maria', 'Brown', 30);
console.log(p2);
console.log(p2.falar());
