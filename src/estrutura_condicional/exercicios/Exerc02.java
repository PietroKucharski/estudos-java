package estrutura_condicional.exercicios;

/*
Fazer um programa para ler um número inteiro e dizer se este número é par ou ímpar.
*/

import java.util.Scanner;

public class Exerc02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();

        if (numero % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }
        input.close();
    }
}
