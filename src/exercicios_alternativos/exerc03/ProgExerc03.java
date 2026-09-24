package exercicios_alternativos.exerc03;

import java.util.Scanner;

public class ProgExerc03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // Fileiras
        int n = sc.nextInt(); // Cadeiras
        int[][] sala = new int[m][n];

        // Fazer o cadastro de fileiras e cadeiras já ocupadas
        for(int i = 0; i < m; i++){ // Fileiras
            for(int j = 0; j < n; j++){ // Cadeiras
                sala[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt(); // Quantidade de pedidos de reserva

        for(int i = 0; i < k; i++){
            int fileira = sc.nextInt();
            int cadeira = sc.nextInt();

            if (fileira >= 0 && fileira < m && cadeira >= 0 && cadeira < n) {
                if (sala[fileira][cadeira] == 1) {
                    System.out.printf("Fileira %d cadeira %d: OCUPADO%n", fileira, cadeira);
                } else {
                    sala[fileira][cadeira] = 1;
                    System.out.printf("Fileira %d cadeira %d: RESERVADO%n", fileira, cadeira);
                }
            } else {
                System.out.printf("Fileira %d cadeira %d: INVALIDO%n", fileira, cadeira);
            }

        }

        System.out.println("MAPA:");
        for (int i = 0; i < sala.length; i++){
            for (int j = 0; j < sala[i].length; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(sala[i][j] == 1 ? "X" : ".");
            }
            System.out.println();
        }

        System.out.println("OCUPADAS POR FILEIRA:");

        int totalOcupadas = 0;
        int fileiraMaisLivre = 0;
        int maiorQuantidadeLivre = -1;

        for (int i = 0; i < sala.length; i++){
            int count = 0;
            for (int j = 0; j < sala[i].length; j++){
                if (sala[i][j] == 1){
                    count++;

                }
            }
            totalOcupadas += count;

            int livres = sala[i].length - count;         // (6) livres sem novo laço
            if (livres > maiorQuantidadeLivre) {         // (7) máximo com índice
                maiorQuantidadeLivre = livres;
                fileiraMaisLivre = i;
            }

            System.out.printf("Fileira %d: %d%n", i, count);
        }

        double porcetangemOcupacao = (double) totalOcupadas / (m * n) * 100;
        System.out.printf("OCUPACAO: %.1f%%%n",  porcetangemOcupacao);

        System.out.printf("FILEIRA MAIS LIVRE: %d%n", fileiraMaisLivre);
        sc.close();
    }
}
