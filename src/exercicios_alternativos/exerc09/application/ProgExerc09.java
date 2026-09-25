package exercicios_alternativos.exerc09.application;

import exercicios_alternativos.exerc09.entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgExerc09 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // um inteiro N, a quantidade de produtos;
        int n = sc.nextInt();

        List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // N linhas no formato codigo preco quantidade estoqueMinimo nome;
            int codigo = sc.nextInt();
            double preco = sc.nextDouble();
            int quantidade = sc.nextInt();
            int estoqueMinimo = sc.nextInt();
            String nome = sc.nextLine().trim();

            produtos.add(new Produto(codigo, nome, preco, quantidade, estoqueMinimo));
        }

        // um inteiro M, a quantidade de movimentações;
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            // M linhas no formato E codigo quantidade (entrada) ou S codigo quantidade (saída).
            char operacao = sc.next().toUpperCase().charAt(0);
            int codigo = sc.nextInt();
            int quantidade = sc.nextInt();
            Produto produto = buscarPorCodigo(produtos, codigo);

            // movimentação com código inexistente → mensagem de produto não encontrado;
            if (produto == null) {
                System.out.printf("PRODUTO NAO ENCONTRADO: %d%n", codigo);
            } else {
                switch (operacao) {
                    case 'S':
                        // saída maior que o estoque → recusada, com mensagem;
                        if (produto.saida(quantidade)) {
                            System.out.printf("SAIDA OK: %s (%d)%n", produto.getNome(), produto.getQuantidade());
                        } else {
                            System.out.printf("ESTOQUE INSUFICIENTE: %s%n", produto.getNome());
                        }
                        break;
                    case 'E':
                        if (produto.entrada(quantidade)) {
                            System.out.printf("ENTRADA OK: %s (%d)%n", produto.getNome(), produto.getQuantidade());
                        } else {
                            System.out.println("QUANTIDADE INVALIDA");
                        }
                        break;
                }
            }


        }

        System.out.println("ESTOQUE:");

        for (Produto produto : produtos) {
            System.out.printf("%d - %s - %d un x %.2f = %.2f%n", produto.getCodigo(), produto.getNome(),
                    produto.getQuantidade(), produto.getPreco(), produto.valorEmEstoque());
        }

        System.out.printf("VALOR TOTAL: %.2f%n", valorTotalDoEstoque(produtos));

        System.out.println("ABAIXO DO MINIMO:");

        boolean existeProdutoAbaixoDoMinimo = false;

        for (Produto produto : produtos) {
            if (produto.abaixoDoMinimo()) {
                existeProdutoAbaixoDoMinimo = true;
                System.out.printf("%d - %s (%d/%d)%n", produto.getCodigo(), produto.getNome(), produto.getQuantidade(), produto.getEstoqueMinimo());
            }
        }

        if  (!existeProdutoAbaixoDoMinimo) {
            System.out.println("NENHUM");
        }

        Produto produtoMaiorValor = produtoDeMaiorValor(produtos);

        System.out.printf("MAIOR VALOR EM ESTOQUE: %d - %s - %.2f%n", produtoMaiorValor.getCodigo(),
                produtoMaiorValor.getNome(), produtoMaiorValor.valorEmEstoque());

        sc.close();
    }

    public static Produto buscarPorCodigo(List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public static double valorTotalDoEstoque(List<Produto> produtos) {
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.valorEmEstoque();
        }
        return valorTotal;
    }

    public static Produto produtoDeMaiorValor(List<Produto> produtos) {
        Produto produtoDeMaiorValor = produtos.getFirst();

        for (Produto produto : produtos) {
            if (produto.valorEmEstoque() > produtoDeMaiorValor.valorEmEstoque()) {
                produtoDeMaiorValor = produto;
            }
        }
        return produtoDeMaiorValor;
    }
}
