package exercicios_alternativos.exerc07.entities;

public class Cabinet {
    private String nome;
    private int armario;
    private int horaEntrada;
    private static final int HORA_LIMITE = 2;
    private static final double VALOR_COBRANCA = 3.00;

    public Cabinet(int armario, int horaEntrada, String nome) {
        this.armario = armario;
        this.horaEntrada = horaEntrada;
        this.nome = nome;
    }

    public double valorAPagar(int horaSaida) {
        int horasDeUso = horaSaida - horaEntrada;

        if (horasDeUso > HORA_LIMITE) {
            int horasExcedentes = horasDeUso - HORA_LIMITE;
            return horasExcedentes * VALOR_COBRANCA;
        }

        return 0.0;
    }

    public String getNome() {
        return nome;
    }

    public int getArmario() {
        return armario;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }
}
