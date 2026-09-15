package estrutura_sequencial.exercicios;

/*
Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc05 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int peca1, peca2;
        int numeroDePecas1, numeroDePecas2;
        double valorUnitarioPeca1, valorUnitarioPeca2;

        peca1 = sc.nextInt();
        numeroDePecas1 = sc.nextInt();
        valorUnitarioPeca1 = sc.nextDouble();

        peca2 = sc.nextInt();
        numeroDePecas2 = sc.nextInt();
        valorUnitarioPeca2 = sc.nextDouble();

        double valorPagar = (numeroDePecas1 * valorUnitarioPeca1) + (numeroDePecas2 * valorUnitarioPeca2);

        System.out.printf("VALOR A PAGAR %.2f%n", valorPagar);
    }
}
