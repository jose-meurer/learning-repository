import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TipoDate {
    public static void main(String[] args) throws ParseException {
        //Date é a clase antiga do Instant
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        SimpleDateFormat fmt3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        fmt3.setTimeZone(TimeZone.getTimeZone("UTC"));

        //Passar uma data usando um formato
        Date date1 = fmt1.parse("25/03/2024");
        Date date2 = fmt2.parse("25/03/2024 25:42:07");

        System.out.println("date1: " + fmt1.format(date1));
        System.out.println("date2: " + fmt2.format(date2));

        //Data atual
        Date now = new Date();
        Date now2 = new Date(System.currentTimeMillis());//Passando os Milissegundos

        Date unix = new Date(0L);
        Date unix2 = new Date(1000L * 60L * 60L * 5L);

        System.out.println("Now: " + fmt2.format(now));
        System.out.println("NowUTC: " + fmt3.format(now2));
        System.out.println("Unix: " + fmt2.format(unix));
        System.out.println("UnixUTC: " + fmt3.format(unix2));
    }
}
