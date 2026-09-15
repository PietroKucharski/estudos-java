package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class Aula03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String x;
        // x = sc.next(); // Permite que seja escrito um texto no console e guarde na variável `x`
        // System.out.println("Você digitou: " + x); // Imprimindo utilizando println normal
        // System.out.printf("Você digitou: %s", x); // Imprimindo utilizando printf


        // int x;
        // x = sc.nextInt(); // Permite que seja escrito um número no console e guarde na variável `x`
        // System.out.println("Você digitou: " + x);
        // System.out.printf("Você digitou: %d", x);

        // Locale.setDefault(Locale.US);
        // double x; // Localidade do sistema, ou seja, é preciso digitar no console com virgula. Caso queira utilizar o ponto é preciso trocar a localidade utilizando o Locale
        // x = sc.nextDouble(); // Permite que seja escrito um número de ponto flutuante no console e guarde na variável `x`
        // System.out.println("Você digitou: " + x);
        // System.out.printf("Você digitou: %.2f%n", x);

        // char x;
        // x = sc.next().charAt(1); // Permite que seja escrito apenas um text no console e guarde na variável `x`, porém irá retornar apenas o caracter especificado dentro do parênteses
        // System.out.println("Você digitou: " + x);

        // Lendo vários inputs em sequencia
//        String x;
//        int y;
//        double z;
//
//        x = sc.next();
//        y = sc.nextInt();
//        z = sc.nextDouble();
//
//        System.out.println("Dados digitados: ");
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);

        // Ler um texto até a quebra de linha

//        String s1, s2, s3;
//
//        s1 = sc.nextLine();
//        s2 = sc.nextLine();
//        s3 = sc.nextLine();
//
//        System.out.println("Dados digitados: ");
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);

        // Quebra de linha pendente

        int x;
        String s1, s2, s3;

        x = sc.nextInt(); // Faz com que tenha uma quebra de linha pendente e será consumido pelo próximo campo
        sc.nextLine(); // Isso faz com que a quebra de linha pendente seja consumida
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        s3 = sc.nextLine();

        System.out.println("Dados digitados: ");
        System.out.println(x);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        sc.close();
    }
}
