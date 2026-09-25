package exercicios_alternativos.exerc12.entities;

public class Veiculo {
    private static final double PRIMEIRA_HORA = 5.00;
    private static final double HORA_ADICIONAL = 3.00;
    private final String placa;
    private final int horaEntrada;

    public Veiculo(String placa, int horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public double valorAPagar(int horaSaida) {
        int horas = horaSaida - horaEntrada;

        if (horas == 0 || horas == 1) {
            return PRIMEIRA_HORA;
        } else {
            return PRIMEIRA_HORA + (horas - 1) * HORA_ADICIONAL;
        }
    }
}
