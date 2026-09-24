package exercicios_alternativos.exerc05;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc05 {
    public static final double COMISSAO_VENDAS_ACIMA_DE_MIL = 0.02;
    public static final double COMISSAO_VENDAS_ABAIXO_DE_MIL = 0.01;
    public static final double LIMITE_COMISSAO_MAIOR = 1000;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numeroDias = sc.nextInt();
        double[] vendas = cadastrarVendas(sc, numeroDias);

        double totalDeVendas = totalDeVendas(vendas);
        double mediaVendas = totalDeVendas / numeroDias;
        int melhorDiaDeVenda = melhorDiaDeVenda(vendas);
        int quantidadeDiasAcimaDaMedia = quantidadeDiasAcimaDaMedia(mediaVendas, vendas);
        double comissaoDeVendas = comissaoDeVenda(vendas);

        System.out.printf("TOTAL = %.2f%n", totalDeVendas);
        System.out.printf("MEDIA = %.2f%n", mediaVendas);
        System.out.printf("MELHOR DIA = %d (%.2f)%n", (melhorDiaDeVenda + 1), vendas[melhorDiaDeVenda]);
        System.out.printf("DIAS ACIMA DA MEDIA = %d%n", quantidadeDiasAcimaDaMedia);
        System.out.printf("COMISSAO = %.2f%n", comissaoDeVendas);

        sc.close();
    }

    public static double[] cadastrarVendas(Scanner sc, int numeroDias){
        double[] vendas = new double[numeroDias];

        for (int i = 0; i < numeroDias; i++) {
            vendas[i] = sc.nextDouble();
        }

        return vendas;
    }

    public static double totalDeVendas(double[] vendas){
        double soma = 0;

        for (double venda : vendas) {
            soma = soma + venda;
        }

        return soma;
    }

    public static int melhorDiaDeVenda(double[] vendas){
        double melhorDia = vendas[0];
        int dia = 0;

        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] > melhorDia) {
                melhorDia = vendas[i];
                dia = i;
            }
        }

        return dia;
    }

    public static int quantidadeDiasAcimaDaMedia(double media, double[] vendas){
        int conta = 0;

        for (double venda : vendas) {
            if (venda > media) {
                conta = conta + 1;
            }
        }

        return conta;
    }

    public static double comissaoDeVenda(double[] vendas){
        double totalComissao = 0;

        for (double venda : vendas) {
            if (venda > LIMITE_COMISSAO_MAIOR) {
                totalComissao = totalComissao + venda * COMISSAO_VENDAS_ACIMA_DE_MIL;
            } else {
                totalComissao = totalComissao + venda * COMISSAO_VENDAS_ABAIXO_DE_MIL;
            }
        }

        return totalComissao;
    }


}
