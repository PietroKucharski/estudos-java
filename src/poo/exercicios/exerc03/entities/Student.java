package poo.exercicios.exerc03.entities;

public class Student {
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;
//    public double finalGrade;

//    public double notaFinal() {
//        finalGrade = grade1 + grade2 + grade3;
//        return finalGrade;
//    }

//    public String verificarAprovacao() {
//        if (notaFinal() >= 60) {
//            return "PASS";
//        } else {
//            return "FAILED";
//        }
//    }
//
//    public double calcularPontosFaltantes() {
//        return 60 - notaFinal();
//    }

    // Melhorias
    public double finalGrade() {
        return grade1 + grade2 + grade3;
    }

    public double missingPoints() {
        if (finalGrade() < 60.0) {
            return 60.0 - finalGrade();
        } else {
            return 0.0;
        }
    }
}
