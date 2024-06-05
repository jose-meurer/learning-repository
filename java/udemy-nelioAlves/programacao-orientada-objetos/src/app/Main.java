package app;

import entities.Employee;
import entities.Rectangle;
import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        exercicio1(sc);

//        exercicio2(sc);

        exercicio3(sc);

        sc.close();
    }

    public static void exercicio1(Scanner sc) {

        Rectangle rectangle = new Rectangle();
        System.out.println("Entre com altura e largura do triangulo: ");
        rectangle.altura = sc.nextDouble();
        rectangle.largura = sc.nextDouble();

        System.out.printf("AREA = %.2f%n", rectangle.area());
        System.out.printf("PERIMETRO = %.2f%n", rectangle.perimetro());
        System.out.printf("DIAGONAL = %.2f%n", rectangle.diagonal());

    }

    public static void exercicio2(Scanner sc) {

        Employee emp = new Employee();
        System.out.print("Nome: ");
        emp.nome = sc.nextLine();
        System.out.print("Salario Bruto: ");
        emp.salarioBruto = sc.nextDouble();
        System.out.print("Imposto: ");
        emp.imposto = sc.nextDouble();

        System.out.println("Employee: " + emp.toString());

        System.out.print("Qual porcentagem deseja incrementar no salario: ");
        emp.aumentoSalario(sc.nextDouble());

        System.out.println("Update data: " + emp.toString());
    }

    public static void exercicio3(Scanner sc) {

        Student st = new Student();
        st.nome =   sc.nextLine();
        st.nota1 = sc.nextDouble();
        st.nota2 = sc.nextDouble();
        st.nota3 = sc.nextDouble();

        System.out.println("Nota final: " + st.notaFinal());
        st.alunoFoiAprovado();
    }
}
