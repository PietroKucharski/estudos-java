package comportamento_memoria.exercicios.exerc03;

/*
Faça um programa que leia N números reais e armazene-os em um vetor.
Em seguida: - Imprimir todos os elementos do vetor - Mostrar na tela a soma e a média dos elementos do vetor
*/

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");
        int n = sc.nextInt();
        double[] vect = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextDouble();
        }

        System.out.print("VALORES = ");
        for (int i = 0; i < vect.length; i++) {
            System.out.printf("%.2f ", vect[i]);
        }

        double soma = 0.0;
        for (int i = 0; i < vect.length; i++) {
            soma += vect[i];
        }

        System.out.println("\nSOMA = " + soma);

        double media = soma / n;
        System.out.printf("MEDIA = %.2f%n", media);

        sc.close();
    }
}
