import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        PrintService printService = new PrintService();
        PrintServiceGenerics<String> printServiceGenerics = new PrintServiceGenerics<>();

        System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String value = sc.next();
            printServiceGenerics.addValue(value);
        }

        printServiceGenerics.print();
        System.out.println("First: " + printServiceGenerics.first());

        sc.close();
    }
}