package exercicios_alternativos.exerc10.entities;

public class ContaPoupancaRefact {
    private final int numero;
    private String titular;
    private double saldo;
    private static final double TAXA_JUROS = 0.005;
    private int totalDepositos;

    public ContaPoupancaRefact(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.totalDepositos = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalDepositos() {
        return totalDepositos;
    }

    public void depositar(double valor) {
        saldo = saldo + valor;
        totalDepositos++;
        System.out.println("Deposito realizado. Saldo: " + saldo);
    }

    public void sacar(double valor) {
        saldo = saldo - valor;
        System.out.println("Saque realizado. Saldo: " + saldo);
    }

    public void aplicarJuros() {
        saldo = saldo + saldo * TAXA_JUROS;
    }
}
