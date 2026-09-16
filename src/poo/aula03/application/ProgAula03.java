package poo.aula03.application;

import poo.aula03.entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class ProgAula03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.println("Enter product data: ");

        System.out.println("Name: ");
        product.name = sc.nextLine();

        System.out.println("Price: ");
        product.price = sc.nextDouble();

        System.out.println("Quantity in stock: ");
        product.quantity = sc.nextInt();

        sc.close();
    }
}
