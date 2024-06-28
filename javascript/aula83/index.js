//Metodos estaticos
class Calculadora{

    constructor(a, b) { //metodos estaticos nao tem acesso as propriedades da classe
        this.a = a;
        this.b = b;
    }

    static soma(a, b) {
        return Number(a) + Number(b);
    }

    static subtracao(a, b) {
        return Number(a) - Number(b);
    }

    static divisao(a, b) {
        return Number(a) / Number(b);
    }

    static multiplicacao(a, b) {
        return Number(a) * Number(b);
    }

    static restoDivisao(a, b) {
        return Number(a) % Number(b);
    }
}

const c = new Calculadora(4, 5);
// console.log(c.soma()); //c.soma is not a function
console.log(Calculadora.subtracao()); // NaN

console.log(Calculadora.soma(5, 5));
