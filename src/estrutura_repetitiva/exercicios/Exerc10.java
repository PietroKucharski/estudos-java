package estrutura_repetitiva.exercicios;

import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro positivo N. O programa deve então mostrar na tela N linhas,
começando de 1 até N. Para cada linha, mostrar o número da linha, depois o quadrado e o cubo do valor, conforme
exemplo.
*/
public class Exerc10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ler um número inteiro positivo N
        int n = input.nextInt();

        //mostrar na tela N linhas, começando de 1 até N
        for (int i = 1; i <= n; i++) {
            // mostrar o número da linha
            int numeroLinha = i;

            // quadrado do valor
            int quadradoValor = i * i;

            // cubo do valor
            int cuboValor = i * i * i;

            System.out.printf("%d %d %d\n", numeroLinha, quadradoValor, cuboValor);
        }

        input.close();
    }
}
