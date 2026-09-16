package estrutura_repetitiva.exercicios;

/*
Leia 1 valor inteiro N, que representa o número de casos de teste que vem a seguir. Cada caso de teste consiste
de 3 valores reais, cada um deles com uma casa decimal. Apresente a média ponderada para cada um destes
conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, o segundo valor tem peso 3 e o terceiro valor tem
peso 5.
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc06 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();


        for (int i = 0; i < n; i++) {
            double valor1 = input.nextDouble();
            double valor2 = input.nextDouble();
            double valor3 = input.nextDouble();

            double calcMediaPonderada = (valor1 * 2 + valor2 * 3 + valor3 * 5) / 10;

            System.out.printf("%.1f%n",  calcMediaPonderada);
        }

        input.close();
    }
}
