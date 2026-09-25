package exercicios_alternativos.exerc11.entities;

public class Emprestimo {
    private static final double MULTA_POR_DIA = 1.50;
    private final int codigoDoLivro;
    private String nomeAluno;
    private int diaPrevisto;

    public Emprestimo(int codigoDoLivro, String nomeAluno, int diaPrevisto) {
        this.codigoDoLivro = codigoDoLivro;
        this.nomeAluno = nomeAluno;
        this.diaPrevisto = diaPrevisto;
    }

    public int getCodigoDoLivro() {
        return codigoDoLivro;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public int getDiaPrevisto() {
        return diaPrevisto;
    }

    public boolean estaAtrasado(int diaAtual) {
        return diaAtual > diaPrevisto;
    }

    public int diasDeAtraso(int diaAtual) {
        if (estaAtrasado(diaAtual)) {
            return diaAtual - diaPrevisto;
        }
        return 0;
    }

    public double multa(int diaDevolucao) {
        int diasDeAtraso = diasDeAtraso(diaDevolucao);

        return MULTA_POR_DIA * diasDeAtraso;
    }
}
