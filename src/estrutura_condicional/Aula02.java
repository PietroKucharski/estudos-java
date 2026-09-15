package estrutura_condicional;

import java.util.Locale;
import java.util.Scanner;

public class Aula02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        int minutos = input.nextInt();

        double conta = 50;

        if (minutos > 100) {
            // Operador de atribuição acumulativa
            conta += (minutos - 100) * 2;
        }

        System.out.printf("Valor da conta = R$ %.2f%n", conta);

        input.close();
    }
}
