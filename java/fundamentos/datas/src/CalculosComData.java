import java.sql.SQLOutput;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class CalculosComData {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.parse("2024-10-20");
        LocalDateTime localDateTime = LocalDateTime.parse("2024-10-20T01:30:00");
        Instant instant = Instant.parse("2024-10-20T01:30:00Z");

        //Datas sao imutaveis
        LocalDate semanaPassadaLocalDate = localDate.minusWeeks(1);
        LocalDate proximaSemanaLocalDate = localDate.plusDays(7);

        System.out.println("LocalDate: ");
        System.out.println("Semana passada: " + semanaPassadaLocalDate);
        System.out.println("Proxima semana: " + proximaSemanaLocalDate);

        Instant semanaPassadaInstant = instant.minus(7, ChronoUnit.DAYS);
        Instant proximaSemanaInstant = instant.plus(7, ChronoUnit.DAYS);

        System.out.println();
        System.out.println("Instant: ");
        System.out.println("Semana passada: " + semanaPassadaInstant);
        System.out.println("Proxima semana: " + proximaSemanaInstant);

        //Duration
        Duration t1 = Duration.between(semanaPassadaInstant, proximaSemanaInstant);
        Duration t2 = Duration.between(semanaPassadaLocalDate.atTime(0, 0), proximaSemanaLocalDate.atStartOfDay());
        Duration t3 = Duration.between(proximaSemanaInstant, semanaPassadaInstant);

        System.out.println();
        System.out.println("Duration: ");
        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 Horas = " + t3.toHours());

        //Hora Local para global
        System.out.println(localDateTime.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());

        Instant inst = localDateTime.toInstant(ZoneOffset.of("-3"));
        System.out.println(inst);
    }
}
