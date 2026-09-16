package introd_poo.aula05.application;

import introd_poo.aula05.entities.Calculator;

import java.util.Locale;
import java.util.Scanner;

public class ProgAula05 {
    // Constante que não pode mudar
//    public static final double PI = 3.14159;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter radius: ");
//        double radius = sc.nextDouble();
//
//        double c = circumference(radius);
//        double v = volume(radius);
//
//        System.out.printf("Circumference: %.2f%n", c);
//        System.out.printf("Volume: %.2f%n", v);
//        System.out.printf("PI = %.2f%n", PI);

        // Métodos e variáveis/constantes não estáticas
        Calculator calc = new Calculator();
        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();

        double c = calc.circumference(radius);
        double v = calc.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI = %.2f%n", calc.PI);

        sc.close();
    }

//    public static double circumference(double radius) {
//        return 2 * PI * radius;
//    }
//
//    public static double volume(double radius) {
//        return 4.0 * PI * radius * radius * radius / 3.0;
//    }
}
