package data_e_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Aula03 {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.parse("2022-02-02");
        LocalDateTime data2 = LocalDateTime.parse("2022-02-02T01:30:26");
        Instant data3 = Instant.parse("2022-02-02T01:30:26Z");

        LocalDate r1 = LocalDate.ofInstant(data3, ZoneId.systemDefault());
        System.out.println(r1);

        LocalDate r2 = LocalDate.ofInstant(data3, ZoneId.of("Portugal"));
        System.out.println(r2);

        LocalDateTime r3 = LocalDateTime.ofInstant(data3, ZoneId.systemDefault());
        System.out.println(r3);

        LocalDateTime r4 = LocalDateTime.ofInstant(data3, ZoneId.of("Portugal"));
        System.out.println(r4);


        System.out.println(data1.getDayOfMonth());
        System.out.println(data1.getMonthValue());
        System.out.println(data1.getYear());

        System.out.println(data2.getHour());
        System.out.println(data2.getMinute());

    }
}
