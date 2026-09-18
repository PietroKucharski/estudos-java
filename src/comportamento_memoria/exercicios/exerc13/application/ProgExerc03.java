package comportamento_memoria.exercicios.exerc13.application;

import comportamento_memoria.exercicios.exerc13.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro **N** e, depois, os dados (**id, nome e salário**) de **N funcionários**.

Não deve haver repetição de **id**.

Em seguida, efetuar o aumento de **X%** no salário de um determinado funcionário. Para isso, o programa deve ler um **id** e o valor **X**.

Se o **id informado não existir**, mostrar uma mensagem e abortar a operação.

Ao final, mostrar a **listagem atualizada dos funcionários**, conforme os exemplos.

Lembre-se de aplicar a técnica de **encapsulamento** para não permitir que o salário possa ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de **aumento por porcentagem** dada.
*/

public class ProgExerc03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int numberOfEmployees = sc.nextInt();

        Employee employee;
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee #%d: \n", i + 1);

            System.out.print("Id: ");
            int id = sc.nextInt();

            while(hasId(employeeList, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            System.out.println();
            employeeList.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Employee emp = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();

            emp.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees: ");
        for (Employee e : employeeList) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> employeeList, int id) {
        Employee emp = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
