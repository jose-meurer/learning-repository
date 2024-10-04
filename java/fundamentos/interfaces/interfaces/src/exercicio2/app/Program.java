package exercicio2.app;

import exercicio2.entities.Contract;
import exercicio2.entities.Installment;
import exercicio2.services.ContractService;
import exercicio2.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter contract data: ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Date (dd/MM/yyyy): ");
            LocalDate localDate = LocalDate.parse(sc.next(), dateFormatter);
            System.out.print("Contract value: ");
            double value = sc.nextDouble();

            Contract contract = new Contract(number, localDate, value);

            System.out.print("Enter of installments: ");
            int installments = sc.nextInt();

            ContractService contractService = new ContractService(new PaypalService());
            contractService.processContract(contract, installments);

            System.out.println();
            System.out.println("Installments: ");
            for (Installment installment : contract.getInstallments()) {
                System.out.println(installment.toString());
            }

        } catch (Exception e) {
            System.out.println("unexpected error");
        }
    }
}
