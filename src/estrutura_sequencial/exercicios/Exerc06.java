package estrutura_sequencial.exercicios;

/*
Fazer um programa que leia três valores com ponto flutuante de dupla precisão: A, B e C. Em seguida, calcule e
mostre:
a) a área do triângulo retângulo que tem A por base e C por altura.
b) a área do círculo de raio C. (pi = 3.14159)
c) a área do trapézio que tem A e B por bases e C por altura.
d) a área do quadrado que tem lado B.
e) a área do retângulo que tem lados A e B.
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc06 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double A, B, C;
        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();

        // a) a área do triângulo retângulo que tem A por base e C por altura.
        double areaTrianguloRetangulo = (A * C) / 2;

        // b) a área do círculo de raio C. (pi = 3.14159)
        double PI = 3.14159;
        double areaCirculoRaio = PI * Math.pow(C, 2);

        // c) a área do trapézio que tem A e B por bases e C por altura.
        double areaTrapezio = (A + B) * C / 2;

        // d) a área do quadrado que tem lado B.
        double areaQuadrado = Math.pow(B, 2);

        // e) a área do retângulo que tem lados A e B.
        double areaRetangulo = A * B;

        System.out.printf("TRIANGULO %.3f%n", areaTrianguloRetangulo);
        System.out.printf("CIRCULO %.3f%n", areaCirculoRaio);
        System.out.printf("TRAPEZIO %.3f%n", areaTrapezio);
        System.out.printf("QUADRADO %.3f%n", areaQuadrado);
        System.out.printf("RETANGULO %.3f%n", areaRetangulo);
    }
}
