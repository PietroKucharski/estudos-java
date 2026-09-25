package exercicios_alternativos.exerc10.application;

import exercicios_alternativos.exerc10.entities.ContaPoupanca;

public class ProgExerc10 {
    public static void main(String[] args) {
        ContaPoupanca conta = new ContaPoupanca(1001, "Ana Clara", 0.005);

        if (conta.depositar(500.0)) {
            System.out.printf("Deposito realizado. Saldo: %.2f%n", conta.getSaldo());
        } else {
            System.out.println("Deposito recusado.");
        }

        if (conta.sacar(800.0)) {
            System.out.printf("Saque realizado. Saldo: %.2f%n", conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente.");
        }

        if (conta.getSaldo() > 0) {
            conta.aplicarJuros();
        }

        System.out.printf("%s: %.2f%n", conta.getTitular(), conta.getSaldo());
    }
}