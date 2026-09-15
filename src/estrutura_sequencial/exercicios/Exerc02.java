package estrutura_sequencial.exercicios;

/*

Faça um programa para ler o valor do raio de um círculo, e depois mostrar o valor da área deste círculo com quatro
casas decimais conforme exemplos.

Fórmula da área: area = π . raio²

Considere o valor de π = 3.14159
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc02 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US); // Mudar localidade para utilizar ponto e não virgula para o retorno
        Scanner sc = new Scanner(System.in);

        double raio = sc.nextDouble();
        double PI = 3.14159;
        double area = PI * Math.pow(raio, 2);

        System.out.printf("AREA = %.4f%n", area);
    }
}
