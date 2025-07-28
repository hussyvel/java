
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pratica {
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.parse("2025-06-04");
        LocalDateTime d02 = LocalDateTime.parse("2025-06-04T22:51");

        DateTimeFormatter form1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter form2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(d01);
        System.out.println(d02.format(form1));
        System.out.println(d02.format(form2));
    }
}