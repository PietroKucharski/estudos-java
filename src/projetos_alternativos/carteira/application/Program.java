package projetos_alternativos.carteira.application;

import projetos_alternativos.carteira.entities.Carteira;
import projetos_alternativos.carteira.entities.Lancamento;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do titular: ");
        String nomeTitular = sc.nextLine();

        Carteira carteira = new Carteira(nomeTitular);

        int opcao;

        do {
            System.out.printf("=== CARTEIRA DE %s ===%n", carteira.getTitular());
            System.out.println("1 - Registrar receita");
            System.out.println("2 - Registrar despesa");
            System.out.println("3 - Remover lancamento");
            System.out.println("4 - Extrato do mes");
            System.out.println("5 - Definir limite de categoria");
            System.out.println("6 - Relatorio anual");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 0: {
                    System.out.println("Encerrado");
                    break;
                }
                case 1: {
                    System.out.print("Descricao: ");
                    String descricao = sc.nextLine();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    System.out.print("Mes (1-12): ");
                    int mes = sc.nextInt();

                    Lancamento lancamento = carteira.registrarReceita(descricao, valor, mes);

                    if (lancamento == null) {
                        System.out.println("DADOS INVALIDOS");
                    } else {
                        System.out.printf("Receita registrada: #%d%n", lancamento.getId());
                    }
                    break;
                }
                case 2: {
                    System.out.print("Descricao: ");
                    String descricao = sc.nextLine();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();

                    System.out.print("Mes (1-12): ");
                    int mes = sc.nextInt();

                    mostrarCategorias();

                    System.out.print("Categoria: ");
                    int categoria = sc.nextInt();

                    Lancamento lancamento = carteira.registrarDespesa(descricao, valor, mes, categoria);

                    if (lancamento == null) {
                        System.out.println("DADOS INVALIDOS");
                    } else {
                        System.out.printf("Despesa registrada: #%d%n", lancamento.getId());
                    }

                    break;
                }
                case 3: {
                    System.out.print("Id do lancamento: ");
                    int id = sc.nextInt();

                    boolean remocao = carteira.remover(id);

                    if (remocao) {
                        System.out.printf("Lancamento #%d removido%n", id);
                    } else {
                        System.out.println("LANCAMENTO NAO ENCONTRADO");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Mes (1-12): ");
                    int mes = sc.nextInt();

                    imprimirExtrato(carteira, mes);

                    break;
                }
                case 5: {
                    mostrarCategorias();

                    System.out.print("Categoria: ");
                    int categoria = sc.nextInt();

                    System.out.print("Limite mensal (0 = sem limite): ");
                    double limite = sc.nextDouble();

                    boolean definido = carteira.definirLimite(categoria, limite);

                    if (definido) {
                        System.out.printf("Limite definido: %s - R$ %.2f%n", Carteira.CATEGORIAS[categoria], limite);
                    } else {
                        System.out.println("DADOS INVALIDOS");
                    }

                    break;
                }
                case 6: {
                    imprimirRelatorioAnual(carteira);

                    break;
                }
                default: {
                    System.out.println("OPCAO INVALIDA");
                }
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void mostrarCategorias() {
        System.out.println("Categorias: ");
        for (int i = 0; i < Carteira.CATEGORIAS.length; i++) {
            System.out.printf("%d - %s%n", i, Carteira.CATEGORIAS[i]);
        }
    }

    private static void imprimirExtrato(Carteira carteira, int mes) {
        List<Lancamento> lancamentosDoMes = carteira.lancamentosDoMes(mes);

        if (lancamentosDoMes.isEmpty()) {
            System.out.printf("NENHUM LANCAMENTO NO MES %d%n", mes);
            return;
        }

        System.out.printf("EXTRATO - MES %d%n", mes);

        double totalReceita = 0;
        double totalDespesa = 0;

        for (Lancamento lancamento : lancamentosDoMes) {
            int id = lancamento.getId();
            String descricao = lancamento.getDescricao();
            double valor = lancamento.getValor();

            if (lancamento.isReceita()) {
                totalReceita += valor;
                System.out.printf("#%d RECEITA %s + R$ %.2f%n", id, descricao, valor);
            } else {
                totalDespesa += valor;
                System.out.printf("#%d DESPESA %s (%s) - R$ %.2f%n", id, descricao, Carteira.CATEGORIAS[lancamento.getCategoria()], valor);
            }
        }

        System.out.printf("RECEITAS: R$ %.2f%n", totalReceita);
        System.out.printf("DESPESAS: R$ %.2f%n", totalDespesa);
        System.out.printf("SALDO DO MES: R$ %.2f%n", carteira.saldo(mes));

        for (int i = 0; i < Carteira.CATEGORIAS.length; i++) {
            if (carteira.ultrapassouLimite(mes, i)) {
                System.out.printf("LIMITE ULTRAPASSADO: %s (R$ %.2f de R$ %.2f)%n", Carteira.CATEGORIAS[i], carteira.totalDespesas(mes, i), carteira.getLimite(i));
            }
        }
    }

    private static void imprimirRelatorioAnual(Carteira carteira) {
        System.out.println("RELATORIO ANUAL");

        System.out.println("DESPESAS POR CATEGORIA:");

        double[][] despesas = carteira.despesasPorCategoriaEMes();

        for (int i = 0; i < despesas.length; i++) {
            double total = 0;
            for (int j = 0; j < despesas[i].length; j++) {
                total += despesas[i][j];
            }

            System.out.printf("%s: R$ %.2f%n", Carteira.CATEGORIAS[i], total);
        }

        double maiorValor = 0;
        int mesMaior = 0;

        for (int j = 0; j < despesas[0].length; j++) {
            double totalDoMes = 0;

            for (int i = 0; i < despesas.length; i++) {
                totalDoMes += despesas[i][j];
            }

            if (totalDoMes > maiorValor) {
                maiorValor = totalDoMes;
                mesMaior = j + 1;
            }
        }

        if (maiorValor > 0) {
            System.out.printf("MES COM MAIOR DESPESA: %d (R$ %.2f)%n", mesMaior, maiorValor);
        } else {
            System.out.println("MES COM MAIOR DESPESA: NENHUM");
        }

        System.out.printf("SALDO DO ANO: R$ %.2f%n", carteira.saldo());
    }
}
