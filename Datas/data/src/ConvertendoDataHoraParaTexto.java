import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class ConvertendoDataHoraParaTexto {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2025-05-10");
        LocalDateTime d05 = LocalDateTime.parse("2025-05-05T22:40:50");
        Instant d06 = Instant.parse("2025-05-05T01:30:35Z");

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter formato4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter formato5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("d04 " + d04.format(formato1));
        System.out.println("d04 " + formato1.format(d04));

        System.out.println("Formatando a data e hora " + d05.format(formato1));
        System.out.println("Formatando a data e hora " + d05.format(formato2));
        System.out.println("Formatando a data e hora " + d05.format(formato4));
        System.out.println("Formatando o Instant " + formato3.format(d06));
        System.out.println("Formatando o Instant " + formato5.format(d06));
        System.out.println("Formatando o Instant " + d06.toString());

    }
}
