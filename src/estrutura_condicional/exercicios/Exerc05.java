package estrutura_condicional.exercicios;

import java.util.Scanner;

/*
Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste item. A
seguir, calcule e mostre o valor da conta a pagar.
*/

public class Exerc05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double precoFinal;

        int codigo = input.nextInt();
        int quantidade = input.nextInt();

        if (codigo == 1) {
            precoFinal = quantidade * 4.00;
            System.out.printf("Total: R$ %.2f%n", precoFinal);
        } else if (codigo == 2) {
            precoFinal = quantidade * 4.50;
            System.out.printf("Total: R$ %.2f%n", precoFinal);
        }  else if (codigo == 3) {
            precoFinal = quantidade * 5.00;
            System.out.printf("Total: R$ %.2f%n", precoFinal);
        } else if (codigo == 4) {
            precoFinal = quantidade * 2.00;
            System.out.printf("Total: R$ %.2f%n", precoFinal);
        } else if (codigo == 5) {
            precoFinal = quantidade * 1.50;
            System.out.printf("Total: R$ %.2f%n", precoFinal);
        } else {
            System.out.println("Opção inválida");
        }


        input.close();
    }
}
