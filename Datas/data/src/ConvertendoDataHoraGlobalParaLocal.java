import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertendoDataHoraGlobalParaLocal {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2025-06-01");
        LocalDateTime d05 = LocalDateTime.parse("2025-06-01T12:00:35");
        Instant inst = Instant.parse("2025-06-01T01:15:45Z");



        System.out.println(d04);
        System.out.println(d05);
        System.out.println(inst);
    }
}
