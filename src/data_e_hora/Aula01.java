package data_e_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aula01 {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now(); // Instaciar uma data
        System.out.println(data);

        LocalDateTime dataTempo = LocalDateTime.now();
        System.out.println(dataTempo); // Com horário junto

        Instant instant = Instant.now();
        System.out.println(instant); // Com horário e fuso

        LocalDate dataParse = LocalDate.parse("2022-02-20"); // Fazer a conversão
        System.out.println(dataParse);

        LocalDateTime dataParse2 = LocalDateTime.parse("2022-02-20T01:30:26");
        System.out.println(dataParse2);

        Instant dataParse3 = Instant.parse("2022-02-20T01:30:26Z");
        System.out.println(dataParse3);

        Instant dateParse4 = Instant.parse("2022-02-20T01:30:26-03:00");
        System.out.println(dateParse4);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Instanciando objeto de formatação
//        LocalDate dataParse5 = LocalDate.parse("20/02/2022"); // Causa uma Exception se não for tratado antes
        LocalDate dataParse5 = LocalDate.parse("20/02/2022", formatter);
        System.out.println(dataParse5);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataParse6 = LocalDateTime.parse("20/02/2022 01:30", formatter2);
        System.out.println(dataParse6);

        LocalDate data7 = LocalDate.of(2022, 1, 1); // Instanciação de um objeto de data pelo método of
        System.out.println(data7);

        LocalDateTime data8 = LocalDateTime.of(2022, 1, 1, 1, 1);
        System.out.println(data8);
    }
}
