package data_e_hora.exercicios.exerc02;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProgExerc02 {
    public static void main(String[] args) {
        // data de hoje
        LocalDate d1 =  LocalDate.now();

        // data-hora de agora
        LocalDateTime d2 =  LocalDateTime.now();

        // Instante de agora
        Instant d3 =  Instant.now();

        // LocalDate a partir do texto ISO "2022-07-20"
        LocalDate d4 =  LocalDate.parse("2022-07-20");

        // LocalDateTime a partir do texto ISO "2022-07-20T01:30:26"
        LocalDateTime d5 =  LocalDateTime.parse("2022-07-20T01:30:26");

        // Instant a partir de "2022-07-20T01:30:26Z"
        Instant  d6 =  Instant.parse("2022-07-20T01:30:26Z");

        // Instant a partir de "2022-07-20T01:30:26-03:00"
        Instant d7 =  Instant.parse("2022-07-20T01:30:26-03:00");

        // LocalDate a partir de dia, mês e ano: 20/07/2022.
        LocalDate d8 = LocalDate.of(2022, 7, 20);

        // LocalDateTime a partir de dia, mês, ano, hora e minuto: 20/07/2022 01:30.
        LocalDateTime d9 =  LocalDateTime.of(2022, 7, 20, 1, 30);

        System.out.println(d7);
    }
}
