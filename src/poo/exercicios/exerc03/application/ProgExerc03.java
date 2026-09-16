package poo.exercicios.exerc03.application;

import poo.exercicios.exerc03.entities.Student;

import java.util.Locale;
import java.util.Scanner;

/*
Fazer um programa para ler o nome de um aluno e as três notas que ele obteve nos três trimestres do ano
(primeiro trimestre vale 30 e o segundo e terceiro valem 35 cada). Ao final, mostrar qual a nota final do aluno no
ano. Dizer também se o aluno está aprovado (PASS) ou não (FAILED) e, em caso negativo, quantos pontos faltam
para o aluno obter o mínimo para ser aprovado (que é 60% da nota). Você deve criar uma classe Studentpara
resolver este problema.
*/
public class ProgExerc03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
//
//        student.name = sc.nextLine();
//        student.grade1 = sc.nextDouble();
//        student.grade2 = sc.nextDouble();
//        student.grade3 = sc.nextDouble();
//
//        if (student.verificarAprovacao().equals("PASS")) {
//            System.out.println("FINAL GRADE = " + student.finalGrade);
//            System.out.println(student.verificarAprovacao());
//        } else {
//            System.out.println("FINAL GRADE = " + student.finalGrade);
//            System.out.println(student.verificarAprovacao());
//            System.out.println("MISSING " + student.calcularPontosFaltantes() + " POINTS");
//        }

        // Melhoria
        student.name = sc.nextLine();
        student.grade1 = sc.nextDouble();
        student.grade2 = sc.nextDouble();
        student.grade3 = sc.nextDouble();

        System.out.printf("FINAL GRADE = %.2f%n", student.finalGrade());

        if (student.finalGrade() < 60.0) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS%n", student.missingPoints());
        } else {
            System.out.println("PASS");
        }

        sc.close();
    }
}
