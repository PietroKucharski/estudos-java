package exercicios_alternativos.exerc08.entities;

import java.util.List;

public class ItemCarrinho {
    private final int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public ItemCarrinho(int codigo, double preco, int quantidade, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void aumentarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public boolean alterarQuantidade(int novaQuantidade) {
        if (novaQuantidade <= 0) {
            return false;
        }

        this.quantidade = novaQuantidade;
        return true;
    }

    public double subtotal() {
        return preco * quantidade;
    }

}
