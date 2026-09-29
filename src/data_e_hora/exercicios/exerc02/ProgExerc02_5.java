package data_e_hora.exercicios.exerc02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProgExerc02_5 {
    public static void main(String[] args) {
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDate.of(2022, 7, 20).format(f1));

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(LocalDateTime.of(2022, 7, 20, 15, 30).format(f2));

        LocalDate d = LocalDate.parse("20/07/2022", f1);
    }
}
