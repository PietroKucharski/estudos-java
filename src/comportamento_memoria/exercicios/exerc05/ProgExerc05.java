package comportamento_memoria.exercicios.exerc05;

import java.util.Scanner;

/*
Faça um programa que leia N números inteiros e armazene-os em um vetor. Em seguida, mostre na
tela todos os números pares, e também a quantidade de números pares.
*/
public class ProgExerc05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");

        int n = sc.nextInt();
        int[] vect = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            int numeros = sc.nextInt();
            vect[i] = numeros;
        }

        int qtdPares = 0;
        System.out.println("NÚMEROS PARES: ");
        for (int i = 0; i < n; i++) {
            if (vect[i] % 2 == 0){
                qtdPares++;
                System.out.printf("%d ", vect[i]);
            }
        }

        System.out.printf("\nQUANTIDADE DE PARES = %d", qtdPares);

        sc.close();
    }
}
