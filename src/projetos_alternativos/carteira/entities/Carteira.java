package projetos_alternativos.carteira.entities;

import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private static final int MESES = 12;
    public static final String[] CATEGORIAS = new String[]{"Moradia", "Alimentacao", "Transporte", "Lazer", "Outros"};
    private final String titular;
    private final List<Lancamento> lancamentos;
    private final double[] limites;

    public Carteira(String titular) {
        this.titular = titular;
        this.lancamentos = new ArrayList<>();
        this.limites = new double[CATEGORIAS.length];

    }

    private boolean mesValido(int mes) {
        return mes >= 1 && mes <= MESES;
    }

    private boolean dadosValidos(String descricao, double valor, int mes) {
        return descricao != null && !descricao.isBlank() && valor > 0 && mesValido(mes);
    }

    private boolean categoriaValida(int categoria) {
        return categoria >= 0 && categoria < CATEGORIAS.length;
    }

    public Lancamento registrarReceita(String descricao, double valor, int mes) {
        // valida antes do new: registro inválido não pode consumir id
        if (dadosValidos(descricao, valor, mes)) {
            Lancamento lancamento = new Lancamento(descricao, valor, mes);

            lancamentos.add(lancamento);

            return lancamento;
        }
        return null;
    }

    public Lancamento registrarDespesa(String descricao, double valor, int mes, int categoria) {
        if (dadosValidos(descricao, valor, mes) && categoriaValida(categoria)) {
            Lancamento lancamento = new Lancamento(descricao, valor, mes, categoria);

            lancamentos.add(lancamento);

            return lancamento;
        }

        return null;
    }

    public boolean remover(int id) {
        return lancamentos.removeIf(lanc -> lanc.getId() == id);
    }

    public double saldo() {
        double valor = 0;
        for (Lancamento lancamento : lancamentos) {
            if (!lancamento.isReceita()) {
                valor -= lancamento.getValor();
            } else {
                valor += lancamento.getValor();
            }
        }
        return valor;
    }

    public double saldo(int mes) {
        if (!mesValido(mes)) {
            return 0;

        }

        double valor = 0;
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getMes() == mes) {
                if (!lancamento.isReceita()) {
                    valor -= lancamento.getValor();
                } else {
                    valor += lancamento.getValor();
                }
            }
        }
        return valor;
    }

    public double totalDespesas(int mes, int categoria) {
        if (!mesValido(mes) || !categoriaValida(categoria)) {
            return 0;
        }

        double valor = 0;
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getCategoria() == categoria && lancamento.getMes() == mes && !lancamento.isReceita()) {
                valor += lancamento.getValor();
            }
        }
        return valor;
    }

    public boolean definirLimite(int categoria, double limite) {
        if (!categoriaValida(categoria) || limite < 0) {
            return false;
        }

        limites[categoria] = limite;

        return true;
    }

    public double getLimite(int categoria) {
        if (!categoriaValida(categoria)) {
            return 0;
        }
        return limites[categoria];
    }

    public boolean ultrapassouLimite(int mes, int categoria) {
        if (!mesValido(mes) || !categoriaValida(categoria)) {
            return false;
        }

        double totalGasto = totalDespesas(mes, categoria);

        return limites[categoria] > 0 && limites[categoria] < totalGasto;
    }

    public List<Lancamento> lancamentosDoMes(int mes) {
        if (!mesValido(mes)) {
            return List.of();
        }

        return lancamentos.stream().filter(lanc -> lanc.getMes() == mes).toList();
    }

    public List<Lancamento> getLancamentos() {
        return List.copyOf(lancamentos);
    }

    public double[][] despesasPorCategoriaEMes() {
        double[][] matriz = new double[CATEGORIAS.length][MESES];

        for (int i = 0; i < CATEGORIAS.length; i++) {
            for (int j = 1; j <= MESES; j++) {
                double totalDespesasNoMes = totalDespesas(j, i);

                matriz[i][j - 1] = totalDespesasNoMes;
            }
        }
        return matriz;
    }

    public String getTitular() {
        return titular;
    }
}
