package comportamento_memoria.exercicios.exerc14;

/*
Faça um programa para ler dois números inteiros **M** e **N** e, em seguida, ler uma matriz de **M linhas por N colunas**, contendo números inteiros. Pode haver repetições de valores na matriz.

Depois, leia um número inteiro **X** que pertence à matriz.

Para cada ocorrência de **X** na matriz, mostre os valores que estão:

* à esquerda de X, quando houver;
* acima de X, quando houver;
* à direita de X, quando houver;
* abaixo de X, quando houver.

A saída deve seguir o formato apresentado no exemplo
*/

import java.util.Scanner;

public class ProgExerc14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int linhas = sc.nextInt();
        int colunas = sc.nextInt();

        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) { // Percorrer as linhas
            for (int j = 0; j < colunas; j++) { // Percorrer as colunas
                matriz[i][j] = sc.nextInt();
            }
        }

        int number = sc.nextInt();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == number) {
                    System.out.printf("Position: %d, %d\n", i, j);
                    if (j > 0) {
                        System.out.printf("Left: %d\n", matriz[i][j - 1]);
                    }

                    if (i > 0) {
                        System.out.printf("Up: %d\n", matriz[i - 1][j]);
                    }

                    if (j < matriz[i].length - 1) {
                        System.out.printf("Right: %d\n", matriz[i][j + 1]);
                    }

                    if (i < matriz.length - 1) {
                        System.out.printf("Down: %d\n", matriz[i + 1][j]);
                    }
                }

            }

        }



        sc.close();
    }
}
