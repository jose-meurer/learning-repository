package exercicio;

import exercicio.entities.Employee;
import exercicio.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Employee #%d data: %n", i);
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double charge = sc.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, charge));
            } else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS: ");
        employees.forEach(employee -> System.out.println(employee.getName() + " - $ " + employee.payment()));

        sc.close();
    }
}
