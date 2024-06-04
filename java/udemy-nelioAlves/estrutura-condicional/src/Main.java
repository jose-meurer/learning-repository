import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exemplo 1
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //int minutos = sc.nextInt();
        int minutos = 135;

        double conta = 50.0;
        if (minutos > 100) {
            conta += (minutos - 100) * 2.0;
        }

        System.out.printf("Valor da conta = R$ %.2f%n", conta);

        //Exemplo 2
        int x = sc.nextInt();
        String dia = switch (x) {
            case 1 -> "domingo";
            case 2 -> "segunda";
            case 3 -> "terca";
            case 4 -> "quarta";
            case 5 -> "quinta";
            case 6 -> "sexta";
            case 7 -> "sabado";
            default -> "valor invalido";
        };
        System.out.println("Dia da semana: " + dia);

        //Exemplo 3

        double preco = 45.0;
        double desconto = (preco < 25.0) ? preco * 0.1 : preco * 0.05;
        double valorTotal = preco - desconto;

        System.out.printf("Valor total da compra foi de R$ %.2f%n", valorTotal);

        sc.close();
    }
}
