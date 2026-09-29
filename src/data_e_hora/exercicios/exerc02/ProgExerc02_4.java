package data_e_hora.exercicios.exerc02;

import java.time.LocalDateTime;

public class ProgExerc02_4 {
    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.parse("2022-07-20T01:30:26");

        System.out.printf("Dia: %d%n", data.getDayOfMonth());
        System.out.printf("Mes: %d%n", data.getMonthValue());
        System.out.printf("Ano: %d%n", data.getYear());
        System.out.printf("Hora: %d%n", data.getHour());
        System.out.printf("Minuto: %d%n", data.getMinute());
        System.out.printf("Dia da semana: %s%n", data.getDayOfWeek());
    }
}
