package exercicios_alternativos.exerc06.application;

import exercicios_alternativos.exerc06.entities.Card;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc06 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numeroCartao = sc.nextInt();
        sc.nextLine();
        String nomeTitular = sc.nextLine();
        char temCreditoInicial = sc.next().charAt(0);
        double creditoInicial = 0.0;
        Card card;

        if (temCreditoInicial == 's') {
            creditoInicial = sc.nextDouble();
            card = new Card(numeroCartao, nomeTitular, creditoInicial);
        } else {
            card = new Card(numeroCartao, nomeTitular);
        }


        int quantidadeDeOperacoes = sc.nextInt();

        System.out.println(card.toString());
        for(int i = 0; i < quantidadeDeOperacoes; i++) {
            char operacao = sc.next().charAt(0);

            switch(operacao) {
                case 'P':
                    boolean pagamento = card.pagamentoDePassagem();

                    if (pagamento) {
                        System.out.println("PASSAGEM LIBERADA");
                    } else {
                        System.out.println("SALDO INSUFICIENTE");
                    }

                    break;
                case 'R':
                    double valorRecarga = sc.nextDouble();
                    boolean recarga = card.recargaDeSaldo(valorRecarga);

                    if (recarga) {
                        System.out.println("RECARGA EFETUADA");
                    } else {
                        System.out.println("RECARGA RECUSADA");
                    }

                    break;
                case 'N':
                    String novoTitular = sc.nextLine().trim();
                    card.setNomeTitular(novoTitular);
                    System.out.println("NOME ALTERADO");
                    break;
            }
        }

        System.out.println(card.toString());


        sc.close();
    }
}
