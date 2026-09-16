package estrutura_repetitiva.exercicios;

import java.util.Scanner;

/*
Fazer um programa para ler um número N. Depois leia N pares de números e mostre a divisão do primeiro pelo
segundo. Se o denominador for igual a zero, mostrar a mensagem "divisao impossivel".
*/
public class Exerc07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int numerador = input.nextInt();
            int denominador = input.nextInt();

            if (denominador == 0) {
                System.out.println("Divisão impossível");
            } else {
                double resultado = (double) numerador / denominador;
                System.out.printf("%.1f%n", resultado);
            }

        }

        input.close();
    }
}
