package poo.aula01.application;

import poo.aula01.entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class ProgAula01 {
    public static void main(String[] args) {
//        Solução sem POO
//        Locale.setDefault(Locale.US);
//        Scanner sc = new Scanner(System.in);
//
//        double xA, xB, xC, yA, yB, yC;
//
//        System.out.println("Enter the measures of triangle x: ");
//
//        xA = sc.nextDouble();
//        xB = sc.nextDouble();
//        xC = sc.nextDouble();
//
//        System.out.println("Enter the measures of triangle y: ");
//        yA = sc.nextDouble();
//        yB = sc.nextDouble();
//        yC = sc.nextDouble();
//
//        double p = (xA + xB + xC) / 2;
//        double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));
//
//        p = (yA + yB + yC) / 2;
//        double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));
//
//        System.out.printf("Triangle X area: %.4f%n", areaX);
//        System.out.printf("Triangle Y area: %.4f%n", areaY);
//
//        if (areaX > areaY) {
//            System.out.println("Larger area: X");
//        } else {
//            System.out.println("Larger area: Y");
//        }
//
//        sc.close();

        // Com POO
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;

        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measures of triangle x: ");

        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Enter the measures of triangle y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double p = (x.a + x.b + x.c) / 2;
        double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));

        p = (y.a + y.b + y.c) / 2;
        double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));

        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else {
            System.out.println("Larger area: Y");
        }

        sc.close();
    }
}
