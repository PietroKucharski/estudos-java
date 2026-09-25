package projetos_alternativos.carteira.entities;

public class Lancamento {
    // Receitas não têm categoria. Usa -1 porque os índices 0 a 4 de
    // Carteira.CATEGORIAS já são categorias reais (0 é Moradia), e -1 nunca
    // é um índice válido: se for usado por engano, o erro aparece na hora.

    public static final int SEM_CATEGORIA = -1;
    private static int proximoId = 1;
    private final int id;
    private final String descricao;
    private final double valor;
    private final int mes;
    private final boolean receita;
    private final int categoria;

    public Lancamento(String descricao, double valor, int mes) {
        this.id = proximoId;
        proximoId++;
        this.descricao = descricao;
        this.valor = valor;
        this.mes = mes;
        this.receita = true;
        this.categoria = SEM_CATEGORIA;
    }

    public Lancamento(String descricao, double valor, int mes, int categoria) {
        this.id = proximoId;
        proximoId++;
        this.descricao = descricao;
        this.valor = valor;
        this.mes = mes;
        this.categoria = categoria;
        this.receita = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getMes() {
        return mes;
    }

    public boolean isReceita() {
        return receita;
    }

    public int getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", mes=" + mes +
                ", receita=" + receita +
                ", categoria=" + categoria +
                '}';
    }
}
