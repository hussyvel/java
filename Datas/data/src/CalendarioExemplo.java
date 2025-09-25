import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Calendar;

public class CalendarioExemplo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d = Date.from(Instant.parse("2025-07-25T15:42:07Z")); //formato UTC

        System.out.println(sdf.format(d));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR_OF_DAY, -4);
        d = calendar.getTime();

        System.out.println(sdf.format(d));
    }
}
