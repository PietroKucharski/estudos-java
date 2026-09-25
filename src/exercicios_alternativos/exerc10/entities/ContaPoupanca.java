package exercicios_alternativos.exerc10.entities;

public class ContaPoupanca {

    private final int numero;
    private String titular;
    private double saldo;
    private final double taxaJuros;
    private int totalDepositos;

    public ContaPoupanca(int numero, String titular, double taxaJuros) {
        this.numero = numero;
        this.titular = titular;
        this.taxaJuros = taxaJuros;
        this.saldo = 0.0;
        this.totalDepositos = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getTotalDepositos() {
        return totalDepositos;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        totalDepositos++;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public void aplicarJuros() {
        saldo += saldo * taxaJuros;
    }
}