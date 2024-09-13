import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TipoCalendar {
    public static void main(String[] args) {
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date = Date.from(Instant.parse("2024-06-25T15:42:07Z"));
        System.out.println(fmt1.format(date));

        //Adicionar horas com calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 5);
        date = cal.getTime();

        System.out.println(fmt1.format(date));

        //Retornar unidade de tempo com calendar
        int minutes = cal.get(Calendar.MINUTE);
        System.out.println("Minutes: " + minutes);

        int month = cal.get(Calendar.MONTH) + 1; //No calendar, os meses começa em 0
        System.out.println("Month: " + month);
    }
}
