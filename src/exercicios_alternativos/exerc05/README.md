## Exercício 5 — Refatorando o Relatório de Vendas

**Nível:** Básico

**Assuntos praticados:**

* métodos estáticos com parâmetros e retorno;
* constantes com `static final`;
* nomes significativos;
* eliminação de duplicação.
  **Objetivo:**
  Aprender a dividir um `main` grande em métodos com uma única responsabilidade, sem alterar o comportamento do programa.

**Enunciado:**
O código abaixo funciona, mas é difícil de ler e manter. Refatore-o.

```java
import java.util.Locale;
import java.util.Scanner;
 
public class Vendas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] v = new double[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextDouble();
        }
        double s = 0;
        for (int i = 0; i < n; i++) {
            s = s + v[i];
        }
        double m = s / n;
        double mv = v[0];
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] > mv) {
                mv = v[i];
                d = i;
            }
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] > m) {
                c = c + 1;
            }
        }
        double s2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] > 1000) {
                s2 = s2 + v[i] * 0.02;
            } else {
                s2 = s2 + v[i] * 0.01;
            }
        }
        System.out.printf("TOTAL = %.2f%n", s);
        System.out.printf("MEDIA = %.2f%n", m);
        System.out.printf("MELHOR DIA = %d (%.2f)%n", d + 1, mv);
        System.out.printf("DIAS ACIMA DA MEDIA = %d%n", c);
        System.out.printf("COMISSAO = %.2f%n", s2);
        sc.close();
    }
}
```

**Entrada:**
Igual à do código original: **N** (quantidade de dias) e o valor vendido em cada dia.

**Processamento (requisitos da refatoração):**

* a saída deve continuar **idêntica** à do código original;
* crie métodos estáticos para: ler o vetor, calcular o total, encontrar o índice do melhor dia, contar dias acima de um valor e calcular a comissão;
* o `main` deve apenas ler, chamar os métodos e imprimir, sem nenhum laço;
* substitua `1000`, `0.02` e `0.01` por constantes com nomes que expliquem o que significam;
* renomeie todas as variáveis de uma letra.
  **Saída esperada:**
  A mesma do código original.

**Exemplo:**

```text
Entrada:
5
800.00 1200.00 950.00 1500.00 600.00
 
Saída:
TOTAL = 5050.00
MEDIA = 1010.00
MELHOR DIA = 4 (1500.00)
DIAS ACIMA DA MEDIA = 2
COMISSAO = 77.50
```

Além do código, responda: qual método você achou mais difícil de nomear, e por quê?