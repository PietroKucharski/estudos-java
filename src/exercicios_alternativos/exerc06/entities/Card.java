package exercicios_alternativos.exerc06.entities;

public class Card {
    private final int numeroCartao;
    private String nomeTitular;
    private double saldo;
    private int quantidadeDeViagens;
    private static final double TARIFA = 5.00;
    private static final double LIMITE_RECARGA = 200.00;

    public Card(int numeroCartao, String nomeTitular) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
        this.quantidadeDeViagens = 0;
    }

    public Card(int numeroCartao, String nomeTitular, double saldo) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.quantidadeDeViagens = 0;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getQuantidadeDeViagens() {
        return quantidadeDeViagens;
    }

    public boolean recargaDeSaldo(double valor) {
        if (valor > 0 && valor <= LIMITE_RECARGA) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean pagamentoDePassagem() {
        if (saldo >= TARIFA) {
            saldo -= TARIFA;
            quantidadeDeViagens++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Cartao %d, Titular: %s, Saldo: R$ %.2f, Viagens: %d", numeroCartao, nomeTitular, saldo, quantidadeDeViagens);
    }
}
