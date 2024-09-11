import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SaidaDeHoras {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.parse("2024-07-20");
        LocalDateTime d02 = LocalDateTime.parse("2024-07-20T05:30:45");
        Instant d03 = Instant.parse("2024-07-20T05:30:45Z");

        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //Instant pode ser formatado apenas se tiver o timezone
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("date01: " + d01.format(fmt1)); //Posso usar o localDate e chamar o formatter
        System.out.println("date01: " + fmt1.format(d01)); //Ou usar o formatter e chamar o localDate
        System.out.println("date01: " + d01.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        System.out.println();
        System.out.println("date02: " + d02.format(fmt1));
        System.out.println("date02: " + d02.format(fmt2));
        System.out.println("date02: " + d02.format(fmt4));

        System.out.println();
        System.out.println("instant03: " + fmt3.format(d03)); //Instant nao tem o .format, chamar usando apenas o formatter
        System.out.println("instant03: " + fmt5.format(d03));
        System.out.println("instant03: " + d03.toString());





    }
}
