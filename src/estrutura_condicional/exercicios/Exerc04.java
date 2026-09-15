package estrutura_condicional.exercicios;

import java.util.Scanner;

/*
Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode
começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.
*/
public class Exerc04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int horaIncial, horaFinal, duracao;

        horaIncial = input.nextInt();
        horaFinal = input.nextInt();

        if (horaIncial < horaFinal) {
            duracao = horaFinal - horaIncial;
        } else {
            duracao = 24 - horaIncial + horaFinal;
        }

        System.out.printf("O jogo durou %d hora(s)", duracao);

        input.close();
    }
}
