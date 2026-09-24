package exercicios_alternativos.exerc07.application;

import exercicios_alternativos.exerc07.entities.Cabinet;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc07 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // um inteiro K, a quantidade de operações;
        int k = sc.nextInt();
        Cabinet[] cabinets = new Cabinet[10];

        for (int i = 0; i < k; i++) {
            char operacao = sc.next().charAt(0);
            int armario = sc.nextInt();

            if (armario < 0 || armario >= cabinets.length) {
                System.out.println("ARMARIO INVALIDO");
                sc.nextLine();
            } else {
                switch (operacao) {
                    case 'G':
                        int horaEntrada = sc.nextInt();
                        String nome = sc.nextLine().trim();

                        if (cabinets[armario] == null) {
                            cabinets[armario] = new Cabinet(armario, horaEntrada, nome);
                            System.out.printf("GUARDADO NO ARMARIO %d%n", armario);
                        } else {
                            System.out.printf("ARMARIO %d JA OCUPADO%n", armario);

                        }
                        break;
                    case 'R':
                        int horaDeSaida = sc.nextInt();

                        if (cabinets[armario] == null) {
                            System.out.printf("ARMARIO %d VAZIO%n", armario);
                        } else {
                            System.out.printf("ARMARIO %d LIBERADO - %s - R$ %.2f%n", armario, cabinets[armario].getNome(), cabinets[armario].valorAPagar(horaDeSaida));
                            cabinets[armario] = null;
                        }
                        break;
                }

            }

        }

        System.out.println("OCUPADOS:");
        int countLivres = 0;

        for (int i = 0; i < cabinets.length; i++) {

            if (cabinets[i] != null) {
                System.out.printf("%d: %s (entrada %dh)%n", i, cabinets[i].getNome(), cabinets[i].getHoraEntrada());
            } else {
                countLivres++;
            }

        }
        System.out.printf("LIVRES: %d%n", countLivres);


        sc.close();
    }
}
