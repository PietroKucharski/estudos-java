package comportamento_memoria.exercicios.exerc09;

import java.util.Scanner;

/*
Fazer um programa para ler um vetor de N números inteiros. Em seguida, mostrar na tela a média
aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum número par for
digitado, mostrar a mensagem "NENHUM NUMERO PAR"
*/
public class ProgExerc09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor?");
        int n  = sc.nextInt();
        int[] vect =  new int[n];
        int somaPares = 0;
        int qtdPares = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextInt();
        }

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] % 2 == 0) {
                somaPares = somaPares + vect[i];
                qtdPares++;
            }
        }


        if (qtdPares == 0) {
            System.out.println("NENHUM NÚMERO PAR");
        } else {
            double mediaPares = (double) somaPares / qtdPares;
            System.out.printf("MEDIA DOS PARES = %.1f\n", mediaPares);
        }


        sc.close();
    }
}
