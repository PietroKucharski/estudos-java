package data_e_hora.exercicios.exerc02;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ProgExerc02_3 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.parse("2022-07-20");
        LocalDateTime dt = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant i = Instant.parse("2022-07-20T01:30:26Z");

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH'h'mm").withZone(ZoneId.of("UTC"));

        System.out.println(d.format(dtf1));
        System.out.println(dt.format(dtf2));
        System.out.println(dtf3.format(i));

        // Só é possível utilizar o DateTimeFormatter passando o fuso, e as variáveis de formatação instanciadas não passam o fuso
        // Então se não utilizar o zoneId não é possível fazer a formtação
    }
}
