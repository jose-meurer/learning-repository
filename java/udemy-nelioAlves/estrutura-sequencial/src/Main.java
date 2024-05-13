import java.sql.SQLOutput;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        //Exemplo 1 de estrutura sequencial
        String nome = "José";
        int idade = 26;
        double altura = 2.00;

        System.out.printf("Meu nome é %s, tenho %d anos e %.2f de altura%n", nome, idade, altura);

        //Exemplo 2

        double x = 10.67438;

        System.out.printf("%.4f%n", x);

        Locale.setDefault(Locale.US);

        System.out.printf("%.4f%n", x);

        System.out.printf("RESULTADO = %.3f%n", x);

        System.out.println();
        exercicio_1();
    }


    static void exercicio_1() {
        String product1 = "Computer";
        String product2 = "Office desk";

        int age = 30;
        int code = 5290;
        char gender = 'F';

        double price1 = 2100.0;
        double price2 = 650.50;
        double measure = 53.234567;

        System.out.printf("Products:%n");
        System.out.printf("%s, which price is $ %.2f%n", product1, price1);
        System.out.printf("%s, which price is $ %.2f%n", product2, price2);
        System.out.println();
        System.out.printf("Record: %d years old, code %d and gender: %C%n", age, code, gender);
        System.out.println();
        System.out.printf("Measue with eight decimal places: %.8f%n", measure);
        System.out.printf("Rouded (three decimal places): %.3f", measure);
        System.out.printf("US decimal point: %.3f", measure);
    }
}