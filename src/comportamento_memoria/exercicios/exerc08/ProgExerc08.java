package comportamento_memoria.exercicios.exerc08;

import java.util.Locale;
import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro N e depois um vetor de N números reais. Em seguida,
mostrar na tela a média aritmética de todos elementos com três casas decimais. Depois mostrar todos
os elementos do vetor que estejam abaixo da média, com uma casa decimal cada.
*/
public class ProgExerc08 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();
        double[] vect = new double[n];

        double somaValores = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextDouble();
            somaValores += vect[i];
        }

        double media =  somaValores / n;

        System.out.printf("MEDIA DO VETOR = %.3f%n", media);

        System.out.println("ELEMENTOS ABAIXO DA MÉDIA:");
        for (int i = 0; i < n; i++) {
            if (vect[i] < media) {
                System.out.println(vect[i]);
            }
        }
        sc.close();
    }
}
