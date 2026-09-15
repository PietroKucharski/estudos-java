package estrutura_condicional.exercicios;

import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro, e depois dizer se este número é negativo ou não.
*/
public class Exerc01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero =  input.nextInt();

        if (numero < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Não negativo");
        }
        input.close();
    }
}
