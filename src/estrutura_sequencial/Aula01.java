package estrutura_sequencial;

import java.util.Locale;

public class Aula01 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        // Utilizando o println acontece a quebra de linha na saída da execução
        System.out.println("Bom dia!");
        System.out.println("Tudo bem??");

        // Escrevendo conteúdo de uma variável de um tipo básico
        int y = 32; // Declaração de variável
        System.out.println(y); // Mostra o conteúdo contido na variável y

        // Escrevendo conteúdo de uma variável de um tipo ponto flutuante
        double x = 10.35784;

        // Por padrão printf utiliza "," para separação de casas decimais
        // Utilizamos o Locale.setDefault(Locale.US); para trocar a vírgula por ponto
        System.out.printf("%.2f%n", x); // Faz com que mostre o valor com apenas duas casas decimais (.2f) e quebra linha (%n)
        System.out.printf("%.4f%n", x); // 4 casas decimais

        // Concatenar vários elementos em um mesmo comando de escrita usando println
        System.out.println("Resultado = " + x + " metros");

        // Concatenar vários elementos em um mesmo comando de escrita usando printf
        System.out.printf("Resultado = %.2f metros %n", x);

        String nome = "Pietro";
        int idade = 24;
        double renda = 3000.0;
        System.out.printf("%s tem %d anos e ganha R$%.2f reais%n", nome, idade, renda);
    }
}
