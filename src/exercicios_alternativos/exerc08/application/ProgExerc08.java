package exercicios_alternativos.exerc08.application;

import exercicios_alternativos.exerc08.entities.ItemCarrinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgExerc08 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<ItemCarrinho> itens = new ArrayList<>();

        // um inteiro K, a quantidade de operações;
        int k = sc.nextInt();

        //K operações, uma por linha:
        //A codigo preco quantidade nome → adicionar;
        //R codigo → remover o item do carrinho;
        //Q codigo novaQuantidade → alterar a quantidade.
        for (int i = 0; i < k; i++) {
            char operacao = sc.next().charAt(0);
            int codigo = sc.nextInt();
            ItemCarrinho item = buscarPorCodigo(itens, codigo);


            switch (operacao) {
                case 'A':
                    double preco = sc.nextDouble();
                    int quantidade = sc.nextInt();
                    String nome = sc.nextLine().trim();

                    if (item == null) {
                        itens.add(new ItemCarrinho(codigo, preco, quantidade, nome));
                        System.out.printf("ADICIONADO: %s x%d%n", nome, quantidade);
                    } else {
                        item.aumentarQuantidade(quantidade);
                        System.out.printf("QUANTIDADE ATUALIZADA: %s x%d%n", item.getNome(), item.getQuantidade());
                    }
                    break;
                case 'R':
                    if (item == null) {
                        System.out.printf("ITEM NAO ENCONTRADO: %d%n", codigo);
                    } else {
                        itens.remove(item);
                        System.out.printf("REMOVIDO: %s%n", item.getNome());
                    }
                    break;
                case 'Q':
                    int novaQuantidade = sc.nextInt();

                    if (item == null) {
                        System.out.printf("ITEM NAO ENCONTRADO: %d%n", codigo);
                    } else if (item.alterarQuantidade(novaQuantidade)) {
                        System.out.printf("QUANTIDADE ALTERADA: %s x%d%n", item.getNome(), item.getQuantidade());
                    } else {
                        System.out.println("QUANTIDADE INVALIDA");
                    }
                    break;
            }
        }


        if (itens.isEmpty()) {
            System.out.println("CARRINHO VAZIO");
        } else {
            System.out.println("CARRINHO:");
            double total = 0.0;
            int totalItens = 0;

            for (ItemCarrinho item : itens) {
                System.out.printf("%d - %s - %d x %.2f = %.2f%n", item.getCodigo(), item.getNome(), item.getQuantidade(), item.getPreco(), item.subtotal());
                total += item.subtotal();
                totalItens += item.getQuantidade();
            }

            System.out.printf("TOTAL: %.2f%n", total);
            System.out.printf("ITENS: %d%n", totalItens);
        }

        sc.close();
    }

    public static ItemCarrinho buscarPorCodigo(List<ItemCarrinho> itens, int codigo) {
        for (ItemCarrinho item : itens) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }
}
