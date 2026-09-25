package exercicios_alternativos.exerc11.application;

import exercicios_alternativos.exerc11.entities.Emprestimo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgExerc11 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // um inteiro K, a quantidade de operações;
        int k = sc.nextInt();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            // operações, uma por linha:
            // N codigo diaPrevisto aluno → novo empréstimo;
            // D codigo diaAtual → devolução;
            // A diaAtual → relatório de atrasados;
            // X diaAtual → limpeza dos atrasos acima do limite.
            char operacao = sc.next().charAt(0);

            switch (operacao) {
                case 'N':
                    int codigoLivro = sc.nextInt();
                    int diaPrevisto = sc.nextInt();
                    String nomeAluno = sc.nextLine().trim();

                    Emprestimo emprestimo = buscaPorEmprestimo(emprestimos, codigoLivro);

                    if (emprestimo == null) {
                        emprestimos.add(new Emprestimo(codigoLivro, nomeAluno, diaPrevisto));
                        System.out.printf("EMPRESTIMO REGISTRADO: %d para %s (previsto dia %d)%n", codigoLivro, nomeAluno, diaPrevisto);
                    } else {
                        System.out.printf("LIVRO JA EMPRESTADO: %d%n", codigoLivro);
                    }
                    break;
                case 'D':
                    codigoLivro = sc.nextInt();
                    int diaDevolvido = sc.nextInt();
                    emprestimo = buscaPorEmprestimo(emprestimos, codigoLivro);

                    if (emprestimo == null) {
                        System.out.printf("EMPRESTIMO NAO ENCONTRADO: %d%n", codigoLivro);
                    } else {
                        if (emprestimo.estaAtrasado(diaDevolvido)) {

                            System.out.printf("DEVOLVIDO: %d - %s - ATRASO %d dias - MULTA R$ %.2f%n", codigoLivro,
                                    emprestimo.getNomeAluno(), emprestimo.diasDeAtraso(diaDevolvido),
                                    emprestimo.multa(diaDevolvido));
                        } else {
                            System.out.printf("DEVOLVIDO: %d - %s - SEM ATRASO%n", codigoLivro, emprestimo.getNomeAluno());
                        }
                        emprestimos.remove(emprestimo);
                    }
                    break;
                case 'A':
                    int diaAtual = sc.nextInt();

                    long quantidade = emprestimos.stream().filter(x -> x.estaAtrasado(diaAtual)).count();
                    System.out.printf("ATRASADOS (%d):%n", quantidade);

                    emprestimos.stream()
                            .filter(emp -> emp.estaAtrasado(diaAtual))
                            .forEach(emp -> System.out.printf("%d - %s - %d dias%n", emp
                                    .getCodigoDoLivro(), emp.getNomeAluno(), emp.diasDeAtraso(diaAtual)));
                    break;
                case 'X':
                    diaAtual = sc.nextInt();
                    int antes = emprestimos.size();

                    emprestimos.removeIf(emp -> emp.diasDeAtraso(diaAtual) > 10);

                    System.out.printf("CANCELADOS: %d%n", antes - emprestimos.size());
                    break;
            }

        }

        System.out.println("EMPRESTIMOS ATIVOS:");

        if (emprestimos.isEmpty()) {
            System.out.println("NENHUM EMPRESTIMO ATIVO");
        } else {
            emprestimos.forEach(emp -> System.out.printf("%d - %s - previsto dia %d%n",
                    emp.getCodigoDoLivro(), emp.getNomeAluno(), emp.getDiaPrevisto()));
        }

        sc.close();
    }

    public static Emprestimo buscaPorEmprestimo(List<Emprestimo> emprestimos, int codigoLivro) {
        return emprestimos.stream()
                .filter(x -> x.getCodigoDoLivro() == codigoLivro)
                .findFirst()
                .orElse(null);
    }


}
