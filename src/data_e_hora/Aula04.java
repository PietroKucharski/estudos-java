package data_e_hora;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aula04 {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.parse("2022-02-02");
        LocalDateTime data2 = LocalDateTime.parse("2022-02-02T01:30:26");
        Instant data3 = Instant.parse("2022-02-02T01:30:26Z");

        LocalDate pastWeekLocalDate = data1.minusDays(7);
        LocalDate nextWeekLocalDate = data1.plusDays(7);

        System.out.println(pastWeekLocalDate);
        System.out.println(nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = data2.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = data2.plusDays(7);

        System.out.println(pastWeekLocalDateTime);
        System.out.println(nextWeekLocalDateTime);

        Instant pastWeekInstant = data3.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = data3.plus(7, ChronoUnit.DAYS);

        System.out.println(pastWeekInstant);
        System.out.println(nextWeekInstant);

//        Duration t1 = Duration.between(pastWeekLocalDate, data1); Não tem como fazer com LocalDate, precisa ser LocalDateTime
//        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0, 0), data1); Fazendo a conversão para colocar horas e minutos
        Duration t1 = Duration.between(pastWeekLocalDateTime, data2);
        Duration t2 = Duration.between(pastWeekLocalDateTime, data2);
        Duration t3 = Duration.between(pastWeekInstant, data3);

        System.out.println(t1.toDays());
        System.out.println(t2.toDays());
        System.out.println(t3.toDays());
    }
}
