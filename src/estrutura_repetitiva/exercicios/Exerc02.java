package estrutura_repetitiva.exercicios;

import java.util.Scanner;

/*
Escreva um programa para ler as coordenadas (X,Y) de uma quantidade indeterminada de pontos no sistema
cartesiano. Para cada ponto escrever o quadrante a que ele pertence. O algoritmo será encerrado quando pelo
menos uma de duas coordenadas for NULA (nesta situação sem escrever mensagem alguma).
*/
public class Exerc02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ler as coordenadas
        int x =  input.nextInt();
        int y =  input.nextInt();

        while (x != 0 && y != 0) {
            if (x > 0 && y > 0) {
                System.out.println("Q1");
            } else if (x < 0 && y > 0) {
                System.out.println("Q2");
            } else if (x < 0 && y < 0) {
                System.out.println("Q3");
            } else {
                System.out.println("Q4");
            }
            x = input.nextInt();
            y = input.nextInt();
        }

        input.close();
    }
}
