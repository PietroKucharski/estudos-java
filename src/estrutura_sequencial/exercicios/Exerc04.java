package estrutura_sequencial.exercicios;

/*
Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
decimais.
*/

import java.util.Locale;
import java.util.Scanner;

public class Exerc04 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numeroFuncionario = sc.nextInt();
        int numeroHorasTrabalhadas =  sc.nextInt();
        double valorPorHorasTrabalhadas =  sc.nextDouble();
        double salario = numeroHorasTrabalhadas * valorPorHorasTrabalhadas;

        System.out.printf("NUMBER = %d\n", numeroFuncionario);
        System.out.printf("SALARY = R$ %.2f%n", salario);
    }
}
