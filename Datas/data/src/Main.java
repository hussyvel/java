import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.now();
        LocalTime d02 = LocalTime.now();
        Instant d03 = Instant.now();

        DateTimeFormatter dmf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dmf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d6 = LocalDate.parse("2022-07-20");
        LocalDateTime d7 = LocalDateTime.parse("2022-07-22T20:45");
        Instant d8 = Instant.parse("2025-05-05T01:30:26Z");


        LocalDate dt4 = LocalDate.parse("05/05/2025", dmf);
        LocalDateTime dt5 = LocalDateTime.parse("05/05/2025 01:59", dmf2);

        LocalDate d10 = LocalDate.of(2025,8,10);
        LocalDateTime d11 = LocalDateTime.of(2025, 5, 05, 22,35);

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);
        System.out.println(dt4);
        System.out.println(dt5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);
        System.out.println(d10);
        System.out.println(d11);

    }
}