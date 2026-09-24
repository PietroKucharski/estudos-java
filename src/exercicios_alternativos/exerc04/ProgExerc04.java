package exercicios_alternativos.exerc04;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc04 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // dois inteiros N (alunos) e P (provas);
        int n = sc.nextInt();
        int p = sc.nextInt();

        // guarde os nomes em um vetor e as notas em uma matriz N × P
        String[] nomes = new String[n];
        double[][] notas = new double[n][p];

        // para cada aluno:
        for (int i = 0; i < n; i++) {
            // Nome completo podendo conter espaços
            sc.nextLine();
            nomes[i] = sc.nextLine();

            // As P notas na linha seguinte
            for (int j = 0; j < p; j++) {
                notas[i][j] = sc.nextDouble();
            }
        }

        System.out.println("RELATORIO");

        // calcule a média de cada aluno e classifique: APROVADO, RECUPERACAO e REPROVADO
        for (int i = 0; i < nomes.length; i++) {
            double soma = 0;

            for (int j = 0; j < notas[i].length; j++) {
                soma += notas[i][j];
            }

            double media = soma / notas[i].length;


            if (media >= 7.0) {
                System.out.printf("%s: %.2f APROVADO%n", nomes[i], media);
            } else if (media >= 5.0) {
                System.out.printf("%s: %.2f RECUPERACAO%n", nomes[i], media);
            } else {
                System.out.printf("%s: %.2f REPROVADO%n", nomes[i], media);
            }
        }

        // calcule a média de cada prova (média de cada coluna da matriz);
        System.out.println("MEDIA POR PROVA");

        for (int i = 0; i < p; i++) {
            double somaProvas = 0;

            for (int j = 0; j < notas.length; j++) {
                somaProvas += notas[j][i];
            }

            double mediaProvas = somaProvas / notas.length;
            System.out.printf("Prova %d: %.2f%n", (i + 1), mediaProvas);
        }

        int numeroConsulta;

        do {
            numeroConsulta = sc.nextInt();

            if (numeroConsulta != 0) {
                if (numeroConsulta > 0 && numeroConsulta <= n) {
                    System.out.printf("CONSULTA %d: %s -> ", numeroConsulta, nomes[numeroConsulta - 1]);

                    for (int i = 0; i < p; i++) {
                        System.out.printf("%.1f ", notas[numeroConsulta - 1][i]);
                    }
                    System.out.println();

                } else {
                    System.out.printf("CONSULTA %d: ALUNO INEXISTENTE%n", numeroConsulta);
                }
            }
        } while (numeroConsulta != 0);


        sc.close();
    }
}
