package comportamento_memoria.exercicios.exerc10;

/*
Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades. Os nomes
devem ser armazenados em um vetor, e as idades em um outro vetor. Depois, mostrar na tela o nome
da pessoa mais velha.
*/

import java.util.Scanner;

public class ProgExerc10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas você vai digitar? ");
        int qtdPessoas = sc.nextInt();
        
        String[] nomes = new String[qtdPessoas];
        int[] idades = new int[qtdPessoas];
        int maiorIdade = idades[0];
        int indiceMaiorIdade = 0;

        for (int i = 0; i < qtdPessoas; i++) {
            System.out.printf("Dados da %dª pessoa:\n", i + 1);

            System.out.print("Nome: ");
            nomes[i] = sc.next();

            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
        }

        for (int i = 0; i < idades.length; i++) {
            if (idades[i] > maiorIdade) {
                maiorIdade = idades[i];
                indiceMaiorIdade = i;
            }
        }

        System.out.printf("PESSOA MAIS VELHA: %s", nomes[indiceMaiorIdade]);
        sc.close();
    }
}
