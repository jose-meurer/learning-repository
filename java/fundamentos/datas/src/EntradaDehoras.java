import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntradaDehoras {
    public static void main(String[] args) {

        System.out.println("Hora atual:");
        LocalDate date01 = LocalDate.now(); //Hora local
        LocalDateTime date02 = LocalDateTime.now(); //Hora local com hora
        Instant date03 = Instant.now(); //Hora global

        System.out.printf("LocalDate: %s%n" +
                "LocalDateTime: %s%n" +
                "Instant: %s%n", date01, date02, date03);

        System.out.println();
        System.out.println("Uma hora no tempo:");
        LocalDate date04 = LocalDate.parse("2022-07-20");
        LocalDateTime date05 = LocalDateTime.parse("2022-07-20T05:30:44");
        Instant date06 = Instant.parse("2022-07-20T05:30:44Z");
        Instant date07 = Instant.parse("2022-07-20T05:30:44-03:00");

        System.out.printf("LocalDate: %s%n" +
                "LocalDateTime: %s%n" +
                "Instant: %s%n" +
                "Instant com fuso: %s%n", date04, date05, date06, date07);

        System.out.println();
        System.out.println("Usando mascara de formatacao:");

        //Mascara
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter formatacao01 = DateTimeFormatter.ofPattern("dd MM yyyy");
        DateTimeFormatter formatacao02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDate date08 = LocalDate.parse("23 07 2024", formatacao01);
        LocalDateTime date09 = LocalDateTime.parse("25/10/2024 04:50:33", formatacao02);
        LocalDate date10 = LocalDate.parse("20241025", DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("LocalDate com mascara: " + date08);
        System.out.println("LocalDateTime com mascara: " + date09);
        System.out.println("LocalDate com mascara/constante: " + date10);

        LocalDate date11 = LocalDate.of(2024, 9, 20);
        LocalDateTime date12 = LocalDateTime.of(2024, 9, 20, 5, 30);

        System.out.println("LocalDate: " + date11);
        System.out.println("LocalDateTime: " + date12);

    }
}
