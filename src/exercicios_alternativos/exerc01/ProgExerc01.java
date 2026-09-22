package exercicios_alternativos.exerc01;

import java.util.Locale;
import java.util.Scanner;

public class ProgExerc01 {
    public static final double LIMITE_ALERTA = -18.0;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        double[] temp = new double[n];
//        int alertas = 0;
//
//        for(int i = 0; i < n; i++){
//            temp[i] = sc.nextDouble();
//
//            if (temp[i] > -18){
//                alertas++;
//            }
//        }
//
//        double menorTemp = temp[0];
//        int horaMenorTemp = 0;
//
//        double maiorTemp = temp[0];
//        int horaMaiorTemp = 0;
//
//        double somaTemp = 0.0;
//
//
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] < menorTemp) {
//                menorTemp = temp[i];
//                horaMenorTemp = i;
//            }
//        }
//
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] > maiorTemp) {
//                maiorTemp = temp[i];
//                horaMaiorTemp = i;
//            }
//        }
//
//
//        for (int i = 0; i < temp.length; i++) {
//            somaTemp += temp[i];
//        }
//
//        double mediaTemp = somaTemp / n;
//
//        System.out.printf("MENOR TEMPERATURA = %.1f (hora %d)\n",  menorTemp, horaMenorTemp);
//        System.out.printf("MAIOR TEMPERATURA = %.1f (hora %d)\n",  maiorTemp, horaMaiorTemp);
//        System.out.printf("MEDIA = %.2f%n", mediaTemp);
//        System.out.printf("ALERTAS = %d\n", alertas);
//
//        if (alertas > 0) {
//            for (int i = 0; i < temp.length; i++) {
//                if (temp[i] > -18) {
//                    System.out.printf("Hora %d: %.1f%n", i, temp[i]);
//                }
//            }
//        } else {
//            System.out.println("NENHUM ALERTA");
//        }

        // Código ajustado

        int n = sc.nextInt();
        double[] temp = new double[n];
        int qtdAlertas = 0;

        for(int i = 0; i < n; i++){
            temp[i] = sc.nextDouble();

            if (temp[i] > LIMITE_ALERTA){
                qtdAlertas++;
            }
        }

        double menorTemp = temp[0];
        int horaMenorTemp = 0;

        double maiorTemp = temp[0];
        int horaMaiorTemp = 0;

        double somaTemp = 0.0;


        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < menorTemp) {
                menorTemp = temp[i];
                horaMenorTemp = i;
            }

            if (temp[i] > maiorTemp) {
                maiorTemp = temp[i];
                horaMaiorTemp = i;
            }

            somaTemp += temp[i];
        }


        double mediaTemp = somaTemp / n;

        System.out.printf("MENOR TEMPERATURA = %.1f (hora %d)%n",  menorTemp, horaMenorTemp);
        System.out.printf("MAIOR TEMPERATURA = %.1f (hora %d)%n",  maiorTemp, horaMaiorTemp);
        System.out.printf("MEDIA = %.2f%n", mediaTemp);


        if (qtdAlertas > 0) {
            System.out.printf("ALERTAS: %d%n", qtdAlertas);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > LIMITE_ALERTA) {
                    System.out.printf("Hora %d: %.1f%n", i, temp[i]);
                }
            }
        } else {
            System.out.println("NENHUM ALERTA");
        }

        sc.close();
    }
}
