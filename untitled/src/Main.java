import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2020-04-04");
        LocalDateTime d05 = LocalDateTime.parse("2020-05-05T01:30:26");
        Instant d06 = Instant.parse("2020-06-06T01:30:26Z");



        /*for (String s : ZoneId.getAvailableZoneIds()) {
            System.out.println(s);
        }
        */
        LocalDate d07 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate d08 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime d09 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime d10 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));



        for (String zonas : ZoneId.getAvailableZoneIds()) {
            System.out.println(zonas);
        }

        System.out.println("d07: " + d07);
        System.out.println("d08: " + d08);
        System.out.println("d08: " + d09);
        System.out.println("d08: " + d10);

        System.out.println("d05: " + d05.getDayOfMonth());
        System.out.println("d05: " + d05.getMonth());
        System.out.println("d05: " + d05.getYear());

        System.out.println("d05: " + d05.getHour());


    }
}