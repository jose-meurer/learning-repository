package entities;

public class Student {

    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;

    public double notaFinal() {
        return nota1 + nota2 + nota3;
    }

    public double notaFaltante() {
        return 60 - notaFinal();
    }

    public void alunoFoiAprovado() {
        double temp = notaFinal();

        if (temp < 60.0) {
            System.out.println("Reprovado");
            System.out.println("Faltou " + String.format("%.2f", notaFaltante()) + " pontos.");
        } else {
            System.out.println("APROVADO");
        }
    }
}
