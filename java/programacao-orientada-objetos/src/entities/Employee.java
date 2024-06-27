package entities;

public class Employee {

    public String nome;
    public double salarioBruto;
    public double imposto;


    public double salarioLiquido() {
        return salarioBruto - imposto;
    }

    public void aumentoSalario(double porcetagem) {
        salarioBruto += salarioBruto * (porcetagem / 100);
    }


    @Override
    public String toString() {
        return nome + ", $ " + String.format("%.2f", salarioLiquido());
    }
}
