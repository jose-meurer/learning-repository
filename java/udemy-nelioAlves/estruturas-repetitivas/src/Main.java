import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exemplo 1
        int x = 4;
        int y = 0;
        int j = 0;

        while (j < x) {
            j++;
            y += j;
            System.out.print(j);
            System.out.println(y);
        }

        //Exemplo 2
        for (int i = 0; i <= 10; i++) {
            System.out.println("Valor de i: " + i);
        }

        for (int i = 10; i >= 0; i--) {
            System.out.println("Valor de i: " + i);
        }

        int h = 8;
        int o = 3;
        for (int i = 0; o < h; i++) {
            h -= 2;
            o += 1;
            System.out.println(i);
        }

        //Exemplo 3

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        char resp;
        do {
            System.out.print("Digite a tempertura em Celsius: ");
            double tempCelsius = sc.nextDouble();
            double tempFahrenheit = tempCelsius * 9.0 / 5.0 + 32.0;
            System.out.println("Equivalente em Fagrenheit: " + String.format("%.2f", tempFahrenheit));
            System.out.print("Deseja repetir: ");
            resp = sc.next().charAt(0);
        } while (resp != 'N' && resp != 'n');
    }
}