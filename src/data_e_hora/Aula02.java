package data_e_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Aula02 {
    public static void main(String[] args) {
        LocalDate data1 = LocalDate.parse("2022-02-02");
        LocalDateTime data2 = LocalDateTime.parse("2022-02-02T01:30:26");
        Instant data3 = Instant.parse("2022-02-02T01:30:26Z");

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        System.out.println(data1.format(formatter1));
        System.out.println(formatter1.format(data1));
        System.out.println(data1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println(data2.format(formatter2));

        System.out.println(formatter3.format(data3));
    }
}
