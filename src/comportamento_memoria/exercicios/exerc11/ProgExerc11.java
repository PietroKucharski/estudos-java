package comportamento_memoria.exercicios.exerc11;

/*
Fazer um programa para ler um conjunto de N nomes de alunos, bem como as notas que eles tiraram
no 1º e 2º semestres. Cada uma dessas informações deve ser armazenada em um vetor. Depois, imprimir
os nomes dos alunos aprovados, considerando aprovados aqueles cuja média das notas seja maior ou
igual a 6.0 (seis).
*/

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc11 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serão digitados? ");
        int qtdAlunos = sc.nextInt();

        String[] nomes = new String[qtdAlunos];
        double[] nota1 = new double[qtdAlunos];
        double[] nota2 = new double[qtdAlunos];

        double notaAprovacao = 6.0;

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("Digite o nome, primeira e segunda nota do %dº aluno \n", i + 1);
            sc.nextLine();
            nomes[i] = sc.nextLine();
            nota1[i] = sc.nextDouble();
            nota2[i] = sc.nextDouble();
        }

        System.out.println("Alunos aprovados:");

        for (int i = 0; i < nomes.length; i++) {
            if ((nota1[i] + nota2[i]) /2 >= notaAprovacao ) {
                System.out.println(nomes[i]);
            }
        }
        sc.close();
    }
}
