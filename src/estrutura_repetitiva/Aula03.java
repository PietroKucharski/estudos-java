package estrutura_repetitiva;

import java.util.Locale;
import java.util.Scanner;

public class Aula03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Forma inadequada
//        System.out.print("Digite a temperatura em Celsius: ");
//        double C = sc.nextDouble();
//        double F = 9.0 * C / 5.0 + 32.0;
//        System.out.printf("Equivalente a Fahrenheit: %.1f%n", F);
//        char resp = sc.next().charAt(0);
//
//        while(resp != 'n') {
//            System.out.print("Digite a temperatura em Celsius: ");
//            C = sc.nextDouble();
//            F = 9.0 * C / 5.0 + 32.0;
//            System.out.printf("Equivalente a Fahrenheit: %.1f%n", F);
//            resp = sc.next().charAt(0);
//        }

        // Forma mais adequada
        char resp = sc.next().charAt(0);

        do {
            System.out.print("Digite a temperatura em Celsius: ");
            double C = sc.nextDouble();
            double F = 9.0 * C / 5.0 + 32.0;
            System.out.printf("Equivalente a Fahrenheit: %.1f%n", F);
            resp = sc.next().charAt(0);
        } while (resp != 'n');

        sc.close();
    }
}
