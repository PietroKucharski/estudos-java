package data_e_hora.exercicios.exerc02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProgExerc02_2 {
    public static void main(String[] args) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d1 = LocalDate.parse("20/07/2022", dtf1);
        LocalDateTime d2 = LocalDateTime.parse("20/07/2022 01:30", dtf2);

        System.out.println(d1);
        System.out.println(d2);

        // A saída aparece no formato ISO pois é apenas utilizado para interpretar a data e não para definir como o objeto será exibido
        // MM significa mês enquanto mm significa minutos. HH utiliza o formato de 24h enquanto hh utiliza o formato de 12h
    }
}
