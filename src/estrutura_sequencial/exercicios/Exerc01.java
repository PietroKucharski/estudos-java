package estrutura_sequencial.exercicios;

/*
Faça um programa para ler dois valores inteiros, e depois mostrar na tela a soma desses números com uma
mensagem explicativa, conforme exemplos.
*/

import java.util.Scanner;

public class Exerc01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, soma;

        // Irá ler os valores digitados e guardar nas variáveis
        x = sc.nextInt();
        y = sc.nextInt();

        soma = x + y;

        System.out.printf("SOMA = %d", soma);
    }
}
