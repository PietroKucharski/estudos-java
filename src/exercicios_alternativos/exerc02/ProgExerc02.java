package exercicios_alternativos.exerc02;

import java.util.Scanner;

public class ProgExerc02 {
    public static void main(String[] args) {
        // Trecho A
//        int a = 7, b = 2;
//        double r1 = a / b;
//        double r2 = (double) a / b;
//        double r3 = (double) (a / b);
//        int r4 = a % b;
//
//        System.out.println(r1); // 3.0 a divisão entre os inteiros é feita. Depois é guardada numa variável double
//        System.out.println(r2); // 3.5 valor da variável double com a realização de casting
//        System.out.println(r3); // 3.0 Divisão pelos inteiros é feita primeiro e o casting faz o 3 virar 3.0
//        System.out.println(r4); // 1 como há resto da divisão é impresso o valor 1

        // Trecho B
        /*
            Entrada:
            25
            Maria Silva
        */

        Scanner sc = new Scanner(System.in);
//        int idade = sc.nextInt();
//        String nome = sc.nextLine();
//
//        System.out.println("Idade: " + idade);
//        System.out.println("Nome: [" + nome + "]");

        // Saída: Idade: 25 Nome: []
        // Explicação: nextInt() deixa uma linha pendente e o nextLine() consome essa quebra de linha fazendo com que o valor fique vazio

        // Trecho C
        // Entrada: Maria Silva

//        String nome = sc.next();
//        String resto = sc.nextLine();
//
//        System.out.println("[" + nome + "]");
//        System.out.println("[" + resto + "]");

        // Saída: [Maria] [ Silva]
        // Explicação: next() le até encontrar o primeiro espaço em branco ou quebra de linha

        // Trecho D
//        double preco = 150.0;
//        if (preco > 100.0) {
//            double desconto = preco * 0.1;
//        }
//
//        System.out.println(desconto);
//        // Saída: Erro
//        // Explicação: Erro de compilação, a variável desconto é apenas visível dentro do if, fora ela não existe
//        // Para exibir é preciso colocar e iniciar a variável desconto fora do if e utiliza-la dentro do if

        // Trecho E
//        int x = 10;
//        do {
//            System.out.println(x);
//            x += 5;
//        } while (x < 10);
//
//        int y = 10;
//        while (y < 10) {
//            System.out.println(y);
//            y += 5;
//        }

        // Saída: 10
        // Explicação: A diferença de comportamento é que a primeira a condição está no final então ela irá executar o bloco de código
        // Já a segunda a condição está no começo então não irá executar

        // Trecho F
        int opcao = 2;

        switch (opcao) {
            case 1:
                System.out.println("Um");
            case 2:
                System.out.println("Dois");
            case 3:
                System.out.println("Tres");
                break;
            default:
                System.out.println("Outro");
        }

        // Saída: Dois e Três
        // Explicação: Como o break está apenas no caso 3 irá ser impresso o valor contido no caso 3 e no caso 2
        // O valor default não foi exibido pois existe o break dentro do caso 3, sem ele é exibido todos após a opção 2
    }
}
