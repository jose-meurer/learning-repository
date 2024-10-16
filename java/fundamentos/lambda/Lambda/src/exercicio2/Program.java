package exercicio2;

import exercicio2.entities.Worker;
import exercicio2.services.WorkerService;

import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Worker> list = new ArrayList<>();

        File path = new File("in.txt");
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

            String line = bf.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                Double salary = Double.parseDouble(fields[2]);

                list.add(new Worker(name, email, salary));

                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Double salary = 2000.0;
        System.out.println("Enter salary : " + salary);
        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ": ");

        WorkerService<Worker> service = new WorkerService<>();
        List<Worker> listFiltered = service.filterBySalary(list, x -> x.getSalary() > 2000.0);
        List<String> emails = service.workerToEmail(listFiltered);
        emails.forEach(System.out::println);

        char nameStartsWith = 'A';
        double sum = service.sumSalary(list, x -> x.getName().charAt(0) == nameStartsWith);
        System.out.print("Sum of salary of people whose name starts with '" + nameStartsWith + "' " + String.format("%.2f", sum));

    }

}
