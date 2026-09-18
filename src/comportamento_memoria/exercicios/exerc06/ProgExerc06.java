package comportamento_memoria.exercicios.exerc06;

import java.util.Locale;
import java.util.Scanner;

/*
Faça um programa que leia N números reais e armazene-os em um vetor. Em seguida, mostrar na tela
o maior número do vetor (supor não haver empates). Mostrar também a posição do maior elemento,
considerando a primeira posição como 0 (zero).
*/
public class ProgExerc06 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar?");
        int n = sc.nextInt();

        double[] vect = new double[n];

        double maiorValor = vect[0];
        int posicaoMaiorValor = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            if (vect[i] > maiorValor) {
                maiorValor = vect[i];
                posicaoMaiorValor = i;
            }
        }

        System.out.printf("MAIOR VALOR = %.2f\n", maiorValor);
        System.out.printf("POSIÇÃO DO MAIOR VALOR = %d", posicaoMaiorValor);

        sc.close();
    }
}
