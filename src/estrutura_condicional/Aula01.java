package estrutura_condicional;

import java.util.Scanner;

public class Aula01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 5;
        int hora;

        System.out.println("Quantas horas?");
        hora = sc.nextInt();

//        if (hora < 12) {
//            System.out.println("Bom dia");
//        } else {
//            System.out.println("Boa tarde");
//        }

        // Encadeamento de estrutura condicional
        if (hora < 12) {
            System.out.println("Bom dia");
        } else {
            if (hora < 18) {
                System.out.println("Boa tarde");
            } else {
                System.out.println("Boa noite");
            }
        }

        // Simplificando o else
        if (hora < 12) {
            System.out.println("Bom dia");
        } else if (hora < 18) {
            System.out.println("Boa tarde");
        } else {
            System.out.println("Boa noite");

        }

//        if (x > 0) {
//            System.out.println("Bom dia");
//
//        }
//
//        if (x < 0) {
//            System.out.println("Boa tarde");
//        }
//
//        System.out.println("Boa noite");

        sc.close();
    }
}
