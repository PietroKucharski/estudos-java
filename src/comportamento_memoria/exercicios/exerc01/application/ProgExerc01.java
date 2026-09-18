package comportamento_memoria.exercicios.exerc01.application;

import comportamento_memoria.exercicios.exerc01.entities.Rent;

import java.util.Scanner;

/*
A dona de um pensionato possui dez quartos para alugar para estudantes, sendo esses quartos identificados pelos números de 0 a 9.

Fazer um programa que inicie com todos os dez quartos vazios e, depois, leia uma quantidade **N**, representando o número de estudantes que vão alugar quartos (**N pode ser de 1 a 10**).

Em seguida, registre o aluguel dos **N estudantes**. Para cada registro de aluguel, informe:

* Nome do estudante;
* E-mail do estudante;
* Qual dos quartos ele escolheu, de 0 a 9.

Suponha que seja escolhido um quarto vago.

Ao final, seu programa deve imprimir um **relatório de todas as ocupações do pensionato, por ordem de quarto**, conforme o exemplo.

*/

public class ProgExerc01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rent[] vect = new Rent[10];

        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Rent #%d%n", i);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Room: ");
            int room = sc.nextInt();

            vect[room] = new Rent(name, email);
        }

        System.out.println("Busy rooms:");
        for (int i = 0; i < 10; i++) {
            if (vect[i] != null) {
                System.out.printf("%d: %s, %s%n", i, vect[i].getName(), vect[i].getEmail());
            }
        }
        sc.close();
    }
}
