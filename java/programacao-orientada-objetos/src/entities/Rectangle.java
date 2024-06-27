package entities;

public class Rectangle {

    public double largura;
    public double altura;

    public Rectangle() {
    }

    public double area() {
        return altura * largura;
    }

    public double perimetro() {
        return (largura + altura) * 2;
    }

    public double diagonal() {
        return Math.sqrt(largura * largura + altura * altura);
    }
}
