import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculosComDataHora {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2024-07-21");
        LocalDateTime d05 = LocalDateTime.parse("2024-07-20T01:30:35");
        Instant d06 = Instant.parse("2024-07-20T01:30:35Z");

        LocalDate pastWeekLocalDate = d04.minusDays(7);//menos 7 dias
        LocalDate nextWeekLocalDate = d04.plusDays(7);//mais 7 dias

        System.out.println("Menos " + pastWeekLocalDate + " dias");
        System.out.println("Mais " + nextWeekLocalDate + " dias");

        LocalDateTime pastWeeLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeeLocalDateTime = d05.plusDays(7);

        System.out.println(pastWeeLocalDateTime);
        System.out.println(nextWeeLocalDateTime);

        Instant pastWeeLocalInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeeLocalInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println(pastWeeLocalInstant);
        System.out.println(nextWeeLocalInstant);

        Duration duration = Duration.between(pastWeekLocalDate.atTime(0, 0), d04.atTime(0, 0));
        //outra forma de fazer
        Duration duration1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        Duration duration2 = Duration.between(pastWeeLocalDateTime, d05);
        Duration duration3 = Duration.between(pastWeeLocalInstant, d06);
        Duration duration4 = Duration.between(d06, pastWeeLocalInstant);

        System.out.println(duration.toDays());
        System.out.println(duration1.toDays());
        System.out.println(duration2.toDays());
        System.out.println(duration3.toDays());
        System.out.println(duration4.toDays());
    }
}
