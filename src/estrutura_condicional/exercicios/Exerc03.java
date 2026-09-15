package estrutura_condicional.exercicios;

import java.util.Scanner;

/*
Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem "Sao Multiplos" ou "Nao sao
Multiplos", indicando se os valores lidos são múltiplos entre si. Atenção: os números devem poder ser digitados em
ordem crescente ou decrescente.
*/
public class Exerc03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, B;

        A = sc.nextInt();
        B = sc.nextInt();

        if (A % B == 0 || B % A == 0) {
            System.out.println("Multiplo");
        } else {
            System.out.println("Não são multiplo");
        }

        sc.close();
    }
}
