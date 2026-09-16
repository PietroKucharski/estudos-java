package estrutura_repetitiva.exercicios;

/*
Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha
incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for informada corretamente deve ser
impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha correta é o valor 2002.
*/

import java.util.Scanner;

public class Exerc01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int senha = input.nextInt();
        int senhaValida = 2002;

        while (senha != senhaValida){
            System.out.println("Senha invalida");
            senha = input.nextInt();
        }

        System.out.println("Acesso Permitido");
        input.close();
    }
}
