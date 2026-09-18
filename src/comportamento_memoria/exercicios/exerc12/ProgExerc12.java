package comportamento_memoria.exercicios.exerc12;

/*
Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas. Fazer um programa
que calcule e escreva a maior e a menor altura do grupo, a média de altura das mulheres, e o número
de homens.
*/

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc12 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serão digitadas? ");
        int qtdPessoas = sc.nextInt();

        double[] altura = new double[qtdPessoas];
        char[] genero = new char[qtdPessoas];

        double somaDasAlturas = 0;
        int qtdHomens = 0;

        for (int i = 0; i < qtdPessoas; i++) {
            System.out.printf("Altura da %dª pessoa: ", i + 1);
            altura[i] = sc.nextDouble();

            System.out.printf("Genero da %dª pessoa: ", i + 1);
            genero[i] = sc.next().charAt(0);
        }

        double maiorAltura = altura[0];
        double menorAltura = altura[0];

        for (int i = 0; i < altura.length; i++) {
            if (altura[i] < menorAltura) {
                menorAltura = altura[i];
            }

            if (altura[i] > maiorAltura) {
                maiorAltura = altura[i];
            }

            somaDasAlturas += altura[i];

        }

        for (int i = 0; i < genero.length; i++) {
            if (genero[i] == 'M') {
                qtdHomens++;
            }
        }

        double mediaAlturas = somaDasAlturas / qtdPessoas;

        System.out.printf("Menor altura = %.2f%n",  menorAltura);
        System.out.printf("Maior altura = %.2f%n",  maiorAltura);
        System.out.printf("Media das alturas = %.2f%n", mediaAlturas);
        System.out.printf("Numero de homens = %d",  qtdHomens);

        sc.close();
    }
}
