package exercicios_alternativos.exerc12.application;

import exercicios_alternativos.exerc12.entities.Veiculo;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc12 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // dois inteiros F e V;
        int f = sc.nextInt();
        int v = sc.nextInt();
        Veiculo[][] estacionamento = new Veiculo[f][v];

        // um inteiro K, a quantidade de operações;
        // K operações, uma por linha:
        // E placa hora → entrada;
        // S placa hora → saída.

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            char operacao = sc.next().charAt(0);
            String placa = sc.next();
            int hora = sc.nextInt();

            switch (operacao) {
                case 'E':
                    // 'E' com uma placa que já está estacionada → recusa;
                    if (buscarPorPlaca(estacionamento, placa) != null) {
                        System.out.printf("VEICULO JA ESTACIONADO: %s%n", placa);
                    } else {
                        int[] vagaLivre = buscarVagaLivre(estacionamento);
                        if (vagaLivre != null) {
                            int fileira = vagaLivre[0];
                            int coluna = vagaLivre[1];

                            estacionamento[fileira][coluna] = new Veiculo(placa, hora);

                            System.out.printf("ESTACIONADO: %s na vaga %d-%d%n", placa, fileira, coluna);
                        } else {
                            System.out.println("ESTACIONAMENTO LOTADO");
                        }
                    }
                    break;
                case 'S':
                    int[] posicao = buscarPorPlaca(estacionamento, placa);

                    if (posicao != null) {
                        int fileira = posicao[0];
                        int coluna = posicao[1];

                        Veiculo veiculo = estacionamento[fileira][coluna];
                        double valorAPagar = veiculo.valorAPagar(hora);
                        int horasPermanecidas = hora - veiculo.getHoraEntrada();

                        System.out.printf("SAIDA: %s - vaga %d-%d - %dh - R$ %.2f%n", placa, fileira, coluna, horasPermanecidas, valorAPagar);

                        estacionamento[fileira][coluna] = null;
                    } else {
                        System.out.printf("VEICULO NAO ENCONTRADO: %s%n", placa);
                    }
                    break;
            }
        }

        System.out.println("OCUPADAS:");
        int qtdVagasLivres = 0;

        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento[i].length; j++) {
                if (estacionamento[i][j] == null) {
                    qtdVagasLivres++;
                } else {
                    Veiculo veiculo = estacionamento[i][j];
                    System.out.printf("%d-%d: %s (entrada %dh)%n", i, j, veiculo.getPlaca(), veiculo.getHoraEntrada());
                }
            }
        }

        System.out.printf("LIVRES: %d%n", qtdVagasLivres);

        sc.close();
    }

    public static int[] buscarVagaLivre(Veiculo[][] estacionamento) {
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento[i].length; j++) {
                if (estacionamento[i][j] == null) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] buscarPorPlaca(Veiculo[][] estacionamento, String placa) {
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento[i].length; j++) {
                if (estacionamento[i][j] != null && placa.equals(estacionamento[i][j].getPlaca())) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
