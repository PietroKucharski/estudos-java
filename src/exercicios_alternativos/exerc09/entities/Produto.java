package exercicios_alternativos.exerc09.entities;

public class Produto {
    private final int codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public Produto(int codigo, String nome, double preco, int quantidade, int estoqueMinimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public boolean entrada(int valorEntrada) {
        if (valorEntrada > 0) {
            this.quantidade += valorEntrada;
            return true;
        }

        return false;
    }

    public boolean saida(int valorSaida) {
        if (valorSaida > 0 && valorSaida <= this.quantidade) {
            this.quantidade -= valorSaida;
            return true;
        }

        return false;
    }

    public double valorEmEstoque() {
        return quantidade * preco;
    }

    public boolean abaixoDoMinimo() {
        return this.quantidade < this.estoqueMinimo;
    }
}
