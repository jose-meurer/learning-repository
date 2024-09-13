import java.time.*;
import java.time.temporal.ChronoField;

public class ConverterHoraGlobalParaLocal {
    public static void main(String[] args) {

        //Lista de fusos que podem ser usados
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        LocalDate localDate = LocalDate.parse("2024-10-20");
        LocalDateTime localDateTime = LocalDateTime.parse("2024-10-20T01:30:00");
        Instant instant = Instant.parse("2024-10-20T01:30:00Z");

        //Hora global para hora local
        LocalDate r1 = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(instant, ZoneId.of("Europe/Monaco"));
        LocalDateTime r3 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Monaco"));

        System.out.printf("r1: %s%n" +
                "r2: %s %n" +
                "r3: %s %n" +
                "r4: %s %n", r1, r2, r3, r4);

        System.out.println("LocalDate dia: " + localDate.getDayOfMonth());
        System.out.println("LocalDate Mês(nome): " + localDate.getMonth());
        System.out.println("LocalDate Mês(número): " + localDate.getMonthValue());

        System.out.println("LocalDateTime Horas: " + localDateTime.getHour());
        System.out.println("LocalDateTime Minutos: " + localDateTime.getMinute());
        System.out.println("Instant Hora Atual: " + Instant.now());
    }
}
