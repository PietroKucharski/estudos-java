package estrutura_repetitiva;

import java.util.Scanner;

public class Aula02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int soma = 0;

        for (int i = 0; i < n; i++) {
            int x  = input.nextInt();
            soma += x;
        }

        System.out.println(soma);

        for (int i = 0; i < 5; i++) {
            System.out.println("Valor de i: " + i);
        }

        input.close();
    }
}
